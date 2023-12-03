package nl.davydehaas.adventofcode.year2021.day02;

import nl.davydehaas.adventofcode.year2021.Year2021;

import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

class Part2 extends Year2021 {
    
    private static final List<String> INPUT = readFile("/day02.txt");
    
    public static void main(String[] args) {
        timeSolution(Part2::calculate);
    }
    
    static int calculate() {
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
