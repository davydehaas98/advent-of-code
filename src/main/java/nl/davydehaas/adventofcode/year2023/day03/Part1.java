package nl.davydehaas.adventofcode.year2023.day03;

import nl.davydehaas.adventofcode.year2023.Year2023;

import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

public class Part1 extends Year2023 {
    
    private static final List<String> INPUT = readFile("/day03.txt");
    
    public static void main(String[] args) {
        timeSolution(Part1::calculate);
    }
    
    static int calculate() {
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
                }
                else if (!number.isEmpty()) {
                    if (isPartNumber(x - number.length(), x - 1, y, engine)) {
                        sum += Integer.parseInt(number.toString());
                    }
                    number = new StringBuilder();
                }
            }
        }
        
        return sum;
    }
    
    private static boolean isPartNumber(int x1, int x2, int y, char[][] engine) {
        int left = x1 - 1;
        if (engine[y - 1][left] != '.') {
            return true;
        }
        if (engine[y][left] != '.') {
            return true;
        }
        if (engine[y + 1][left] != '.') {
            return true;
        }
        
        int right = x2 + 1;
        if (engine[y - 1][right] != '.') {
            return true;
        }
        if (engine[y][right] != '.') {
            return true;
        }
        if (engine[y + 1][right] != '.') {
            return true;
        }
        
        for (int x = x1; x < x2 + 1; x++) {
            if (engine[y - 1][x] != '.') {
                return true;
            }
            if (engine[y + 1][x] != '.') {
                return true;
            }
        }
        
        return false;
    }
}
