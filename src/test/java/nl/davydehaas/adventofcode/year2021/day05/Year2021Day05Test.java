package nl.davydehaas.adventofcode.year2021.day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Year2021Day05Test {

    @Test
    void part1() {
        Number result = Part1.solve();
        Assertions.assertEquals(5774, result);
    }

    @Test
    void part2() {
        Number result = Part2.solve();
        Assertions.assertEquals(18423, result);
    }
}
