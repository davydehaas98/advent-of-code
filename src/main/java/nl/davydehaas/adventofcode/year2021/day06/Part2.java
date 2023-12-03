package nl.davydehaas.adventofcode.year2021.day06;

import nl.davydehaas.adventofcode.year2021.Year2021;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

class Part2 extends Year2021 {
    
    private static final List<String> INPUT = readFile("/day06.txt");
    
    public static void main(String[] args) {
        timeSolution(Part2::calculate);
    }
    
    static BigInteger calculate() {
        int days = 256;
        int internalTimer = 8;
        int resetInternalTimer = 6;
        HashMap<Integer, BigInteger> lanternFishes = getLanternFishes(internalTimer);
        BigInteger totalLanternFishes = BigInteger.ZERO;
        
        for (int i = 0; i < days; i++) {
            BigInteger lanternFishInLaborAmount = BigInteger.ZERO;
            
            for (int j = 0; j < lanternFishes.size(); j++) {
                if (lanternFishes.containsKey(j)) {
                    BigInteger lanternfishAmount = lanternFishes.get(j);
                    if (j > 0) {
                        // Shift all fish from 1 to day 8 one down
                        lanternFishes.put(j - 1, lanternfishAmount);
                    } else {
                        // Save the amount of fish of day 0
                        lanternFishInLaborAmount = lanternfishAmount;
                    }
                }
            }
            // Make birth to new fish
            // Set internal timer of new fish
            if (lanternFishes.containsKey(resetInternalTimer)) {
                lanternFishes.put(resetInternalTimer, lanternFishes.get(resetInternalTimer).add(lanternFishInLaborAmount));
            } else {
                lanternFishes.put(resetInternalTimer, lanternFishInLaborAmount);
            }
            // Reset internal timer of fish that gave birth.
            lanternFishes.put(internalTimer, lanternFishInLaborAmount);
        }
        
        for (int i = 0; i < lanternFishes.size(); i++) {
            totalLanternFishes = totalLanternFishes.add(lanternFishes.get(i));
        }
        
        return totalLanternFishes;
    }
    
    private static HashMap<Integer, BigInteger> getLanternFishes(int internalTimer) {
        HashMap<Integer, BigInteger> lanternFishes = new HashMap<>();
        // Set up HashMap
        for (int i = 0; i < internalTimer; i++) {
            lanternFishes.put(i, BigInteger.ZERO);
        }
        
        Arrays.stream(INPUT.get(0).split(","))
                .map(Integer::parseInt)
                .toList()
                .forEach(timer -> lanternFishes.put(timer, lanternFishes.get(timer).add(BigInteger.ONE)));
        
        return lanternFishes;
    }
}
