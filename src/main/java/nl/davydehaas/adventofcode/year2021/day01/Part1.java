package nl.davydehaas.adventofcode.year2021.day01;

import java.util.List;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part1 {
    
    private static final List<String> INPUT = readFile(2021, 1);
    
    void main() {
        timeSolution(Part1::solve);
    }
    
    static Number solve() {
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
