package nl.davydehaas.adventofcode.year2021.day06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Year2021Day06Test {

    @Test
    void part1() {
        Number result = Part1.solve();
        Assertions.assertEquals(387413, result);
    }

    @Test
    void part2() {
        Number result = Part2.solve();
        Assertions.assertEquals(1738377086345L, result);
    }
}
