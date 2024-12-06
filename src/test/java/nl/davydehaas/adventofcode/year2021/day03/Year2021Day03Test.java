package nl.davydehaas.adventofcode.year2021.day03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Year2021Day03Test {

    @Test
    void part1() {
        Number result = Part1.solve();
        Assertions.assertEquals(2583164, result);
    }

    @Test
    void part2() {
        Number result = Part2.solve();
        Assertions.assertEquals(2784375, result);
    }
}
