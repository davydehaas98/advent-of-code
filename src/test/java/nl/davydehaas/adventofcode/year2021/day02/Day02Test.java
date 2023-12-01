package nl.davydehaas.adventofcode.year2021.day02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day02Test {
    
    @Test
    void part1Test() {
        Integer result = Part1.calculate();
        Assertions.assertThat(result)
                .isEqualTo(1_524_750);
    }
    
    @Test
    void part2Test() {
        Integer result = Part2.calculate();
        Assertions.assertThat(result)
                .isEqualTo(1_592_426_537);
    }
}
