package nl.davydehaas.adventofcode.year2020;

import nl.davydehaas.adventofcode.utils.InputReader;

import java.util.List;

public abstract class Year2020 {
    
    private static final String YEAR = "2020";
    
    protected static List<String> readFile(String pathName) {
        return InputReader.readFile(YEAR + pathName);
    }
}
