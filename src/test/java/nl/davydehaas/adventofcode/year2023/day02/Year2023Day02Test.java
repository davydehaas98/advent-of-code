package nl.davydehaas.adventofcode.year2023.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Year2023Day02Test {

    @Test
    void part1() {
        Number result = Part1.solve();
        Assertions.assertEquals(2268, result);
    }

    @Test
    void part2() {
        Number result = Part2.solve();
        Assertions.assertEquals(63542, result);
    }
}
