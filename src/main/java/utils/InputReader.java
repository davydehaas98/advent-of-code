package utils;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class InputReader {
    @SneakyThrows
    public static List<String> readFile(String pathName) {
        return new ArrayList<>(Files.readAllLines(Path.of(String.format("src/main/resources/%s", pathName))));
    }
}
