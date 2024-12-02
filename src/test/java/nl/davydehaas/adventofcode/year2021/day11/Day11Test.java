package nl.davydehaas.adventofcode.year2021.day11;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day11Test {

    @Test
    void part1Test() {
        int result = Part1.solve();
        Assertions.assertThat(result)
                .isEqualTo(1697);
    }

    @Test
    void part2Test() {
        int result = Part2.solve();
        Assertions.assertThat(result)
                .isEqualTo(344);
    }
}
