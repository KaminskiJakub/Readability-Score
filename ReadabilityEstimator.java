package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadabilityEstimator {

    private String text;
    private int wordsCount;
    private int sentenceCount;
    private int characterCount;
    private int syllables;
    private int polysyllables;
    double score;
    double average;
    GradeLevel gradeLevel;
    String algorithmsName;
    StringBuilder stringBuilder;
    AlgorithmsNames algorithmsNames;
    String textFormat = "%s: %.2f (%s)\n";

    public String estimateReadabilityOfFile(String filePath) {
        readFile(filePath);
        if (text.isEmpty()) return "Failed to retrieve text.";
        countAllElementsFromText();
        return this.toString();
    }

    public String scoreCalculation(String string) {
        stringBuilder = new StringBuilder("\n");
        algorithmsNames = AlgorithmsNames.valueOf(string.toUpperCase());
        switch (algorithmsNames) {
            case ALL:
                algorithmsName = AlgorithmsNames.ALL.getAlgorithmsName();
            case ARI:
                score = calculateAriScore();
                algorithmsName = AlgorithmsNames.ARI.getAlgorithmsName();
                resultDependingOnAlgorithm();
                if (!algorithmsNames.equals(AlgorithmsNames.ALL)) break;
            case FK:
                score = calculateFkScore();
                algorithmsName = AlgorithmsNames.FK.getAlgorithmsName();
                resultDependingOnAlgorithm();
                if (!algorithmsNames.equals(AlgorithmsNames.ALL)) break;
            case SMOG:
                score = calculateSmogScore();
                algorithmsName = AlgorithmsNames.SMOG.getAlgorithmsName();
                resultDependingOnAlgorithm();
                if (!algorithmsNames.equals(AlgorithmsNames.ALL)) break;
            case CL:
                score = calculateClScore();
                algorithmsName = AlgorithmsNames.CL.getAlgorithmsName();
                resultDependingOnAlgorithm();
            default:
                stringBuilder.append("Invalid option!");
        }
        countAverageAgeOfUnderstandingAText();
        return stringBuilder.toString();
    }

    private void readFile(String filePath) {
        try {
            text = Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void countAverageAgeOfUnderstandingAText() {
        if (algorithmsNames == AlgorithmsNames.ALL)
            stringBuilder.append(String.format("\nThis text should be understood in average by %.2f year olds.", average / 4));
    }

    private void resultDependingOnAlgorithm() {
        gradeLevel = GradeLevel.getLevel(score);
        average = gradeLevel == null ? 0 : gradeLevel.getMaxAge();
        stringBuilder.append(String.format(textFormat, algorithmsName, score, gradeLevel));
    }

    private void countAllElementsFromText() {
        countWords();
        countSentences();
        countCharacters();
        countSyllables();
        countPolysyllables();
    }

    private void countWords() {
        wordsCount = text.split("[?.!\\s]+").length;
    }

    private void countSentences() {
        sentenceCount = text.split("[?.!]+").length;
    }

    private void countCharacters() {
        characterCount = text.replaceAll("[\\n\\s]+", "").length();
    }

    private void countSyllables() {
        syllables = text.split("[aeiouy]+[^$e(,.:;!?)]").length;
    }

    private void countPolysyllables() {
        polysyllables = text.split("([aeiouy]+[^$e(,.:;!?)]){3,}").length;
    }

    private double calculateAriScore() {
        return 4.71 * ((double) characterCount / wordsCount) + 0.5 * ((double) wordsCount / sentenceCount) - 21.43;
    }

    private double calculateFkScore() {
        return 0.39 * ((double) wordsCount / sentenceCount) + 11.8 * ((double) syllables / wordsCount) - 15.59;
    }

    private double calculateSmogScore() {
        return 1.043 * Math.sqrt((double) polysyllables * (30.0 / sentenceCount)) + 3.1291;
    }

    private double calculateClScore() {
        double l = (double) characterCount / wordsCount * 100;
        double s = (double) sentenceCount / wordsCount * 100;
        return 0.0588 * l - 0.296 * s - 15.8;
    }

    @Override
    public String toString() {
        return String.format("The text is: %s\n\nWords: %d\nSentences: %d" +
                        "\nCharacters: %d\nSyllables: %d\nPolysyllables: %d\n",
                text, wordsCount, sentenceCount, characterCount, syllables, polysyllables);
    }
}