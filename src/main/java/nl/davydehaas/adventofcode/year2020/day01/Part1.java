package nl.davydehaas.adventofcode.year2020.day01;

import nl.davydehaas.adventofcode.utils.InputReader;

public class Part1 {
    
    private static final int TARGET = 2020;
    
    public static void main(String[] args) {
        int result = calculate();
        
        System.out.printf("The product of the two entries that sum to %s is:%n", TARGET);
        System.out.println(result);
    }
    
    static int calculate() {
        int[] expenses = getExpenses();
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
    
    private static int[] getExpenses() {
        return InputReader.readFile("/year2020/day01-input.txt").stream()
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
