package nl.davydehaas.year2021.day10;

import nl.davydehaas.utils.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Part2 {
    public static void main(String[] args) {
        List<String> navigationLines = getNavigationLines();
        List<Long> points = new ArrayList<>();
        
        navigationLines.forEach(line -> {
            line = removeValidChunks(line);
            // Check if line is not corrupted
            if (!line.contains(")") && !line.contains("]") && !line.contains("}") && !line.contains(">")) {
                points.add(calculateIncompleteLinePoints(line));
            }
        });
        
        long middlePoints = points.stream().sorted().toList().get(points.size() / 2);
        
        System.out.println("The middle score is:");
        System.out.println(middlePoints);
    }
    
    private static long calculateIncompleteLinePoints(String line) {
        long points = 0;
        
        for (int i = line.length() - 1; 0 <= i; i--) {
            points *= 5;
            
            switch (line.charAt(i)) {
                case '(' -> points += 1;
                case '[' -> points += 2;
                case '{' -> points += 3;
                case '<' -> points += 4;
            }
        }
        
        return points;
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
        return InputReader.readFile("/_2021/day10-input.txt");
    }
}
