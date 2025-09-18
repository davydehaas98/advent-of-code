package nl.davydehaas.adventofcode.year2021.day07;

import java.util.Arrays;
import java.util.List;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part2 {
    
    private static final List<String> INPUT = readFile(2021, 7);
    
    void main() {
        timeSolution(Part2::solve);
    }
    
    static Number solve() {
        List<Integer> crabPositions = getCrabPositions();
        int bestCost = Integer.MAX_VALUE;
        // Try each position
        for (int i = 0; i < crabPositions.size(); i++) {
            int cost = 0;
            // Calculate total cost
            for (Integer crabPosition : crabPositions) {
                int difference = Math.abs(crabPosition - i);
                // Calculate fuel consumption
                cost += fuelConsumption(difference);
            }
            
            bestCost = Math.min(cost, bestCost);
        }
        
        return bestCost;
    }
    
    private static Integer fuelConsumption(int difference) {
        int fuelConsumption = 0;
        
        for (int j = 1; j < difference + 1; j++) {
            fuelConsumption += j;
        }
        
        return fuelConsumption;
    }
    
    private static List<Integer> getCrabPositions() {
        return Arrays.stream(INPUT.getFirst().split(","))
                .map(Integer::parseInt)
                .sorted()
                .toList();
    }
}
