package nl.davydehaas.adventofcode.year2021.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Year2021Day02Test {
    
    @Test
    void part1() {
        Number result = Part1.solve();
        Assertions.assertEquals(1524750, result);
    }
    
    @Test
    void part2() {
        Number result = Part2.solve();
        Assertions.assertEquals(1592426537, result);
    }
}
