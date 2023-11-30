package nl.davydehaas.adventofcode.year2020.day02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day2Test {
    
    @Test
    void part1Test() {
        Integer result = Part1.calculate();
        Assertions.assertThat(result)
                .isEqualTo(569);
    }
    
    @Test
    void part2Test() {
        Integer result = Part2.calculate();
        Assertions.assertThat(result)
                .isEqualTo(346);
    }
}
