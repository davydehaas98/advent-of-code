package nl.davydehaas.adventofcode.year2021.day11;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.ArrayList;
import java.util.List;

class Part2 {

    private static final List<String> INPUT = readFile(2021, 11);

    private static int[][] octopuses;

    public static void main(String[] args) {
        timeSolution(Part2::solve);
    }

    static int solve() {
        octopuses = getOctopuses();
        int stepCounter = 0;

        do {
            stepCounter++;
        } while (simulateStep() < octopuses.length * octopuses[0].length);

        return stepCounter;
    }

    private static int[][] getOctopuses() {
        int[][] octopuses = new int[INPUT.size()][INPUT.getFirst().length()];

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
        flashedOctopuses.forEach(f -> octopuses[f.column][f.row] = 0);

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

    record Point(int column, int row) {
    }
}
