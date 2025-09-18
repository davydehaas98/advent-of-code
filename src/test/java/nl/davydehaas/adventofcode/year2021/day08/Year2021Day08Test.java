package nl.davydehaas.adventofcode.year2021.day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Year2021Day08Test {
    
    @Test
    void part1() {
        Number result = Part1.solve();
        Assertions.assertEquals(362, result);
    }
    
    @Test
    void part2() {
        Number result = Part2.solve();
        Assertions.assertEquals(1020159, result);
    }
}
