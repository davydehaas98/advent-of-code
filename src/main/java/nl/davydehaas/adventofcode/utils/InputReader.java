package nl.davydehaas.adventofcode.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class InputReader {
    public static List<String> readFile(String pathName) {
        try {
            return new ArrayList<>(Files.readAllLines(Path.of(String.format("src/main/resources/%s", pathName))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
