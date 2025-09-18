package nl.davydehaas.adventofcode.year2023.day01;

import java.util.List;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part2 {

    private static final List<String> INPUT = readFile(2023, 1);
    
    void main() {
        timeSolution(Part2::solve);
    }

    static Number solve() {
        int sum = 0;

        for (String line : INPUT) {
            Character firstNumber = null;
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    firstNumber = line.charAt(i);
                    break;
                } else {
                    firstNumber = isSpelledDigit(line.substring(0, i + 1));
                    if (firstNumber != null) {
                        break;
                    }
                }
            }
            Character lastNumber = null;
            for (int i = line.length() - 1; i > -1; i--) {
                if (Character.isDigit(line.charAt(i))) {
                    lastNumber = line.charAt(i);
                    break;
                } else {
                    lastNumber = isSpelledDigit(line.substring(i));
                    if (lastNumber != null) {
                        break;
                    }
                }
            }
            sum += Integer.parseInt(firstNumber + "" + lastNumber);
        }

        return sum;
    }

    private static Character isSpelledDigit(String spelledDigit) {
        if (spelledDigit.contains("one")) {
            return '1';
        }
        if (spelledDigit.contains("two")) {
            return '2';
        }
        if (spelledDigit.contains("three")) {
            return '3';
        }
        if (spelledDigit.contains("four")) {
            return '4';
        }
        if (spelledDigit.contains("five")) {
            return '5';
        }
        if (spelledDigit.contains("six")) {
            return '6';
        }
        if (spelledDigit.contains("seven")) {
            return '7';
        }
        if (spelledDigit.contains("eight")) {
            return '8';
        }
        if (spelledDigit.contains("nine")) {
            return '9';
        }
        return null;
    }
}
