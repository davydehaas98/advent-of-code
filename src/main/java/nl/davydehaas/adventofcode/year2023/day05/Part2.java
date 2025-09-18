package nl.davydehaas.adventofcode.year2023.day05;

import java.util.ArrayList;
import java.util.List;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

class Part2 {

    private static final List<String> INPUT = readFile(2023, 5);
    
    static void main() {
        timeSolution(Part2::solve);
    }

    static Number solve() {
        return 0;
    }

    private static List<List<Map>> createAlmanac() {
        List<List<Map>> almanac = new ArrayList<>();
        List<Map> category = new ArrayList<>();

        for (int i = 2; i < INPUT.size(); i++) {
            String line = INPUT.get(i);
            if (line.isBlank()) {
                almanac.add(category);
                continue;
            }
            if (line.contains("map:")) {
                category = new ArrayList<>();
                continue;
            }
            String[] s = line.split(" ");
            category.add(new Map(Long.parseLong(s[0]), Long.parseLong(s[1]), Long.parseLong(s[2])));
        }
        almanac.add(category);

        return almanac;
    }

    private record Map(long destination, long source, long range) {
    }
}
