package nl.davydehaas.adventofcode.year2021.day08;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

class Part2 {

    private static final List<String> INPUT = readFile(2021, 8);
    
    static void main() {
        timeSolution(Part2::solve);
    }

    static Number solve() {
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

        return outputValueSum;
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

                assert digits[9] != null;
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
        if (one.length() != two.length()) {
            return false;
        }

        Set<Character> characters = new HashSet<>();

        for (int i = 0; i < one.length(); i++) {
            characters.add(one.charAt(i));
        }

        return characters.stream()
                .allMatch(character -> two.contains(character.toString()));
    }

    private static List<String[]> getOutputValues() {
        return INPUT.stream()
                .map(line -> line.split(" \\| ")[1].split(" "))
                .toList();
    }

    private static List<String[]> getSignalPatterns() {
        return INPUT.stream()
                .map(line -> line.split(" \\| ")[0].split(" "))
                .toList();
    }
}
