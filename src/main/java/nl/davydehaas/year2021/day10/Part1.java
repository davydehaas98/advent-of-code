package nl.davydehaas.year2021.day10;

import nl.davydehaas.utils.InputReader;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Part1 {
    public static void main(String[] args) {
        List<String> navigationLines = getNavigationLines();
        AtomicInteger points = new AtomicInteger();
        
        navigationLines.forEach(line ->
                points.addAndGet(calculateCorruptedLinePoints(
                        removeValidChunks(line)
                ))
        );
        
        System.out.println("The total syntax error score is:");
        System.out.println(points.get());
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
    
    private static String removeValidChunks(String navigationLine) {
        while (true) {
            int lineLength = navigationLine.length();
            
            navigationLine = navigationLine.replace("()", "").replace("[]", "")
                    .replace("{}", "")
                    .replace("<>", "");
            
            if (lineLength == navigationLine.length())
                break;
        }
        
        return navigationLine;
    }
    
    private static List<String> getNavigationLines() {
        return InputReader.readFile("/year2021/day10-input.txt");
    }
}
