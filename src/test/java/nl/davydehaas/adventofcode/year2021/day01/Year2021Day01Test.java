package nl.davydehaas.adventofcode.year2021.day01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Year2021Day01Test {

    @Test
    void part1() {
        Number result = Part1.solve();
        Assertions.assertEquals(1676, result);
    }

    @Test
    void part2() {
        Number result = Part2.solve();
        Assertions.assertEquals(1706, result);
    }
}
