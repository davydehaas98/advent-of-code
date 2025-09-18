package nl.davydehaas.adventofcode.year2024.day01;

import java.util.ArrayList;
import java.util.List;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part1 {

    private static final List<String> INPUT = readFile(2024, 1);
    
    void main() {
        timeSolution(Part1::solve);
    }

    static Number solve() {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        for (String line : INPUT) {
            String[] pair = line.split(" {3}");
            addToSortedList(leftList, Integer.parseInt(pair[0]));
            addToSortedList(rightList, Integer.parseInt(pair[1]));
        }
        int totalDistance = 0;
        for (int i = 0; i < leftList.size(); i++) {
            totalDistance += Math.abs(Math.subtractExact(leftList.get(i), rightList.get(i)));
        }

        return totalDistance;
    }

    static void addToSortedList(List<Integer> list, int number) {
        for (int i = 0; i < list.size(); i++) {
            if (number <= list.get(i)) {
                list.add(i, number);
                return;
            }
        }
        list.add(number);
    }
}
