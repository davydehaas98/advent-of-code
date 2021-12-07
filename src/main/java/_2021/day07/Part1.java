package _2021.day07;

import utils.FileReader;

import java.util.Arrays;
import java.util.List;

public class Part1 {
    public static void main(String[] args) {
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
    
        System.out.println("The least amount of fuel crabs spend to get in position is:");
        System.out.println(bestCost);
    }
    
    private static List<Integer> getCrabPositions() {
        return Arrays.stream(FileReader.readFile("/_2021/day07-input.txt").get(0).split(","))
                .map(Integer::parseInt)
                .sorted()
                .toList();
    }
}
