package nl.davydehaas.adventofcode.year2021.day08;

import nl.davydehaas.adventofcode.year2021.Year2021;

import java.util.Arrays;
import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

class Part1 extends Year2021 {
    
    private static final List<String> INPUT = readFile("/day08.txt");
    
    public static void main(String[] args) {
        timeSolution(Part1::calculate);
    }
    
    static Number calculate() {
        List<String> outputValues = getOutputValues();
        
        return outputValues.stream()
                .filter(string -> string.length() == 2
                        || string.length() == 3
                        || string.length() == 4
                        || string.length() == 7)
                .count();
    }
    
    private static List<String> getOutputValues() {
        return INPUT.stream()
                .flatMap(line -> Arrays.stream(line.split(" \\| ")[1].split(" ")))
                .toList();
    }
}
