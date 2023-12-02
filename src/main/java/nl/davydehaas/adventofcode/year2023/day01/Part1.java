package nl.davydehaas.adventofcode.year2023.day01;

import nl.davydehaas.adventofcode.year2023.Year2023;

import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

public class Part1 extends Year2023 {
    
    private static final List<String> INPUT = readFile("/day01.txt");
    
    public static void main(String[] args) {
        timeSolution(Part1::calculate);
    }
    
    static int calculate() {
        int sum = 0;
        
        for (String line : INPUT) {
            line = line.replaceAll("[(\\D)]", "");
            sum += Integer.parseInt(line.charAt(0) + "" + line.charAt(line.length() - 1));
        }
        
        return sum;
    }
}
