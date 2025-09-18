package nl.davydehaas.adventofcode.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public final class Utils {

    private Utils() {
    }

    /// @param supplier The method to time as `Supplier`.
    public static void timeSolution(Supplier<Number> supplier) {
        long startTime = System.nanoTime();
        Number result = supplier.get();
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000F;
        System.out.printf("""
                %s
                Result:
                %s
                Duration (ms):
                %s
                """.formatted(supplier.getClass(), result, duration));
    }

    /// @param year   The year as `Integer`.
    /// @param day    The day as `Integer`.
    /// @return the file as `List` of lines as `String`.
    public static List<String> readFile(int year, int day) {
        return readFile(year, day, false);
    }

    /// @param year   The year as `Integer`.
    /// @param day    The day as `Integer`.
    /// @param isTest Set this to true if it should use the `*-test.txt` file instead.
    /// @return the file as `List` of lines as `String`.
    public static List<String> readFile(int year, int day, boolean isTest) {
        String pathPrefix = day < 10 ? "/year%d/day0%d" : "/year%d/day%d";
        String pathSuffix = isTest ? "-test.txt" : ".txt";
        String fileName = String.format("src/main/resources" + pathPrefix + pathSuffix, year, day);
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName), 8192)) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
