package nl.davydehaas._2021.day02;

import nl.davydehaas.utils.InputReader;

import java.util.List;

public class Part1 {
    public static void main(String[] args) {
        List<String> commands = getCommands();
        int depth = 0;
        int horizontalPosition = 0;
        
        for (String command : commands) {
            String[] commandArray = command.split(" ");
            String action = commandArray[0];
            int units = Integer.parseInt(commandArray[1]);
            
            switch (action) {
                case "forward" -> horizontalPosition += units;
                case "down" -> depth += units;
                case "up" -> depth -= units;
            }
        }
        
        int product = depth * horizontalPosition;
        
        System.out.println("The product of the depth and the horizontal position gives:");
        System.out.println(product);
    }
    
    private static List<String> getCommands() {
        return InputReader.readFile("/_2021/day02-input.txt");
    }
}
