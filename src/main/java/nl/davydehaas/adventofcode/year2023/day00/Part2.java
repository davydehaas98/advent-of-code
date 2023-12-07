package nl.davydehaas.adventofcode.year2023.day00;

import java.util.List;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

class Part2 {
    
    private static final List<String> INPUT = readFile(2023, 0);
    
    public static void main(String[] args) {
        timeSolution(Part2::calculate);
    }
    
    static int calculate() {
        return INPUT.size();
    }
}
