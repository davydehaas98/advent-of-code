package nl.davydehaas.adventofcode.year2023.day04;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.List;

class Part1 {

    private static final List<String> INPUT = readFile(2023, 4);

    public static void main(String[] args) {
        timeSolution(Part1::solve);
    }

    static int solve() {
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
