package nl.davydehaas._2021.day08;

import nl.davydehaas.utils.InputReader;

import java.util.*;

public class Part2 {
    public static void main(String[] args) {
        List<String[]> signalPatterns = getSignalPatterns();
        List<String[]> outputValues = getOutputValues();
        int outputValueSum = 0;
    
        for (int i = 0; i < signalPatterns.size(); i++) {
            String[] signalPattern = signalPatterns.get(i);
            String[] outputValue = outputValues.get(i);
            
            String[] digits = decodeSignalPattern(signalPattern);
            StringBuilder digitString = new StringBuilder();
            
            for (String outputValueDigit : outputValue) {
                for (int j = 0; j < digits.length; j++) {
                    if (containsAllCharacters(outputValueDigit, digits[j])) {
                        digitString.append(j);
                        break;
                    }
                }
            }
            
            outputValueSum += Integer.parseInt(digitString.toString());
        }
    
        System.out.println("The sum of all the output values is:");
        System.out.println(outputValueSum);
    }
    
    private static String[] decodeSignalPattern(String[] signalPattern) {
        String[] digits = new String[10];
        List<String> fiveLengthSignal = new ArrayList<>();
        List<String> sixLengthSignal = new ArrayList<>();
        
        // Unique length
        for (String signal : signalPattern) {
            switch (signal.length()) {
                case 2 -> digits[1] = signal; // 1
                case 3 -> digits[7] = signal; // 7
                case 4 -> digits[4] = signal; // 4
                case 5 -> fiveLengthSignal.add(signal); // 2,3,5
                case 6 -> sixLengthSignal.add(signal); // 0,6,9
                case 7 -> digits[8] = signal; // 8
            }
        }
        // Calculate signal with length six [0,6,9]
        for (String signal : sixLengthSignal) {
            if (digits[9] == null) {
                boolean isNine = true;
                
                for (char character : digits[4].toCharArray()) {
                    if (signal.indexOf(character) == -1) {
                        isNine = false;
                        break;
                    }
                }
    
                if (isNine) {
                    digits[9] = signal;
                    continue;
                }
            }
            
            if (digits[0] == null || digits[6] == null) {
                boolean isZero = true;
    
                for (char character : digits[1].toCharArray()) {
                    if (signal.indexOf(character) == -1) {
                        isZero = false;
                        break;
                    }
                }
    
                if (isZero) {
                    digits[0] = signal;
                } else {
                    digits[6] = signal;
                }
            }
        }
        // Calculate signal with length five [2,3,5]
        for (String signal : fiveLengthSignal) {
            if (digits[3] == null) {
                boolean isThree = true;
                
                for (char character : digits[1].toCharArray()) {
                    if (signal.indexOf(character) == -1) {
                        isThree = false;
                        break;
                    }
                }
    
                if (isThree) {
                    digits[3] = signal;
                    continue;
                }
            }
            
            if (digits[2] == null || digits[5] == null) {
                String remainingCharacters = signal;
    
                for (char character : digits[9].toCharArray()) {
                    remainingCharacters = remainingCharacters.replaceFirst(String.valueOf(character), "");
                }
    
                if (remainingCharacters.length() == 1) {
                    digits[2] = signal;
                } else {
                    digits[5] = signal;
                }
            }
        }
        
        return digits;
    }
    
    private static boolean containsAllCharacters(String one, String two) {
        if (one.length() != two.length()) return false;
        
        Set<Character> characters = new HashSet<>();
        
        for(int i = 0; i < one.length(); i++) {
            characters.add(one.charAt(i));
        }
        
        for (Character character : characters) {
            if (!two.contains(character.toString())) {
                return false;
            }
        }
        
        return true;
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
