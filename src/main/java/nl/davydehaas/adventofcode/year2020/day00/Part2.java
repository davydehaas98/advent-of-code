package nl.davydehaas.adventofcode.year2020.day00;

import java.util.List;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part2 {
    
    private static final List<String> INPUT = readFile(2020, 0);
    
    void main() {
        timeSolution(Part2::solve);
    }
    
    static Number solve() {
        return INPUT.size();
    }
}
