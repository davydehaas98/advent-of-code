package main.java.day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {
        int days = 256;
        int internalTimer = 8;
        int resetInternalTimer = 6;
        HashMap<Integer, BigInteger> lanternfishes = getLanternfishes(internalTimer);
        BigInteger totalLanternfish = BigInteger.ZERO;
    
        for (int i = 0; i < days; i++) {
            BigInteger lanternfishInLaborAmount = BigInteger.ZERO;
            
            for (int j = 0; j < lanternfishes.size(); j++) {
                if (lanternfishes.containsKey(j)) {
                    BigInteger lanternfishAmount = lanternfishes.get(j);
                    if (j > 0) {
                        lanternfishes.put(j - 1, lanternfishAmount);
                    } else {
                        lanternfishInLaborAmount = lanternfishAmount;
                    }
                }
            }
            
            if (lanternfishes.containsKey(resetInternalTimer)) {
                lanternfishes.put(resetInternalTimer, lanternfishes.get(resetInternalTimer).add(lanternfishInLaborAmount));
            }
            else {
                lanternfishes.put(resetInternalTimer, lanternfishInLaborAmount);
            }
            lanternfishes.put(internalTimer, lanternfishInLaborAmount);
        }
        
        for (int i = 0; i < lanternfishes.size(); i++) {
            totalLanternfish = totalLanternfish.add(lanternfishes.get(i));
        }
    
        System.out.printf("After %s days, the amount of lanternfish is:%n", days);
        System.out.println(totalLanternfish);
    }
    
    private static HashMap<Integer, BigInteger> getLanternfishes(int internalTimer) {
        HashMap<Integer, BigInteger> lanternfishes = new HashMap<>();
        for (int i = 0; i < internalTimer; i++) {
            lanternfishes.put(i, BigInteger.ZERO);
        }
        
        try {
            File file = new File("src/main/resources/day06-input.txt");
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                String[] lanternfishStrings = scanner.nextLine().split(",");
                
                for (String lanternfishString : lanternfishStrings) {
                    int lanternfish = Integer.parseInt(lanternfishString);
                    BigInteger value = lanternfishes.get(lanternfish);
                    lanternfishes.put(lanternfish, value.add(BigInteger.ONE));
                }
            }
            
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return lanternfishes;
    }
}
