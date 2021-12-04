package main.java.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {
        List<Integer> measurements = getMeasurements();
        List<Integer> slidingWindows = getSlidingWindows(measurements);

        int largerMeasurements = countLargerMeasurements(slidingWindows);

        System.out.println(largerMeasurements + " measurements are larger than the previous measurement.");
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

        for (int measurement : measurements){
            if (measurement > previousMeasurement)
                largerMeasurementCounter++;
            previousMeasurement = measurement;
        }

        return largerMeasurementCounter;
    }

    private static List<Integer> getMeasurements() {
        List<Integer> measurements = new ArrayList<>();

        try {
            File file = new File("src/main/resources/day1-input.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                int measurement = Integer.parseInt(scanner.nextLine());
                measurements.add(measurement);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return measurements;
    }
}
