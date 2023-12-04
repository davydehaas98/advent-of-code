package nl.davydehaas.adventofcode.year2023.day01;

import nl.davydehaas.adventofcode.year2023.Year2023;

import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

class Part1 extends Year2023 {
    
    private static final List<String> INPUT = readFile("/day01.txt");
    
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
