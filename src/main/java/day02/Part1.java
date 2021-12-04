package main.java.day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        List<String> commands = getCommands();
        int depth = 0;
        int horizontalPosition = 0;

        for (String command : commands){
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

        System.out.println("Depth times the horizontal position gives " + multiplication);
    }

    private static List<String> getCommands() {
        List<String> commands = new ArrayList<>();

        try {
            File file = new File("src/main/resources/day2-input.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine();
                commands.add(command);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return commands;
    }
}
