package nl.davydehaas.adventofcode.year2025.day01;

import java.util.List;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part1 {
    
    private static final List<String> INPUT = readFile(2025, 1);
    
    void main() {
        timeSolution(Part1::solve);
    }
    
    static Number solve() {
        int dialState = 50;
        int pointsAtZero = 0;
        
        for (String instruction : INPUT) {
            char direction = instruction.charAt(0);
            int rotation = Integer.parseInt(instruction.substring(1)) % 100;
            
            
            if (direction == 'L') {
                if (dialState - rotation < 0) {
                    dialState = dialState + 100 - rotation;
                } else {
                    dialState -= rotation;
                }
            } else if (direction == 'R') {
                dialState += rotation;
                if (dialState > 99) {
                    dialState = dialState % 100;
                }
            }
            
            if (dialState == 0) {
                pointsAtZero++;
            }
        }
        
        return pointsAtZero;
    }
}
