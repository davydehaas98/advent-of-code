package nl.davydehaas.adventofcode.year2023.day07;

import java.util.List;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part1 {
    
    private static final List<String> INPUT = readFile(2023, 7);
    
    void main() {
        timeSolution(Part1::solve);
    }
    
    static int solve() {
        char[] strength = new char[]{'A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2'};
        return INPUT.size();
    }
}
