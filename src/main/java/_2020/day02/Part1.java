package _2020.day02;

import utils.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Part1 {
    public static void main(String[] args) {
        List<String[]> policies = getPolicies();
        int validPasswordCounter = 0;
        
        for (String[] policy : policies) {
            int min = Integer.parseInt(policy[0]);
            int max = Integer.parseInt(policy[1]);
            char letter = policy[2].charAt(0);
            String password = policy[3];
            int letterOccurrenceCounter = 0;
            // Count occurrences of letter
            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) == letter) {
                    letterOccurrenceCounter++;
                }
            }
            // Check valid password
            if (min <= letterOccurrenceCounter && letterOccurrenceCounter <= max) {
                validPasswordCounter++;
            }
        }
    
        System.out.println("The amount of valid passwords is:");
        System.out.println(validPasswordCounter);
    }
    
    private static List<String[]> getPolicies() {
        List<String> lines = InputReader.readFile("/_2020/day02-input.txt");
        List<String[]> input = new ArrayList<>();
    
        for (String line : lines) {
            String[] lineArray = line.split(": ");
            String password = lineArray[1];
        
            lineArray = lineArray[0].split(" ");
            String letter = lineArray[1];
        
            lineArray = lineArray[0].split("-");
            String min = lineArray[0];
            String max = lineArray[1];
        
            input.add(new String[]{min, max, letter, password});
        }
    
        return input;
    }
}
