package nl.davydehaas.adventofcode.year2023.day03;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Day03Test {
    
    @Test
    void part1Test() {
        Integer result = Part1.calculate();
        Assertions.assertThat(result)
                .isEqualTo(557705);
    }
    
    @Test
    void part2Test() {
        Integer result = Part2.calculate();
        Assertions.assertThat(result)
                .isEqualTo(84266818);
    }
}
