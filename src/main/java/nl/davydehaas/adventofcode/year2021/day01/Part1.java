package nl.davydehaas.adventofcode.year2021.day01;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.List;

class Part1 {

    private static final List<String> INPUT = readFile(2021, 1);

    public static void main(String[] args) {
        timeSolution(Part1::solve);
    }

    static int solve() {
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
