package nl.davydehaas.adventofcode.year2023.day09;

import java.util.List;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part2 {
    
    private static final List<String> INPUT = readFile(2023, 9);
    
    void main() {
        timeSolution(Part2::solve);
    }
    
    static int solve() {
        return INPUT.size();
    }
}
