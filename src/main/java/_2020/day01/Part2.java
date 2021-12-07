package _2020.day01;

import utils.InputReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {
        int target = 2020;
        List<Integer> expenses = getExpenses();
        Integer[] sumToTarget = new Integer[]{0, 0, 0};
        boolean breakFlag = false;
        
        for (Integer expense : expenses) {
            for (Integer secondExpense : expenses) {
                // Check if it does not compare itself
                if (!expense.equals(secondExpense)) {
                    for (Integer thirdExpense : expenses) {
                        // Check if it does not compare itself
                        if (!expense.equals(thirdExpense) && !secondExpense.equals(thirdExpense)) {
                            if (expense + secondExpense + thirdExpense == target) {
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
        
        int product = sumToTarget[0] * sumToTarget[1] * sumToTarget[2];
        
        System.out.printf("The product of the three entries that sum to %s is:%n", target);
        System.out.println(product);
    }
    
    private static List<Integer> getExpenses() {
        return InputReader.readFile("/_2020/day01-input.txt")
                .stream()
                .map(Integer::parseInt)
                .toList();
    }
}
