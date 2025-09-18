package nl.davydehaas.adventofcode.year2023.day04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Year2023Day04Test {
    
    @Test
    void part1() {
        Number result = Part1.solve();
        Assertions.assertEquals(20667, result);
    }
    
    @Test
    void part2() {
        Number result = Part2.solve();
        Assertions.assertEquals(5833065, result);
    }
}
