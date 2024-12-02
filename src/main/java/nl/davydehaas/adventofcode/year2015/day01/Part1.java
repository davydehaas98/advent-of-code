package nl.davydehaas.adventofcode.year2015.day01;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.List;

class Part1 {

    private static final List<String> INPUT = readFile(2015, 1);

    public static void main(String[] args) {
        timeSolution(Part1::solve);
    }

    static Number solve() {
        int floor = 0;
        char[] instructions = INPUT.getFirst().toCharArray();

        for (char instruction : instructions) {
            switch (instruction) {
                case '(' -> floor++;
                case ')' -> floor--;
            }
        }

        return floor;
    }
}
