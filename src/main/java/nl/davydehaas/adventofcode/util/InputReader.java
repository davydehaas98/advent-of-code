package nl.davydehaas.adventofcode.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public final class InputReader {
    
    private InputReader() {
    }
    
    /// @param year The year as [Integer].
    /// @param day  The day as [Integer].
    /// @return the file as [List] of lines as [String].
    public static List<String> readFile(int year, int day) {
        return readFile(year, day, false);
    }
    
    /// @param year   The year as [Integer].
    /// @param day    The day as [Integer].
    /// @param isTest Set this to true if it should use the `*-test.txt` file instead.
    /// @return the file as [List] of lines as [String].
    public static List<String> readFile(int year, int day, boolean isTest) {
        String pathPrefix = day < 10 ? "/year%d/day0%d" : "/year%d/day%d";
        String pathSuffix = isTest ? "-test.txt" : ".txt";
        String fileName = String.format("src/main/resources" + pathPrefix + pathSuffix, year, day);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName), 8192)) {
            return reader.lines().toList();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
