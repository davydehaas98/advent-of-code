package nl.davydehaas.adventofcode.year2024.day03;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.List;
import java.util.regex.Pattern;

class Part1 {

    private static final List<String> INPUT = readFile(2024, 3);

    public static void main(String[] args) {
        timeSolution(Part1::solve);
    }

    static Number solve() {
        Pattern pattern = Pattern.compile("mul\\([0-9]{1,3},[0-9]{1,3}\\)");
        long mul = 0;
        for (String line : INPUT) {
            var matcher = pattern.matcher(line);
            while (matcher.find()) {
                String[] numbers = matcher.group()
                        .substring(4)
                        .split("(\\D)");
                mul += Long.parseLong(numbers[0]) * Long.parseLong(numbers[1]);
            }
        }
        return mul;
    }
}
