package nl.davydehaas.adventofcode.year2020.day02;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.ArrayList;
import java.util.List;

class Part2 {

    private static final List<String> INPUT = readFile(2020, 2);

    public static void main(String[] args) {
        timeSolution(Part2::solve);
    }

    static Number solve() {
        List<String[]> policies = getPolicies();
        int validPasswordCounter = 0;

        for (String[] policy : policies) {
            int firstPosition = Integer.parseInt(policy[0]) - 1;
            int secondPosition = Integer.parseInt(policy[1]) - 1;
            char letter = policy[2].charAt(0);
            String password = policy[3];
            // Check positions of letter
            if (password.charAt(firstPosition) == letter && password.charAt(secondPosition) != letter) {
                validPasswordCounter++;
            } else if (password.charAt(firstPosition) != letter && password.charAt(secondPosition) == letter) {
                validPasswordCounter++;
            }
        }

        return validPasswordCounter;
    }

    private static List<String[]> getPolicies() {
        List<String[]> policies = new ArrayList<>();

        for (String line : INPUT) {
            String[] lineArray = line.split(": ");
            String password = lineArray[1];

            lineArray = lineArray[0].split(" ");
            String letter = lineArray[1];

            lineArray = lineArray[0].split("-");
            String min = lineArray[0];
            String max = lineArray[1];

            policies.add(new String[]{min, max, letter, password});
        }

        return policies;
    }
}
