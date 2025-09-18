package nl.davydehaas.adventofcode.year2021.day06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

class Part2 {

    private static final List<String> INPUT = readFile(2021, 6);
    
    static void main() {
        timeSolution(Part2::solve);
    }

    static Number solve() {
        int days = 256;
        int internalTimer = 8;
        int resetInternalTimer = 6;
        HashMap<Integer, Long> lanternFishes = getLanternFishes(internalTimer);
        long totalLanternFishes = 0;

        for (int i = 0; i < days; i++) {
            long lanternFishInLaborAmount = 0;

            for (int j = 0; j < lanternFishes.size(); j++) {
                if (lanternFishes.containsKey(j)) {
                    long lanternFishAmount = lanternFishes.get(j);
                    if (j > 0) {
                        // Shift all fish from 1 to day 8 one down
                        lanternFishes.put(j - 1, lanternFishAmount);
                    } else {
                        // Save the amount of fish of day 0
                        lanternFishInLaborAmount = lanternFishAmount;
                    }
                }
            }
            // Make birth to new fish
            // Set internal timer of new fish
            if (lanternFishes.containsKey(resetInternalTimer)) {
                lanternFishes.put(resetInternalTimer, lanternFishes.get(resetInternalTimer) + lanternFishInLaborAmount);
            } else {
                lanternFishes.put(resetInternalTimer, lanternFishInLaborAmount);
            }
            // Reset internal timer of fish that gave birth.
            lanternFishes.put(internalTimer, lanternFishInLaborAmount);
        }

        for (int i = 0; i < lanternFishes.size(); i++) {
            totalLanternFishes += lanternFishes.get(i);
        }

        return totalLanternFishes;
    }

    private static HashMap<Integer, Long> getLanternFishes(int internalTimer) {
        HashMap<Integer, Long> lanternFishes = new HashMap<>();
        // Set up HashMap
        for (int i = 0; i < internalTimer; i++) {
            lanternFishes.put(i, 0L);
        }

        Arrays.stream(INPUT.getFirst().split(","))
                .map(Integer::parseInt)
                .toList()
                .forEach(timer -> lanternFishes.put(timer, lanternFishes.get(timer) + 1));

        return lanternFishes;
    }
}
