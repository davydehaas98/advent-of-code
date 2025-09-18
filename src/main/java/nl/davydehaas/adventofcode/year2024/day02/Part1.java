package nl.davydehaas.adventofcode.year2024.day02;

import java.util.Arrays;
import java.util.List;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part1 {

    private static final List<String> INPUT = readFile(2024, 2);
    
    void main() {
        timeSolution(Part1::solve);
    }

    static int solve() {
        int safeReports = 0;

        for (String line : INPUT) {
            Integer[] report = Arrays.stream(line.split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            boolean increasing = report[0] < report[1];
            for (int i = 0; i < report.length; i++) {
                int currentLevel = report[i];
                int nextLevel = report[i + 1];

                int difference;
                if (increasing) {
                    difference = nextLevel - currentLevel;
                } else {
                    difference = currentLevel - nextLevel;
                }
                if (difference < 1 || difference > 3) {
                    break;
                }

                if (i == report.length - 2) {
                    safeReports++;
                    break;
                }
            }
        }
        return safeReports;
    }
}
