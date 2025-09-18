package nl.davydehaas.adventofcode.year2021.day09;

import java.util.ArrayList;
import java.util.List;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part2 {

    private static final List<String> INPUT = readFile(2021, 9);

    private static int[][] heightMap;
    private static int sizeCounter;
    
    void main() {
        timeSolution(Part2::solve);
    }

    static Number solve() {
        heightMap = getHeightMap();
        List<Point> lowestPoints = new ArrayList<>();
        List<Integer> basins = new ArrayList<>();

        for (int column = 0; column < heightMap.length; column++) {
            for (int row = 0; row < heightMap[0].length; row++) {
                if (isLowestPoint(column, row)) {
                    lowestPoints.add(new Point(column, row));
                }
            }
        }

        lowestPoints.forEach(point -> {
            sizeCounter = 0;
            basins.add(calculateBasinSize(point.x(), point.y()));
        });

        return basins.stream().sorted().toList()
                .subList(basins.size() - 3, basins.size()).stream()
                .reduce(1, Math::multiplyExact);
    }

    private static Integer calculateBasinSize(int column, int row) {
        int maxColumnIndex = heightMap.length - 1;
        int maxRowIndex = heightMap[0].length - 1;

        sizeCounter++;
        heightMap[column][row] = 9;

        int left = column - 1;
        if (left >= 0 && heightMap[left][row] < 9) {
            calculateBasinSize(left, row);
        }

        int right = column + 1;
        if (right <= maxColumnIndex && heightMap[right][row] < 9) {
            calculateBasinSize(right, row);
        }

        int up = row - 1;
        if (up >= 0 && heightMap[column][up] < 9) {
            calculateBasinSize(column, up);
        }

        int down = row + 1;
        if (down <= maxRowIndex && heightMap[column][down] < 9) {
            calculateBasinSize(column, down);
        }

        return sizeCounter;
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

    record Point(int x, int y) {
    }
}
