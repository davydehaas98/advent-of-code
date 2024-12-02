package nl.davydehaas.adventofcode.year2015.day00;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.List;

class Part1 {

    private static final List<String> INPUT = readFile(2015, 0);

    public static void main(String[] args) {
        timeSolution(Part1::solve);
    }

    static Number solve() {
        return INPUT.size();
    }
}
