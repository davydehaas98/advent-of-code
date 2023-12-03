package nl.davydehaas.adventofcode.year2021.day02;

import nl.davydehaas.adventofcode.year2021.Year2021;

import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

class Part1 extends Year2021 {
    
    private static final List<String> INPUT = readFile("/day02.txt");
    
    public static void main(String[] args) {
        timeSolution(Part1::calculate);
    }
    
    static int calculate() {
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
