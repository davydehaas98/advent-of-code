package nl.davydehaas.adventofcode.year2023.day03;

import java.util.List;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part1 {
    
    private static final List<String> INPUT = readFile(2023, 3);
    
    void main() {
        timeSolution(Part1::solve);
    }
    
    static Number solve() {
        int size = INPUT.size() + 2;
        char[][] engine = new char[size][size];
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (y == 0 || y == size - 1 || x == 0 || x == size - 1) {
                    engine[y][x] = '.';
                } else {
                    engine[y][x] = INPUT.get(y - 1).charAt(x - 1);
                }
            }
        }
        
        int sum = 0;
        StringBuilder number;
        
        for (int y = 0; y < size; y++) {
            number = new StringBuilder();
            for (int x = 0; x < size; x++) {
                if (Character.isDigit(engine[y][x])) {
                    number.append(engine[y][x]);
                } else if (!number.isEmpty()) {
                    if (isPartNumber(x - number.length(), x - 1, y, engine)) {
                        sum += Integer.parseInt(number.toString());
                    }
                    number = new StringBuilder();
                }
            }
        }
        
        return sum;
    }
    
    private static boolean isPartNumber(int xLeft, int xRight, int y, char[][] engine) {
        // Left
        int left = xLeft - 1;
        if (engine[y - 1][left] != '.') {
            return true;
        }
        if (engine[y][left] != '.') {
            return true;
        }
        if (engine[y + 1][left] != '.') {
            return true;
        }
        // Right
        int right = xRight + 1;
        if (engine[y - 1][right] != '.') {
            return true;
        }
        if (engine[y][right] != '.') {
            return true;
        }
        if (engine[y + 1][right] != '.') {
            return true;
        }
        // Middle
        for (int x = xLeft; x < xRight + 1; x++) {
            // Above
            if (engine[y - 1][x] != '.') {
                return true;
            }
            // Below
            if (engine[y + 1][x] != '.') {
                return true;
            }
        }
        
        return false;
    }
}
