package nl.davydehaas.adventofcode.year2023.day08;

import java.util.List;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

class Part2 {
    
    private static final List<String> INPUT = readFile(2023, 8);
    
    public static void main(String[] args) {
        timeSolution(Part2::solve);
    }
    
    static int solve() {
        return INPUT.size();
    }
}
