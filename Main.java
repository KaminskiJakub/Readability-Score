package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ReadabilityEstimator readabilityEstimator = new ReadabilityEstimator();
        System.out.println(readabilityEstimator.estimateReadabilityOfFile(args[0]));
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        String input = new Scanner(System.in).nextLine();
        System.out.println(readabilityEstimator.scoreCalculation(input));
    }
}