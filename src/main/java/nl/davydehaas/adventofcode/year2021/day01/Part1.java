package nl.davydehaas.adventofcode.year2021.day01;

import nl.davydehaas.adventofcode.utils.Utils;

public class Part1 {
    public static void main(String[] args) {
        Integer result = calculate();
        
        System.out.println("Amount of measurements that are larger than the previous measurement:");
        System.out.println(result);
    }
    
    static int calculate() {
        int[] measurements = getMeasurements();
        
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
    
    private static int[] getMeasurements() {
        return Utils.readFile("/year2021/day01.txt").stream()
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
