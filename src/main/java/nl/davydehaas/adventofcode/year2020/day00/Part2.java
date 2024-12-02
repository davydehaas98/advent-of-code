package nl.davydehaas.adventofcode.year2020.day00;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.List;

class Part2 {

    private static final List<String> INPUT = readFile(2020, 0);

    public static void main(String[] args) {
        timeSolution(Part2::solve);
    }

    static int solve() {
        return INPUT.size();
    }
}
