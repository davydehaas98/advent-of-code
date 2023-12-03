package nl.davydehaas.adventofcode.year2021.day11;

import nl.davydehaas.adventofcode.year2021.Year2021;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

class Part1 extends Year2021 {
    
    private static final List<String> INPUT = readFile("/day11.txt");
    
    private static int[][] octopuses;
    
    public static void main(String[] args) {
        timeSolution(Part1::calculate);
    }
    
    static int calculate() {
        octopuses = getOctopuses();
        int steps = 100;
        int flashCounter = 0;
        
        for (int i = 0; i < steps; i++) {
            flashCounter += simulateStep();
        }
        
        return flashCounter;
    }
    
    private static int[][] getOctopuses() {
        int[][] octopuses = new int[INPUT.size()][INPUT.get(0).length()];
        
        for (int column = 0; column < octopuses[0].length; column++) {
            for (int row = 0; row < octopuses.length; row++) {
                octopuses[row][column] = Integer.parseInt(String.valueOf(INPUT.get(row).charAt(column)));
            }
        }
        return octopuses;
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
}
