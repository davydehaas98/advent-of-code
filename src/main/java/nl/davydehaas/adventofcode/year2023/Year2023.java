package nl.davydehaas.adventofcode.year2023;

import nl.davydehaas.adventofcode.utils.Utils;

import java.util.List;

public abstract class Year2023 {
    
    protected static List<String> readFile(String pathName) {
        return Utils.readFile("/year2023/" + pathName);
    }
}