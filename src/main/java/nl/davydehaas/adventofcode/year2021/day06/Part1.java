package nl.davydehaas.adventofcode.year2021.day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

class Part1 {

    private static final List<String> INPUT = readFile(2021, 6);
    
    static void main() {
        timeSolution(Part1::solve);
    }

    static Number solve() {
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
        return Arrays.stream(INPUT.getFirst().split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
