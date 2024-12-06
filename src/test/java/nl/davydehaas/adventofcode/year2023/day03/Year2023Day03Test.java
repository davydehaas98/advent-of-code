package nl.davydehaas.adventofcode.year2023.day03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Year2023Day03Test {

    @Test
    void part1() {
        Number result = Part1.solve();
        Assertions.assertEquals(557705, result);
    }

    @Test
    void part2() {
        Number result = Part2.solve();
        Assertions.assertEquals(84266818, result);
    }
}
