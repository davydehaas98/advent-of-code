package nl.davydehaas.adventofcode.year2020.day01;

import nl.davydehaas.adventofcode.year2020.Year2020;

import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

class Part1 extends Year2020 {
    
    private static final List<String> INPUT = readFile("/day01.txt");
    
    private static final int TARGET = 2020;
    
    public static void main(String[] args) {
        timeSolution(Part1::calculate);
    }
    
    static int calculate() {
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
