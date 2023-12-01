package nl.davydehaas.adventofcode.year2023.day01;

import nl.davydehaas.adventofcode.utils.InputReader;

import java.util.List;

public class Part2 {
    
    public static void main(String[] args) {
        int result = calculate();
        System.out.println("What is the sum of all of the calibration values?");
        System.out.println(result);
    }
    
    static int calculate() {
        List<String> calibrationDocument = getCalibrationDocument();
        
        return calibrationDocument.stream()
                .map(Part2::transformSpelledDigit)
                .map(line -> line.replaceAll("[(\\D)]", ""))
                .map(digits -> digits.charAt(0) + "" + digits.charAt(digits.length() - 1))
                .mapToInt(Integer::parseInt)
                .sum();
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
    
    private static List<String> getCalibrationDocument() {
        return InputReader.readFile("/year2023/day01-input.txt");
    }
}
