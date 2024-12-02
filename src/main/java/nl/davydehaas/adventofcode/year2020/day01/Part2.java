package nl.davydehaas.adventofcode.year2020.day01;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.List;

class Part2 {

    private static final List<String> INPUT = readFile(2020, 1);

    private static final int TARGET = 2020;

    public static void main(String[] args) {
        timeSolution(Part2::solve);
    }

    static int solve() {
        int[] expenses = INPUT.stream()
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] sumToTarget = new int[]{0, 0, 0};
        boolean breakFlag = false;

        for (int expense : expenses) {
            for (int secondExpense : expenses) {
                // Check if it does not compare itself
                if (expense != secondExpense) {
                    for (int thirdExpense : expenses) {
                        // Check if it does not compare itself
                        if (expense != thirdExpense && secondExpense != thirdExpense) {
                            if (expense + secondExpense + thirdExpense == TARGET) {
                                sumToTarget[0] = expense;
                                sumToTarget[1] = secondExpense;
                                sumToTarget[2] = thirdExpense;
                                breakFlag = true;
                                break;
                            }
                        }
                    }
                }
                if (breakFlag) {
                    break;
                }
            }
            if (breakFlag) {
                break;
            }
        }

        return sumToTarget[0] * sumToTarget[1] * sumToTarget[2];
    }
}
