package nl.davydehaas.adventofcode.year2023.day03;

import java.util.ArrayList;
import java.util.List;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

class Part2 {
    
    private static final List<String> INPUT = readFile(2023, 3);
    
    public static void main(String[] args) {
        timeSolution(Part2::solve);
    }
    
    static int solve() {
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
        
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (engine[y][x] == '*') {
                    // Check for two numbers that are adjacent
                    List<Integer> engineParts = new ArrayList<>();
                    // Above
                    if (Character.isDigit(engine[y - 1][x - 1])) {
                        engineParts.add(retrieveFullNumber(y - 1, x - 1, engine));
                    }
                    if (Character.isDigit(engine[y - 1][x])) {
                        engineParts.add(retrieveFullNumber(y - 1, x, engine));
                    }
                    if (Character.isDigit(engine[y - 1][x + 1])) {
                        engineParts.add(retrieveFullNumber(y - 1, x + 1, engine));
                    }
                    // Left and right
                    if (Character.isDigit(engine[y][x - 1])) {
                        engineParts.add(retrieveFullNumber(y, x - 1, engine));
                    }
                    if (Character.isDigit(engine[y][x + 1])) {
                        engineParts.add(retrieveFullNumber(y, x + 1, engine));
                    }
                    // Below
                    if (Character.isDigit(engine[y + 1][x - 1])) {
                        engineParts.add(retrieveFullNumber(y + 1, x - 1, engine));
                    }
                    if (Character.isDigit(engine[y + 1][x])) {
                        engineParts.add(retrieveFullNumber(y + 1, x, engine));
                    }
                    if (Character.isDigit(engine[y + 1][x + 1])) {
                        engineParts.add(retrieveFullNumber(y + 1, x + 1, engine));
                    }
                    // If 2 or more are found
                    if (engineParts.size() > 1 && !engineParts.getFirst().equals(engineParts.getLast())) {
                        sum += engineParts.getFirst() * engineParts.getLast();
                    }
                }
            }
        }
        
        return sum;
    }
    
    private static int retrieveFullNumber(int y, int x, char[][] engine) {
        StringBuilder number = new StringBuilder();
        number.append(engine[y][x]);
        // Check left
        for (int xLeft = x - 1; xLeft > 0; xLeft--) {
            if (Character.isDigit(engine[y][xLeft])) {
                number.insert(0, engine[y][xLeft]);
            } else {
                break;
            }
        }
        // Check right
        for (int xRight = x + 1; xRight < engine.length; xRight++) {
            if (Character.isDigit(engine[y][xRight])) {
                number.append(engine[y][xRight]);
            } else {
                break;
            }
        }
        
        return Integer.parseInt(number.toString());
    }
}
