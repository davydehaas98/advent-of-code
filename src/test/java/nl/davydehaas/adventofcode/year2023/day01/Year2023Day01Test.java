package nl.davydehaas.adventofcode.year2023.day01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Year2023Day01Test {
    
    @Test
    void part1() {
        Number result = Part1.solve();
        Assertions.assertEquals(55816, result);
    }
    
    @Test
    void part2() {
        Number result = Part2.solve();
        Assertions.assertEquals(54980, result);
    }
}
