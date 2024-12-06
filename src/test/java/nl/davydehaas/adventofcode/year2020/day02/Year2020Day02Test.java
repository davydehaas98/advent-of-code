package nl.davydehaas.adventofcode.year2020.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Year2020Day02Test {

    @Test
    void part1() {
        Number result = Part1.solve();
        Assertions.assertEquals(569, result);
    }

    @Test
    void part2() {
        Number result = Part2.solve();
        Assertions.assertEquals(346, result);
    }
}
