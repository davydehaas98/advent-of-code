package nl.davydehaas.adventofcode.year2020.day02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day02Test {
    
    @Test
    void part1Test() {
        Integer result = Part1.solve();
        Assertions.assertThat(result)
                .isEqualTo(569);
    }
    
    @Test
    void part2Test() {
        Integer result = Part2.solve();
        Assertions.assertThat(result)
                .isEqualTo(346);
    }
}
