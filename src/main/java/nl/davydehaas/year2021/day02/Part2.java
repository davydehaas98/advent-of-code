package nl.davydehaas.year2021.day02;

import nl.davydehaas.utils.InputReader;

import java.util.List;

public class Part2 {
    public static void main(String[] args) {
        List<String> commands = getCommands();
        int aim = 0;
        int depth = 0;
        int horizontalPosition = 0;
        
        for (String command : commands) {
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
        int product = depth * horizontalPosition;
        
        System.out.println("The product of the depth and the horizontal position gives:");
        System.out.println(product);
    }
    
    private static List<String> getCommands() {
        return InputReader.readFile("/year2021/day02-input.txt");
    }
}
