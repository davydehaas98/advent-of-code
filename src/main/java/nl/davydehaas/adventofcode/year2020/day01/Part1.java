package nl.davydehaas.adventofcode.year2020.day01;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.List;

class Part1 {

    private static final List<String> INPUT = readFile(2020, 1);

    private static final int TARGET = 2020;

    public static void main(String[] args) {
        timeSolution(Part1::solve);
    }

    static Number solve() {
        int[] expenses = INPUT.stream()
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] sumToTarget = new int[]{0, 0};

        for (int expense : expenses) {
            for (int secondExpense : expenses) {
                // Check if it does not compare itself
                if (expense != secondExpense) {
                    if (expense + secondExpense == TARGET) {
                        sumToTarget[0] = expense;
                        sumToTarget[1] = secondExpense;
                        break;
                    }
                }
                if (sumToTarget[0] != 0 && sumToTarget[1] != 0) {
                    break;
                }
            }
        }

        return sumToTarget[0] * sumToTarget[1];
    }
}
