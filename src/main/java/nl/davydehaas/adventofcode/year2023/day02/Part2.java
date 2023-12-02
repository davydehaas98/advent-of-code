package nl.davydehaas.adventofcode.year2023.day02;

import nl.davydehaas.adventofcode.utils.InputReader;

import java.util.List;

public class Part2 {
    
    private static int MAX_RED_CUBES = 0;
    private static int MAX_GREEN_CUBES = 0;
    private static int MAX_BLUE_CUBES = 0;
    
    public static void main(String[] args) {
        int result = calculate();
        System.out.println("What is the sum of the power of these sets?");
        System.out.println(result);
    }
    
    static int calculate() {
        List<String> input = getGames();
        
        return input.stream()
                .mapToInt(Part2::calculateGame)
                .sum();
    }
    
    private static int calculateGame(String game) {
        String[] cubeSets = game.substring(game.indexOf(":") + 2).split("; ");
        MAX_RED_CUBES = 0;
        MAX_GREEN_CUBES = 0;
        MAX_BLUE_CUBES = 0;
        
        for (String cubeSet : cubeSets) {
            for (String cube : cubeSet.split(", ")) {
                isPossibleCube(cube);
            }
        }
        return MAX_RED_CUBES * MAX_GREEN_CUBES * MAX_BLUE_CUBES;
    }
    
    private static void isPossibleCube(String cube) {
        String cubeColor = cube.substring(cube.indexOf(" ") + 1);
        int cubeAmount = Integer.parseInt(cube.substring(0, cube.indexOf(" ")));
        switch (cubeColor) {
            case "red" -> {
                if (cubeAmount > MAX_RED_CUBES) {
                    MAX_RED_CUBES = cubeAmount;
                }
            }
            case "green" -> {
                if (cubeAmount > MAX_GREEN_CUBES) {
                    MAX_GREEN_CUBES = cubeAmount;
                }
            }
            case "blue" -> {
                if (cubeAmount > MAX_BLUE_CUBES) {
                    MAX_BLUE_CUBES = cubeAmount;
                }
            }
        }
    }
    
    private static List<String> getGames() {
        return InputReader.readFile("/year2023/day02-input.txt");
    }
}
