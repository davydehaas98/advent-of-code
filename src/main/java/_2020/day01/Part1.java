package main.java._2020.day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        int target = 2020;
        List<Integer> expenses = getExpenses();
        Integer[] sumToTarget = new Integer[] {0, 0};
        
        for (Integer expense : expenses) {
            for (Integer secondExpense : expenses) {
                // Check if it does not compare itself
                if (!expense.equals(secondExpense)) {
                    if (expense + secondExpense == target) {
                        sumToTarget[0] = expense;
                        sumToTarget[1] = secondExpense;
                        break;
                    }
                }
                if (!sumToTarget[0].equals(0) && !sumToTarget[1].equals(0)) {
                    break;
                }
            }
        }
        
        int product = sumToTarget[0] * sumToTarget[1];
        
        System.out.printf("The product of the two entries that sum to %s is:%n", target);
        System.out.println(product);
    }
    
    private static List<Integer> getExpenses() {
        List<Integer> expenses = new ArrayList<>();
    
        try {
            File file = new File("src/main/resources/_2020/day01-input.txt");
            Scanner scanner = new Scanner(file);
        
            while (scanner.hasNextLine()) {
                expenses.add(Integer.parseInt(scanner.nextLine()));
            }
        
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return expenses;
    }
}
