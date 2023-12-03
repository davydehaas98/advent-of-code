package nl.davydehaas.adventofcode.year2021.day07;

import nl.davydehaas.adventofcode.year2021.Year2021;

import java.util.Arrays;
import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

class Part2 extends Year2021 {
    
    private static final List<String> INPUT = readFile("/day07.txt");
    
    public static void main(String[] args) {
        timeSolution(Part2::calculate);
    }
    
    static int calculate() {
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
        return Arrays.stream(INPUT.get(0).split(","))
                .map(Integer::parseInt)
                .sorted()
                .toList();
    }
}
