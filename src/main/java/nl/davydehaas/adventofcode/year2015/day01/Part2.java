package nl.davydehaas.adventofcode.year2015.day01;

import java.util.List;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part2 {
    
    private static final List<String> INPUT = readFile(2015, 1);
    
    void main() {
        timeSolution(Part2::solve);
    }
    
    static Number solve() {
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
