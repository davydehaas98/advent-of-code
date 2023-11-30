package nl.davydehaas.adventofcode.year2021.day07;

import nl.davydehaas.adventofcode.utils.InputReader;

import java.util.Arrays;
import java.util.List;

public class Part2 {
    public static void main(String[] args) {
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
        
        System.out.println("The least amount of fuel crabs spend to get in position is:");
        System.out.println(bestCost);
    }
    
    private static Integer fuelConsumption(int difference) {
        int fuelConsumption = 0;
        
        for (int j = 1; j < difference + 1; j++) {
            fuelConsumption += j;
        }
        
        return fuelConsumption;
    }
    
    private static List<Integer> getCrabPositions() {
        return Arrays.stream(InputReader.readFile("/year2021/day07-input.txt").get(0).split(","))
                .map(Integer::parseInt)
                .sorted()
                .toList();
    }
}
