package nl.davydehaas.adventofcode.year2020.day01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Year2020Day01Test {
    
    @Test
    void part1Test() {
        Integer result = Part1.calculate();
        Assertions.assertThat(result)
                .isEqualTo(437_931);
    }
    
    @Test
    void part2Test() {
        Integer result = Part2.calculate();
        Assertions.assertThat(result)
                .isEqualTo(157_667_328);
    }
}
