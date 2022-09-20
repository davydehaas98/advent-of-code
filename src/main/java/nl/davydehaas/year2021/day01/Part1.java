package nl.davydehaas.year2021.day01;

import nl.davydehaas.utils.InputReader;

import java.util.List;

public class Part1 {
    public static void main(String[] args) {
        List<Integer> measurements = getMeasurements();
        
        int largerMeasurements = countLargerMeasurements(measurements);
        
        System.out.println("Amount of measurements that are larger than the previous measurement:");
        System.out.println(largerMeasurements);
    }
    
    private static int countLargerMeasurements(List<Integer> measurements) {
        int largerMeasurementCounter = 0;
        int previousMeasurement = measurements.get(0);
        
        for (int measurement : measurements) {
            if (measurement > previousMeasurement) {
                largerMeasurementCounter++;
            }
            previousMeasurement = measurement;
        }
        
        return largerMeasurementCounter;
    }
    
    private static List<Integer> getMeasurements() {
        return InputReader.readFile("/year2021/day01-input.txt")
                .stream()
                .map(Integer::parseInt)
                .toList();
    }
}
