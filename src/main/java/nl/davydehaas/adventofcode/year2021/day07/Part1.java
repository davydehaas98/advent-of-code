package nl.davydehaas.adventofcode.year2021.day07;

import nl.davydehaas.adventofcode.year2021.Year2021;

import java.util.Arrays;
import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

class Part1 extends Year2021 {
    
    private static final List<String> INPUT = readFile("/day07.txt");
    
    public static void main(String[] args) {
        timeSolution(Part1::calculate);
    }
    
    static Number calculate() {
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
        return Arrays.stream(INPUT.get(0).split(","))
                .map(Integer::parseInt)
                .sorted()
                .toList();
    }
}
