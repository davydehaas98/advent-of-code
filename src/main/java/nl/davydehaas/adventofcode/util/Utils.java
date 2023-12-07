package nl.davydehaas.adventofcode.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Supplier;

public final class Utils {
    
    private Utils() {
    }
    
    public static void timeSolution(Supplier<Number> supplier) {
        long startTime = System.nanoTime();
        Number result = supplier.get();
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1000000F;
        System.out.printf("""
                Result:
                %s
                Duration (ms):
                %s
                """, result, duration);
    }
    
    public static List<String> readFile(int year, int day) {
        return readFile(year, day, false);
    }
    
    public static List<String> readFile(int year, int day, boolean isTest) {
        try {
            String pathPrefix = day < 10 ? "/year%d/day0%d" : "/year%d/day%d";
            String pathSuffix = isTest ? "-test.txt" : ".txt";
            return Files.readAllLines(Path.of(String.format("src/main/resources" + pathPrefix + pathSuffix, year, day)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
