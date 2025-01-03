package nl.davydehaas.adventofcode.year2024.day01;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.ArrayList;
import java.util.List;

class Part2 {

    private static final List<String> INPUT = readFile(2024, 1);

    public static void main(String[] args) {
        timeSolution(Part2::solve);
    }

    static Number solve() {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        for (String line : INPUT) {
            String[] pair = line.split(" {3}");
            leftList.add(Integer.valueOf(pair[0]));
            rightList.add(Integer.valueOf(pair[1]));
        }

        return leftList.stream()
                .mapToLong(left -> left * rightList.stream()
                        .filter(left::equals)
                        .count())
                .sum();
    }
}
