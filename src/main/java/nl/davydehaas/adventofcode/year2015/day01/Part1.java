package nl.davydehaas.adventofcode.year2015.day01;

import java.util.List;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

class Part1 {
    
    private static final List<String> INPUT = readFile(2015, 0);
    
    public static void main(String[] args) {
        timeSolution(Part1::solve);
    }
    
    static int solve() {
        return INPUT.size();
    }
}
