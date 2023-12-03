package nl.davydehaas.adventofcode.year2021;

import nl.davydehaas.adventofcode.utils.Utils;

import java.util.List;

public abstract class Year2021 {
    
    protected static List<String> readFile(String pathName) {
        return Utils.readFile("/year2021/" + pathName);
    }
}
