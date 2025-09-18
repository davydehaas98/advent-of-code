package nl.davydehaas.adventofcode.year2024.day01;

import java.util.ArrayList;
import java.util.List;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part2 {

    private static final List<String> INPUT = readFile(2024, 1);
    
    void main() {
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
