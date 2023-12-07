package nl.davydehaas.adventofcode.year2023.day00;

import java.util.List;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

class Part1 {
    
    private static final List<String> INPUT = readFile(2023, 0);
    
    public static void main(String[] args) {
        timeSolution(Part1::calculate);
    }
    
    static int calculate() {
        return INPUT.size();
    }
}
