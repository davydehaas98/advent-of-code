package nl.davydehaas.adventofcode.year2021.day10;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.ArrayList;
import java.util.List;

class Part2 {

    private static final List<String> INPUT = readFile(2021, 10);

    public static void main(String[] args) {
        timeSolution(Part2::solve);
    }

    static Long solve() {
        List<Long> points = new ArrayList<>();

        for (String line : INPUT) {
            line = removeValidChunks(line);
            // Check if line is not corrupted
            if (!line.contains(")") && !line.contains("]") && !line.contains("}") && !line.contains(">")) {
                points.add(calculateIncompleteLinePoints(line));
            }
        }

        return points.stream()
                .sorted()
                .toList()
                .get(points.size() / 2);
    }

    private static long calculateIncompleteLinePoints(String line) {
        long points = 0;

        for (int i = line.length() - 1; 0 <= i; i--) {
            points *= 5;

            switch (line.charAt(i)) {
                case '(' -> points += 1;
                case '[' -> points += 2;
                case '{' -> points += 3;
                case '<' -> points += 4;
            }
        }

        return points;
    }

    private static String removeValidChunks(String navigationLine) {
        while (true) {
            int lineLength = navigationLine.length();

            navigationLine = navigationLine.replace("()", "").replace("[]", "")
                    .replace("{}", "")
                    .replace("<>", "");

            if (lineLength == navigationLine.length()) {
                break;
            }
        }

        return navigationLine;
    }
}
