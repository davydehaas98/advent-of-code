package nl.davydehaas.adventofcode.year2021.day02;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.List;

class Part2 {

    private static final List<String> INPUT = readFile(2021, 2);

    public static void main(String[] args) {
        timeSolution(Part2::solve);
    }

    static int solve() {
        int aim = 0;
        int depth = 0;
        int horizontalPosition = 0;

        for (String command : INPUT) {
            String[] commandArray = command.split(" ");
            String action = commandArray[0];
            int units = Integer.parseInt(commandArray[1]);

            switch (action) {
                case "forward" -> {
                    horizontalPosition += units;
                    depth += aim * units;
                }
                case "down" -> aim += units;
                case "up" -> aim -= units;
            }
        }
        return depth * horizontalPosition;
    }
}
