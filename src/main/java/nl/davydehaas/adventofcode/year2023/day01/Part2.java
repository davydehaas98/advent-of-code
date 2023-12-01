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
                .map(line -> {
                    String transformedString = "";
                    for (int i = 0; i < line.length(); i++) {
                        transformedString = transformSpelledDigit(transformedString + line.charAt(i));
                    }
                    return transformedString;
                })
                .map(line -> line.replaceAll("[(\\D)]", ""))
                .map(digits -> digits.charAt(0) + "" + digits.charAt(digits.length() - 1))
                .mapToInt(Integer::parseInt)
                .sum();
    }
    
    private static String transformSpelledDigit(String line) {
        return line
                .replace("one", "o1e")
                .replace("two", "t2o")
                .replace("three", "t3e")
                .replace("four", "f4r")
                .replace("five", "f5e")
                .replace("six", "s6x")
                .replace("seven", "s7n")
                .replace("eight", "e8t")
                .replace("nine", "n9e");
    }
    
    private static List<String> getCalibrationDocument() {
        return InputReader.readFile("/year2023/day01-input.txt");
    }
}
