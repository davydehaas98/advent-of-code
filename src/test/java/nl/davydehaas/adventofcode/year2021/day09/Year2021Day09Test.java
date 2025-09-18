package nl.davydehaas.adventofcode.year2021.day09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Year2021Day09Test {
    
    @Test
    void part1() {
        Number result = Part1.solve();
        Assertions.assertEquals(512, result);
    }
    
    @Test
    void part2() {
        Number result = Part2.solve();
        Assertions.assertEquals(1600104, result);
    }
}
