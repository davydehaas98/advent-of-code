package nl.davydehaas.adventofcode.year2024.day01;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.ArrayList;
import java.util.List;

class Part1 {
    
    private static final List<String> INPUT = readFile(2024, 1);
    
    public static void main(String[] args) {
        timeSolution(Part1::solve);
    }
    
    static int solve() {
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
