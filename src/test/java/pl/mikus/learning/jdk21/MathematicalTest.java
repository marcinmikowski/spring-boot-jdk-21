package pl.mikus.learning.jdk21;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

class MathematicalTest {

    @Test
    void divideExactTest() {
        var result = Math.divideExact(10, 2);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void bigIntegerMultiplicationTest() throws Exception {
        var twenty = BigInteger.valueOf(20);

        assertThat(BigInteger.TWO.parallelMultiply(twenty)).isEqualTo(BigInteger.valueOf(20 * 2));
    }
}
