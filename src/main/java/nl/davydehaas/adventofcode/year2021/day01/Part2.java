package nl.davydehaas.adventofcode.year2021.day01;

import nl.davydehaas.adventofcode.utils.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Part2 {
    public static void main(String[] args) {
        List<Integer> measurements = getMeasurements();
        List<Integer> slidingWindows = getSlidingWindows(measurements);
        
        int largerMeasurements = countLargerMeasurements(slidingWindows);
        
        System.out.println("Amount of measurements that are larger than the previous measurement:");
        System.out.println(largerMeasurements);
    }
    
    private static List<Integer> getSlidingWindows(List<Integer> measurements) {
        List<Integer> slidingWindows = new ArrayList<>();
        
        for (int i = 0; i < measurements.size(); i++) {
            try {
                int firstMeasurement = measurements.get(i);
                int secondMeasurement = measurements.get(i + 1);
                int thirdMeasurement = measurements.get(i + 2);
                
                int slidingWindow = firstMeasurement + secondMeasurement + thirdMeasurement;
                slidingWindows.add(slidingWindow);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        
        return slidingWindows;
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
