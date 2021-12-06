package _2021.day06;

import utils.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        return Arrays
                .stream(FileReader.readFile("/_2021/day06-input.txt").get(0).split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
