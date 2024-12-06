package nl.davydehaas.adventofcode.year2021.day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Year2021Day10Test {

    @Test
    void part1() {
        Number result = Part1.solve();
        Assertions.assertEquals(442131, result);
    }

    @Test
    void part2() {
        Number result = Part2.solve();
        Assertions.assertEquals(3646451424L, result);
    }
}
