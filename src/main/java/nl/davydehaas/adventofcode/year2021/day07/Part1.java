package nl.davydehaas.adventofcode.year2021.day07;

import java.util.Arrays;
import java.util.List;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part1 {

    private static final List<String> INPUT = readFile(2021, 7);
    
    void main() {
        timeSolution(Part1::solve);
    }

    static Number solve() {
        List<Integer> crabPositions = getCrabPositions();
        int bestCost = Integer.MAX_VALUE;
        // Try each position
        for (int i = 0; i < crabPositions.size(); i++) {
            int cost = 0;
            // Calculate total cost
            for (Integer crabPosition : crabPositions) {
                cost += Math.abs(crabPosition - i);
            }
            bestCost = Math.min(cost, bestCost);
        }
        return bestCost;
    }

    private static List<Integer> getCrabPositions() {
        return Arrays.stream(INPUT.getFirst().split(","))
                .map(Integer::parseInt)
                .sorted()
                .toList();
    }
}
