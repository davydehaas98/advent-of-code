package nl.davydehaas.adventofcode.year2015.day02;

import java.util.Arrays;
import java.util.List;

import static nl.davydehaas.adventofcode.util.InputReader.readFile;
import static nl.davydehaas.adventofcode.util.SolutionTimer.timeSolution;

class Part2 {

    private static final List<String> INPUT = readFile(2015, 2);
    
    void main() {
        timeSolution(Part2::solve);
    }

    static Number solve() {
        return INPUT.stream()
                .map(dimensions -> Arrays.stream(dimensions.split("x"))
                        .map(Integer::parseInt).toArray(Integer[]::new))
                .mapToInt(dimensions -> calculateRibbon(dimensions[0], dimensions[1], dimensions[2]))
                .sum();
    }

    private static int calculateRibbon(int l, int w, int h) {
        int lowestX;
        if (l < w) {
            lowestX = Math.min(l, h);
        } else {
            lowestX = Math.min(w, h);
        }

        int lowestY;
        if (l >= lowestX) {
            if (l < w) {
                lowestY = Math.min(l, h);
            } else {
                lowestY = Math.min(l, w);
            }
        }
        if (w >= lowestX) {
            if (w < l) {
                lowestY = Math.min(w, h);
            } else {
                lowestY = Math.min(w, h);
            }
        }
        if (h >= lowestX) {
            if (h < l) {
                lowestY = Math.min(h, w);
            } else {
                lowestY = Math.min(h, l);
            }
        } else {
            lowestY = lowestX;
        }

        int bow = l * w * h;
        return lowestX * 2 + lowestY * 2 + bow;
    }
}
