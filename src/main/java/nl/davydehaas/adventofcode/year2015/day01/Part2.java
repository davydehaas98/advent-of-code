package nl.davydehaas.adventofcode.year2015.day01;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.List;

class Part2 {
    
    private static final List<String> INPUT = readFile(2015, 1);
    
    public static void main(String[] args) {
        timeSolution(Part2::solve);
    }
    
    static int solve() {
        int floor = 0;
        char[] instructions = INPUT.getFirst().toCharArray();

        for (int i = 0; i < instructions.length; i++) {
            switch (instructions[i]) {
                case '(' -> floor++;
                case ')' -> floor--;
            }
            if (floor < 0) {
                return i + 1;
            }
        }
        throw new RuntimeException();
    }
}
