package nl.davydehaas.adventofcode.year2024.day00;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.List;

class Part1 {

    private static final List<String> INPUT = readFile(2024, 0);

    public static void main(String[] args) {
        timeSolution(Part1::solve);
    }

    static int solve() {
        return INPUT.size();
    }
}
