package nl.davydehaas.adventofcode.year2021.day08;

import nl.davydehaas.adventofcode.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part1 {
    public static void main(String[] args) {
        List<String> outputValues = getOutputValues();
        
        long digitCounter = outputValues
                .stream()
                .filter(string ->
                        string.length() == 2 || string.length() == 3 || string.length() == 4 || string.length() == 7
                ).count();
        
        System.out.println("The amount of appearances of digits 1, 4, 7 or 8 in the output values are:");
        System.out.println(digitCounter);
    }
    
    private static List<String> getOutputValues() {
        List<String> outputValues = new ArrayList<>();
        
        Utils.readFile("/year2021/day08.txt")
                .forEach(line ->
                        outputValues.addAll(Arrays.stream(line.split(" \\| ")[1].split(" ")).toList())
                );
        
        return outputValues;
    }
}
