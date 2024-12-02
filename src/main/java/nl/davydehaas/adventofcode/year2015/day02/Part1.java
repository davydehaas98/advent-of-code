package nl.davydehaas.adventofcode.year2015.day02;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.Arrays;
import java.util.List;

class Part1 {

    private static final List<String> INPUT = readFile(2015, 2);

    public static void main(String[] args) {
        timeSolution(Part1::solve);
    }

    static Number solve() {
        return INPUT.stream()
                .map(dimensions -> Arrays.stream(dimensions.split("x"))
                        .map(Integer::parseInt).toArray(Integer[]::new))
                .mapToInt(dimensions -> calculateWrapping(dimensions[0], dimensions[1], dimensions[2]))
                .sum();
    }

    private static int calculateWrapping(int l, int w, int h) {
        int x = l * w;
        int y = w * h;
        int z = h * l;

        int total = 2 * x + 2 * y + 2 * z;

        if (x <= y && x <= z) {
            return total + x;
        } else if (y <= x && y <= z) {
            return total + y;
        }
        return total + z;
    }
}
