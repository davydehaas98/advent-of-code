package nl.davydehaas.adventofcode.year2021.day10;

import nl.davydehaas.adventofcode.year2021.Year2021;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

class Part1 extends Year2021 {
    
    private static final List<String> INPUT = readFile("/day10.txt");
    
    public static void main(String[] args) {
        timeSolution(Part1::calculate);
    }
    
    static int calculate() {
        AtomicInteger points = new AtomicInteger();
        
        for (String line : INPUT) {
            points.addAndGet(calculateCorruptedLinePoints(removeValidChunks(line)));
        }
        
        return points.get();
    }
    
    private static String removeValidChunks(String navigationLine) {
        int startLength = navigationLine.length();
        
        String modifiedNavigationLine = navigationLine
                .replace("()", "")
                .replace("[]", "")
                .replace("{}", "")
                .replace("<>", "");
        
        // Check if navigation line is modified
        if (startLength != modifiedNavigationLine.length()) {
            return removeValidChunks(modifiedNavigationLine);
        }
        
        return modifiedNavigationLine;
    }
    
    private static int calculateCorruptedLinePoints(String line) {
        for (char c : line.toCharArray()) {
            switch (c) {
                case ')':
                    return 3;
                case ']':
                    return 57;
                case '}':
                    return 1197;
                case '>':
                    return 25137;
            }
        }
        
        return 0;
    }
}
