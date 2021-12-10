package nl.davydehaas.year2020.day02;

import nl.davydehaas.utils.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Part2 {
    public static void main(String[] args) {
        List<String[]> policies = getPolicies();
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
        
        System.out.println("The amount of valid passwords is:");
        System.out.println(validPasswordCounter);
    }
    
    private static List<String[]> getPolicies() {
        List<String> lines = InputReader.readFile("/_2020/day02-input.txt");
        List<String[]> policies = new ArrayList<>();
        
        for (String line : lines) {
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
