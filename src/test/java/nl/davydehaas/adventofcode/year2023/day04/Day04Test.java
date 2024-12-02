package nl.davydehaas.adventofcode.year2023.day04;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Day04Test {

    @Test
    void part1Test() {
        int result = Part1.solve();
        Assertions.assertThat(result)
                .isEqualTo(20667);
    }

    @Test
    void part2Test() {
        int result = Part2.solve();
        Assertions.assertThat(result)
                .isEqualTo(5833065);
    }
}
