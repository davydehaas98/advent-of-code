package nl.davydehaas.adventofcode.year2023.day01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day01Test {
    
    @Test
    void part1Test() {
        Integer result = Part1.calculate();
        Assertions.assertThat(result)
                .isEqualTo(55816);
    }
    
    @Test
    void part2Test() {
        Integer result = Part2.calculate();
        Assertions.assertThat(result)
                .isEqualTo(54980);
    }
}
