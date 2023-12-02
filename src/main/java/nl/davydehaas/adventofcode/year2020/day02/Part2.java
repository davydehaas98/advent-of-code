package nl.davydehaas.adventofcode.year2020.day02;

import nl.davydehaas.adventofcode.year2020.Year2020;

import java.util.ArrayList;
import java.util.List;

public class Part2 extends Year2020 {
    
    public static void main(String[] args) {
        Integer result = calculate();
        System.out.println("The amount of valid passwords is:");
        System.out.println(result);
    }
    
    static Integer calculate() {
        List<String> input = readFile("/day02.txt");
        List<String[]> policies = getPolicies(input);
        int validPasswordCounter = 0;
        
        for (String[] policy : policies) {
            int firstPosition = Integer.parseInt(policy[0]) - 1;
            int secondPosition = Integer.parseInt(policy[1]) - 1;
            char letter = policy[2].charAt(0);
            String password = policy[3];
            // Check positions of letter
            if (password.charAt(firstPosition) == letter && password.charAt(secondPosition) != letter) {
                validPasswordCounter++;
            } else if (password.charAt(firstPosition) != letter && password.charAt(secondPosition) == letter) {
                validPasswordCounter++;
            }
        }
        
        return validPasswordCounter;
    }
    
    private static List<String[]> getPolicies(List<String> input) {
        List<String[]> policies = new ArrayList<>();
        
        for (String line : input) {
            String[] lineArray = line.split(": ");
            String password = lineArray[1];
            
            lineArray = lineArray[0].split(" ");
            String letter = lineArray[1];
            
            lineArray = lineArray[0].split("-");
            String min = lineArray[0];
            String max = lineArray[1];
            
            policies.add(new String[]{min, max, letter, password});
        }
        
        return policies;
    }
}
