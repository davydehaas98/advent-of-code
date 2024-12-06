package nl.davydehaas.adventofcode.year2021.day09;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.List;

class Part1 {

    private static final List<String> INPUT = readFile(2021, 9);

    private static int[][] heightMap;

    public static void main(String[] args) {
        timeSolution(Part1::solve);
    }

    static Number solve() {
        heightMap = getHeightMap();
        int sum = 0;

        for (int column = 0; column < heightMap.length; column++) {
            for (int row = 0; row < heightMap[0].length; row++) {
                if (isLowestPoint(column, row)) {
                    sum += heightMap[column][row] + 1;
                }
            }
        }

        return sum;
    }

    private static boolean isLowestPoint(int column, int row) {
        int maxColumnIndex = heightMap.length - 1;
        int maxRowIndex = heightMap[0].length - 1;
        int point = heightMap[column][row];

        int left = column - 1;
        if (left >= 0) {
            if (point >= heightMap[left][row]) {
                return false;
            }
        }

        int right = column + 1;
        if (right <= maxColumnIndex) {
            if (point >= heightMap[right][row]) {
                return false;
            }
        }
        int up = row - 1;
        if (up >= 0) {
            if (point >= heightMap[column][up]) {
                return false;
            }
        }

        int down = row + 1;
        if (down <= maxRowIndex) {
            return point < heightMap[column][down];
        }

        return true;
    }

    private static int[][] getHeightMap() {
        int[][] heightMap = new int[INPUT.size()][INPUT.getFirst().length()];

        for (int column = 0; column < heightMap[0].length; column++) {
            for (int row = 0; row < heightMap.length; row++) {
                heightMap[row][column] = Integer.parseInt(String.valueOf(INPUT.get(row).charAt(column)));
            }
        }

        return heightMap;
    }
}
