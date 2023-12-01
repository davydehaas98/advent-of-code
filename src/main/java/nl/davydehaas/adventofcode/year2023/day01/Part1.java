package nl.davydehaas.adventofcode.year2023.day01;

import nl.davydehaas.adventofcode.utils.InputReader;

import java.util.List;

public class Part1 {
    
    public static void main(String[] args) {
        int result = calculate();
        System.out.println("What is the sum of all of the calibration values?");
        System.out.println(result);
    }
    
    static int calculate() {
        List<String> calibrationDocument = getCalibrationDocument();
        
        return calibrationDocument.stream()
                .map(line -> line.replaceAll("[(\\D)]", ""))
                .map(digits -> digits.charAt(0) + "" + digits.charAt(digits.length() - 1))
                .mapToInt(Integer::parseInt)
                .sum();
    }
    
    private static List<String> getCalibrationDocument() {
        return InputReader.readFile("/year2023/day01-input.txt");
    }
}
