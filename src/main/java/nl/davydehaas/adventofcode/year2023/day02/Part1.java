package nl.davydehaas.adventofcode.year2023.day02;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.List;

class Part1 {

    private static final List<String> INPUT = readFile(2023, 2);

    private static final int MAX_RED_CUBES = 12;
    private static final int MAX_GREEN_CUBES = 13;
    private static final int MAX_BLUE_CUBES = 14;

    public static void main(String[] args) {
        timeSolution(Part1::solve);
    }

    static Number solve() {
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
