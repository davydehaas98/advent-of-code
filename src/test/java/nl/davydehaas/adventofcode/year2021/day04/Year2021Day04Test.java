package nl.davydehaas.adventofcode.year2021.day04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Year2021Day04Test {
    
    @Test
    void part1() {
        Number result = Part1.solve();
        Assertions.assertEquals(23177, result);
    }
    
    @Test
    void part2() {
        Number result = Part2.solve();
        Assertions.assertEquals(6804, result);
    }
}
