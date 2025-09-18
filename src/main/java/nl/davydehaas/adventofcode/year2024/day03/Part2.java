package nl.davydehaas.adventofcode.year2024.day03;

import java.util.List;
import java.util.regex.Pattern;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

class Part2 {

    private static final List<String> INPUT = readFile(2024, 3);
    
    static void main() {
        timeSolution(Part2::solve);
    }

    static Number solve() {
        Pattern pattern = Pattern.compile("mul\\([0-9]{1,3},[0-9]{1,3}\\)|do\\(\\)|don't\\(\\)");
        long mul = 0;
        boolean enabled = true;
        var matcher = pattern.matcher(String.join("", INPUT));
        while (matcher.find()) {
            if ("do()".equals(matcher.group())) {
                enabled = true;
            } else if ("don't()".equals(matcher.group())) {
                enabled = false;
            } else if (enabled) {
                String[] numbers = matcher.group()
                        .substring(4)
                        .split("(\\D)");
                mul += Long.parseLong(numbers[0]) * Long.parseLong(numbers[1]);
            }
        }
        return mul;
    }
}
