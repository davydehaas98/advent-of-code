package nl.davydehaas.adventofcode.year2021.day01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day01Test {
    
    @Test
    void part1Test() {
        int result = Part1.calculate();
        Assertions.assertThat(result)
                .isEqualTo(1676);
    }
}
