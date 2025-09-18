package nl.davydehaas.adventofcode.year2023.day04;

import java.util.List;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part1 {
    
    private static final List<String> INPUT = readFile(2023, 4);
    
    void main() {
        timeSolution(Part1::solve);
    }
    
    static Number solve() {
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
