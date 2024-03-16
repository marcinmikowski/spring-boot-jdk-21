package pl.mikus.learning.jdk21;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleTest {

    @Test
    void sampleTest() throws Exception {
        assertThat(true).isTrue();
    }
}
