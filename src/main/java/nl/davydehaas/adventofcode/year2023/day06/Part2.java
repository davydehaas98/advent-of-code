package nl.davydehaas.adventofcode.year2023.day06;

import nl.davydehaas.adventofcode.year2023.Year2023;

import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

class Part2 extends Year2023 {
    
    private static final List<String> INPUT = readFile("/day06-test.txt");
    
    public static void main(String[] args) {
        timeSolution(Part2::calculate);
    }
    
    static long calculate() {
        long time = Long.parseLong(INPUT.get(0).replaceAll("\\D+", ""));
        long distance = Long.parseLong(INPUT.get(1).replaceAll("\\D+", ""));
        
        long boundary = findBoundary(time, 0, time / 2, distance);
        
        return time - boundary * 2 + 1;
    }
    
    private static long findBoundary(long time, long left, long right, long distance) {
        long middle = left + (right - left) / 2;
        long currentDistance = middle * (time - middle);
        if (currentDistance == distance) {
            return middle + 1;
        } else if (currentDistance < distance) {
            left = middle + 1;
            return findBoundary(time, left, right, distance);
        } else {
            right = middle - 1;
            if (left > right) {
                return left;
            }
            return findBoundary(time, left, right, distance);
        }
    }
}
