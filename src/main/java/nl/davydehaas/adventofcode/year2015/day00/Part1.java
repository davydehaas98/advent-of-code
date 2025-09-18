package nl.davydehaas.adventofcode.year2015.day00;

import java.util.List;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part1 {
    
    private static final List<String> INPUT = readFile(2015, 0);
    
    void main() {
        timeSolution(Part1::solve);
    }
    
    static Number solve() {
        return INPUT.size();
    }
}
