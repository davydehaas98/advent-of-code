package nl.davydehaas.adventofcode.year2021.day08;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.Arrays;
import java.util.List;

class Part1 {

    private static final List<String> INPUT = readFile(2021, 8);

    public static void main(String[] args) {
        timeSolution(Part1::solve);
    }

    static Number solve() {
        List<String> outputValues = getOutputValues();

        return (int) outputValues.stream()
                .filter(string -> string.length() == 2
                        || string.length() == 3
                        || string.length() == 4
                        || string.length() == 7)
                .count();
    }

    private static List<String> getOutputValues() {
        return INPUT.stream()
                .flatMap(line -> Arrays.stream(line.split(" \\| ")[1].split(" ")))
                .toList();
    }
}
