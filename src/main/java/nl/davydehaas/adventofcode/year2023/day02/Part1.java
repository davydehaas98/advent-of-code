package nl.davydehaas.adventofcode.year2023.day02;

import nl.davydehaas.adventofcode.year2023.Year2023;

import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

public class Part1 extends Year2023 {
    
    private static final List<String> INPUT = readFile("/day02.txt");
    
    private static final int MAX_RED_CUBES = 12;
    private static final int MAX_GREEN_CUBES = 13;
    private static final int MAX_BLUE_CUBES = 14;
    
    
    public static void main(String[] args) {
        timeSolution(Part1::calculate);
    }
    
    static int calculate() {
        int sum = 0;
        
        for (String game : INPUT) {
            if (isPossibleGame(game)) {
                sum += Integer.parseInt(game.substring(5, game.indexOf(":")));
            }
        }
        
        return sum;
    }
    
    private static boolean isPossibleGame(String game) {
        String[] cubes = game
                .substring(game.indexOf(":") + 2)
                .split("; |, ");
        
        for (String cube : cubes) {
            if (!isPossibleCube(cube)) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isPossibleCube(String cube) {
        String cubeColor = cube.substring(cube.indexOf(" ") + 1);
        int cubeAmount = Integer.parseInt(cube.substring(0, cube.indexOf(" ")));
        return switch (cubeColor) {
            case "red" -> cubeAmount <= MAX_RED_CUBES;
            case "green" -> cubeAmount <= MAX_GREEN_CUBES;
            case "blue" -> cubeAmount <= MAX_BLUE_CUBES;
            default -> false;
        };
    }
}
