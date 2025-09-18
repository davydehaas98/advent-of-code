package nl.davydehaas.adventofcode.year2023.day06;

import java.util.Arrays;
import java.util.List;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part1 {

    private static final List<String> INPUT = readFile(2023, 6);
    
    void main() {
        timeSolution(Part1::solve);
    }

    static Number solve() {
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
