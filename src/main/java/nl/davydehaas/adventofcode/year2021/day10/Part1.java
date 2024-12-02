package nl.davydehaas.adventofcode.year2021.day10;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class Part1 {

    private static final List<String> INPUT = readFile(2021, 10);

    public static void main(String[] args) {
        timeSolution(Part1::solve);
    }

    static int solve() {
        AtomicInteger points = new AtomicInteger();

        for (String line : INPUT) {
            points.addAndGet(calculateCorruptedLinePoints(removeValidChunks(line)));
        }

        return points.get();
    }

    private static String removeValidChunks(String navigationLine) {
        int startLength = navigationLine.length();

        String modifiedNavigationLine = navigationLine
                .replace("()", "")
                .replace("[]", "")
                .replace("{}", "")
                .replace("<>", "");

        // Check if navigation line is modified
        if (startLength != modifiedNavigationLine.length()) {
            return removeValidChunks(modifiedNavigationLine);
        }

        return modifiedNavigationLine;
    }

    private static int calculateCorruptedLinePoints(String line) {
        for (char c : line.toCharArray()) {
            switch (c) {
                case ')':
                    return 3;
                case ']':
                    return 57;
                case '}':
                    return 1197;
                case '>':
                    return 25137;
            }
        }

        return 0;
    }
}
