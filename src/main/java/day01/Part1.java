package main.java.day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            File file = new File("src/main/resources/day01-input.txt");
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
