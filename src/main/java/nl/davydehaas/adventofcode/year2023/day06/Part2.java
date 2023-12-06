package nl.davydehaas.adventofcode.year2023.day06;

import nl.davydehaas.adventofcode.year2023.Year2023;

import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

class Part2 extends Year2023 {
    
    private static final List<String> INPUT = readFile("/day06.txt");
    
    public static void main(String[] args) {
        timeSolution(Part2::calculate);
    }
    
    static long calculate() {
        long time = Long.parseLong(INPUT.get(0).replaceAll("\\D+", ""));
        long distance = Long.parseLong(INPUT.get(1).replaceAll("\\D+", ""));
        
        for (int t = 1; t < time; t++) {
            if (t * (time - t) > distance) {
                return time - 2L * t + 1;
            }
        }
        
        return 0L;
    }
}
