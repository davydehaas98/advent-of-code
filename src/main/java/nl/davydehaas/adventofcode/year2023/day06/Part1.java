package nl.davydehaas.adventofcode.year2023.day06;

import java.util.Arrays;
import java.util.List;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

class Part1 {
    
    private static final List<String> INPUT = readFile(2023, 6);
    
    public static void main(String[] args) {
        timeSolution(Part1::calculate);
    }
    
    static int calculate() {
        int[] time = Arrays.stream(INPUT.get(0).split(":\\s+")[1].split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] distance = Arrays.stream(INPUT.get(1).split(":\\s+")[1].split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        int totalWins = 1;
        for (int race = 0; race < time.length; race++) {
            int currentTime = time[race];
            int currentDistance = distance[race];
            for (int t = 0; t < currentTime; t++) {
                if (t * (currentTime - t) > currentDistance) {
                    totalWins = (currentTime - 2 * t + 1) * totalWins;
                    break;
                }
            }
        }
        
        return totalWins;
    }
}
