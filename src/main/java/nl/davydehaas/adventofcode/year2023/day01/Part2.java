package nl.davydehaas.adventofcode.year2023.day01;

import nl.davydehaas.adventofcode.year2023.Year2023;

import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

public class Part2 extends Year2023 {
    
    private static final List<String> INPUT = readFile("/day01.txt");
    
    public static void main(String[] args) {
        timeSolution(Part2::calculate);
    }
    
    static int calculate() {
        int sum = 0;
        
        for (String line : INPUT) {
            line = transformSpelledDigit(line);
            line = line.replaceAll("[(\\D)]", "");
            sum += Integer.parseInt(line.charAt(0) + "" + line.charAt(line.length() - 1));
        }
        
        return sum;
    }
    
    private static String transformSpelledDigit(String line) {
        return line
                .replaceAll("one", "o1e")
                .replaceAll("two", "t2o")
                .replaceAll("three", "t3e")
                .replaceAll("four", "f4r")
                .replaceAll("five", "f5e")
                .replaceAll("six", "s6x")
                .replaceAll("seven", "s7n")
                .replaceAll("eight", "e8t")
                .replaceAll("nine", "n9e");
    }
}
