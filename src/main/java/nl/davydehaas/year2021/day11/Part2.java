package nl.davydehaas.year2021.day11;

import nl.davydehaas.utils.InputReader;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Part2 {
    static int[][] octopuses;
    
    public static void main(String[] args) {
        octopuses = getOctopuses();
        int stepCounter = 0;
        
        do {
            stepCounter++;
        } while (simulateStep() < octopuses.length * octopuses[0].length);
        
        System.out.println("The first step where all the octopuses flash simultaniously is:");
        System.out.println(stepCounter);
    }
    
    private static void flashOctopus(int column, int row, List<Point> flashedOctopuses) {
        if (octopuses[column][row] > 9 && !flashedOctopuses.contains(new Point(column, row))) {
            flashedOctopuses.add(new Point(column, row));
            
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    try {
                        octopuses[column + i][row + j] += 1;
                        flashOctopus(column + i, row + j, flashedOctopuses);
                    } catch (IndexOutOfBoundsException ignored) {
                    }
                }
            }
        }
    }
    
    private static int simulateStep() {
        // Increase all octopuses its energy levels by 1
        for (int column = 0; column < octopuses.length; column++) {
            for (int row = 0; row < octopuses[0].length; row++) {
                octopuses[column][row] += 1;
            }
        }
        // Calculate flashing
        List<Point> flashedOctopuses = new ArrayList<>();
        
        for (int column = 0; column < octopuses.length; column++) {
            for (int row = 0; row < octopuses[0].length; row++) {
                flashOctopus(column, row, flashedOctopuses);
            }
        }
        // Set energy level to 0 for all flashed octopuses
        flashedOctopuses.forEach(f -> octopuses[f.x][f.y] = 0);
        
        return flashedOctopuses.size();
    }
    
    private static int[][] getOctopuses() {
        List<String> lines = InputReader.readFile("/year2021/day11-input.txt");
        int[][] octopuses = new int[lines.size()][lines.get(0).length()];
        
        for (int column = 0; column < octopuses[0].length; column++)
            for (int row = 0; row < octopuses.length; row++)
                octopuses[row][column] = Integer.parseInt(String.valueOf(lines.get(row).charAt(column)));
        
        return octopuses;
    }
}
