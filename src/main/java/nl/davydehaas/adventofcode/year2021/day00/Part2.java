package nl.davydehaas.adventofcode.year2021.day00;

import java.util.List;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

class Part2 {

    private static final List<String> INPUT = readFile(2021, 0);
    
    static void main() {
        timeSolution(Part2::solve);
    }

    static Number solve() {
        return INPUT.size();
    }
}
