package nl.davydehaas.adventofcode.year2021.day01;

import nl.davydehaas.adventofcode.year2021.Year2021;

import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

class Part1 extends Year2021 {
    
    private static final List<String> INPUT = readFile("/day01.txt");
    
    public static void main(String[] args) {
        timeSolution(Part1::calculate);
    }
    
    static int calculate() {
        int[] measurements = INPUT.stream()
                .mapToInt(Integer::parseInt)
                .toArray();
        
        int largerMeasurementCounter = 0;
        int previousMeasurement = measurements[0];
        
        for (int measurement : measurements) {
            if (measurement > previousMeasurement) {
                largerMeasurementCounter++;
            }
            previousMeasurement = measurement;
        }
        
        return largerMeasurementCounter;
    }
}
