package nl.davydehaas.adventofcode.year2023.day04;

import nl.davydehaas.adventofcode.year2023.Year2023;

import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

class Part1 extends Year2023 {
    
    private static final List<String> INPUT = readFile("/day04.txt");
    
    public static void main(String[] args) {
        timeSolution(Part1::calculate);
    }
    
    static int calculate() {
        int points = 0;
        for (String line : INPUT) {
            String[] match = line.split(" [|] ");
            String[] winningNumbers = match[0]
                    .substring(match[0].indexOf(": ") + 2)
                    .split(" ");
            String[] numbers = match[1].split(" ");
            
            int won = 0;
            for (String number : numbers) {
                if (number.isBlank()) {
                    continue;
                }
                for (String winningNumber : winningNumbers) {
                    if (winningNumber.equals(number)) {
                        won++;
                        break;
                    }
                }
            }
            points += (int) Math.pow(2, won - 1);
        }
        return points;
    }
}
