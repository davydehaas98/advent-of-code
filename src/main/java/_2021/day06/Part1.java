package main.java._2021.day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        List<Integer> lanternfishes = getLanternfishes();
        int days = 80;
        
        for (int i = 0; i < days; i++) {
            int amount = lanternfishes.size();
            
            for (int j = 0; j < amount; j++) {
                int lanternfish = lanternfishes.get(j);
                
                if (lanternfish > 0) {
                    lanternfishes.set(j, lanternfish - 1);
                } else {
                    lanternfishes.set(j, 6);
                    lanternfishes.add(8);
                }
            }
        }
        
        System.out.printf("After %s days, the amount of lanternfish is:%n", days);
        System.out.println(lanternfishes.size());
    }
    
    private static List<Integer> getLanternfishes() {
        List<Integer> lanternfish = new ArrayList<>();
        
        try {
            File file = new File("src/main/resources/_2021/day06-input.txt");
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                String[] lanternfishStrings = scanner.nextLine().split(",");
                
                for (String lanternfishString : lanternfishStrings) {
                    lanternfish.add(Integer.parseInt(lanternfishString));
                }
            }
            
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return lanternfish;
    }
}
