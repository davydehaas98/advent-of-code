package nl.davydehaas.adventofcode.year2021.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Year2021Day07Test {

    @Test
    void part1() {
        Number result = Part1.solve();
        Assertions.assertEquals(349812, result);
    }

    @Test
    void part2() {
        Number result = Part2.solve();
        Assertions.assertEquals(99763899, result);
    }
}
