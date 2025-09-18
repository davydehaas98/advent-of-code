package nl.davydehaas.adventofcode.year2021.day02;

import java.util.List;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part1 {

    private static final List<String> INPUT = readFile(2021, 2);
    
    void main() {
        timeSolution(Part1::solve);
    }

    static Number solve() {
        int depth = 0;
        int horizontalPosition = 0;

        for (String command : INPUT) {
            String[] commandArray = command.split(" ");
            String action = commandArray[0];
            int units = Integer.parseInt(commandArray[1]);

            switch (action) {
                case "forward" -> horizontalPosition += units;
                case "down" -> depth += units;
                case "up" -> depth -= units;
            }
        }

        return depth * horizontalPosition;
    }
}
