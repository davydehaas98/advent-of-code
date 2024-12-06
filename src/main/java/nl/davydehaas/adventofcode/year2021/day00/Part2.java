package nl.davydehaas.adventofcode.year2021.day00;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.List;

class Part2 {

    private static final List<String> INPUT = readFile(2021, 0);

    public static void main(String[] args) {
        timeSolution(Part2::solve);
    }

    static Number solve() {
        return INPUT.size();
    }
}
