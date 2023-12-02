package nl.davydehaas.adventofcode.year2023.day02;

import nl.davydehaas.adventofcode.utils.InputReader;
import nl.davydehaas.adventofcode.year2020.Year2020;

import java.util.List;

public class Part1 extends Year2020 {
    
    private static final int MAX_RED_CUBES = 12;
    private static final int MAX_GREEN_CUBES = 13;
    private static final int MAX_BLUE_CUBES = 14;
    
    
    public static void main(String[] args) {
        int result = calculate();
        System.out.println("What is the sum of the IDs of those games?");
        System.out.println(result);
    }
    
    static int calculate() {
        List<String> input = getGames();
        
        return input.stream()
                .filter(Part1::isPossibleGame)
                .mapToInt(game -> Integer.parseInt(game.substring(5, game.indexOf(":"))))
                .sum();
    }
    
    private static boolean isPossibleGame(String game) {
        String[] cubeSets = game.substring(game.indexOf(":") + 2).split("; ");
        
        for (String cubeSet : cubeSets) {
            for (String cube : cubeSet.split(", ")) {
                if (!isPossibleCube(cube)) {
                    return false;
                }
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
    
    private static List<String> getGames() {
        return InputReader.readFile("/year2023/day02-input.txt");
    }
}
