package nl.davydehaas.year2021.day06;

import nl.davydehaas.utils.InputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part1 {
    public static void main(String[] args) {
        List<Integer> lanternfishes = new ArrayList<>(getLanternfishes());
        int days = 80;
        int internalTimer = 8;
        int resetInternalTimer = 6;
        
        for (int i = 0; i < days; i++) {
            int amount = lanternfishes.size();
            
            for (int j = 0; j < amount; j++) {
                int lanternfish = lanternfishes.get(j);
                
                if (lanternfish > 0) {
                    lanternfishes.set(j, lanternfish - 1);
                } else {
                    lanternfishes.set(j, resetInternalTimer);
                    lanternfishes.add(internalTimer);
                }
            }
        }
        
        System.out.printf("After %s days, the amount of lanternfish is:%n", days);
        System.out.println(lanternfishes.size());
    }
    
    private static List<Integer> getLanternfishes() {
        return Arrays
                .stream(InputReader.readFile("/year2021/day06-input.txt").get(0).split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
