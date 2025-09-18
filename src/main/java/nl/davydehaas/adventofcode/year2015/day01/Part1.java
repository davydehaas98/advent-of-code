package nl.davydehaas.adventofcode.year2015.day01;

import java.util.List;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part1 {

    private static final List<String> INPUT = readFile(2015, 1);
    
    void main() {
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
