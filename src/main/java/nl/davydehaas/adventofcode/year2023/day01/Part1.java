package nl.davydehaas.adventofcode.year2023.day01;

import java.util.List;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

class Part1 {
    
    private static final List<String> INPUT = readFile(2023, 1);
    
    public static void main(String[] args) {
        timeSolution(Part1::calculate);
    }
    
    static int calculate() {
        int sum = 0;
        
        for (String line : INPUT) {
            char firstNumber = '0';
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    firstNumber = line.charAt(i);
                    break;
                }
            }
            for (int i = line.length() - 1; i > -1; i--) {
                if (Character.isDigit(line.charAt(i))) {
                    sum += Integer.parseInt(firstNumber + "" + line.charAt(i));
                    break;
                }
            }
        }
        
        return sum;
    }
}
