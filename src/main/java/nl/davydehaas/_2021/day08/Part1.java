package nl.davydehaas._2021.day08;

import nl.davydehaas.utils.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Part1 {
    public static void main(String[] args) {
        List<String[]> signalPatterns = getSignalPatterns();
        List<String[]> outputValues = getOutputValues();
        int digitCounter = 0;
    
        for (int i = 0; i < signalPatterns.size(); i++) {
            Integer[] digits = decodeSignalPattern(outputValues.get(i));
            for (Integer digit : digits) {
                if (digit != null) {
                    digitCounter++;
                }
            }
        }
    
        System.out.println("The amount of appearances of digits 1, 4, 7 or 8 in the output values are:");
        System.out.println(digitCounter);
    }
    
    private static Integer[] decodeSignalPattern(String[] signalPattern) {
        Integer[] digits = new Integer[10];
        // Unique length
        for (int i = 0; i < signalPattern.length; i++) {
            switch (signalPattern[i].length()){
                case 2 -> digits[i] = 1;
                case 3 -> digits[i] = 7;
                case 4 -> digits[i] = 4;
                case 7 -> digits[i] = 8;
            }
        }
        
        return digits;
    }
    
    private static List<String[]> getOutputValues() {
        List<String> lines = InputReader.readFile("/_2021/day08-input.txt");
        List<String[]> outputValues = new ArrayList<>();
        
        for (String line : lines) {
            String outputValueStrings = line.split(" \\| ")[1];
            outputValues.add(outputValueStrings.split(" "));
        }
        
        return outputValues;
    }
    private static List<String[]> getSignalPatterns() {
        List<String> lines = InputReader.readFile("/_2021/day08-input.txt");
        List<String[]> SignalPatterns = new ArrayList<>();
        
        for (String line : lines) {
            String signalPatternString = line.split(" \\| ")[0];
            SignalPatterns.add(signalPatternString.split(" "));
        }
        
        return SignalPatterns;
    }
}
