package nl.davydehaas.adventofcode.year2023.day09;

import java.util.List;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

class Part1 {
    
    private static final List<String> INPUT = readFile(2023, 9);
    
    static void main() {
        timeSolution(Part1::solve);
    }
    
    static int solve() {
        return INPUT.size();
    }
}
