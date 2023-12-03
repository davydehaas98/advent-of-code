package nl.davydehaas.adventofcode.year2021.day06;

import nl.davydehaas.adventofcode.year2021.Year2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

class Part1 extends Year2021 {
    
    private static final List<String> INPUT = readFile("/day06.txt");
    
    public static void main(String[] args) {
        timeSolution(Part1::calculate);
    }
    
    static int calculate() {
        List<Integer> lanternFishes = new ArrayList<>(getLanternFishes());
        int days = 80;
        int internalTimer = 8;
        int resetInternalTimer = 6;
        
        for (int i = 0; i < days; i++) {
            int amount = lanternFishes.size();
            
            for (int j = 0; j < amount; j++) {
                int lanternFish = lanternFishes.get(j);
                
                if (lanternFish > 0) {
                    lanternFishes.set(j, lanternFish - 1);
                } else {
                    lanternFishes.set(j, resetInternalTimer);
                    lanternFishes.add(internalTimer);
                }
            }
        }
        
        return lanternFishes.size();
    }
    
    private static List<Integer> getLanternFishes() {
        return Arrays.stream(INPUT.get(0).split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
