package _2021.day02;

import utils.FileReader;

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
        
        int multiplication = depth * horizontalPosition;
        
        System.out.println("Depth times the horizontal position gives:");
        System.out.println(multiplication);
    }
    
    private static List<String> getCommands() {
        return FileReader.readFile("/_2021/day02-input.txt");
    }
}
