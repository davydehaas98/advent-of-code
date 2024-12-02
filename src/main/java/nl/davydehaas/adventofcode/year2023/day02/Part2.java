package nl.davydehaas.adventofcode.year2023.day02;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.List;

class Part2 {

    private static final List<String> INPUT = readFile(2023, 2);

    private static int MAX_RED_CUBES = 0;
    private static int MAX_GREEN_CUBES = 0;
    private static int MAX_BLUE_CUBES = 0;

    public static void main(String[] args) {
        timeSolution(Part1::solve);
    }

    static int calculate() {
        int sum = 0;

        for (String game : INPUT) {
            sum += calculateGame(game);
        }

        return sum;
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
        // { "4", "green" }
        String[] cubeColor = cube.split(" ");
        int cubeAmount = Integer.parseInt(cubeColor[0]);
        switch (cubeColor[1]) {
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
}
