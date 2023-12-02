package nl.davydehaas.adventofcode.year2020.day01;

import nl.davydehaas.adventofcode.year2020.Year2020;

public class Part2 extends Year2020 {
    
    private static final int TARGET = 2020;
    
    public static void main(String[] args) {
        int result = calculate();
        System.out.printf("The product of the three entries that sum to %s is:%n", TARGET);
        System.out.println(result);
    }
    
    static int calculate() {
        int[] expenses = readFile("/day01.txt").stream()
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
