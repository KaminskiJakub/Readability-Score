package readability;

public enum AlgorithmsNames {
    ALL("all"),
    ARI("Automated Readability Index"),
    CL("Coleman–Liau index"),
    FK("Flesch–Kincaid readability tests"),
    SMOG("Simple Measure of Gobbledygook");

    private final String algorithmsName;

    AlgorithmsNames(String algorithmsName) {
        this.algorithmsName = algorithmsName;
    }

    public String getAlgorithmsName() {
        return algorithmsName;
    }
}