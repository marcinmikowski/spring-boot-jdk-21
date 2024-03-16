package pl.mikus.learning.jdk21;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RecordTest {

    record JdkReleasedEvent(String name) {}

    @Test
    void recordTest() {
        var jdkReleasedEvent = new JdkReleasedEvent("Java-21");
        System.out.println(jdkReleasedEvent);
        assertThat(jdkReleasedEvent.name()).isEqualTo("Java-21");
        assertThat(jdkReleasedEvent.name).isEqualTo("Java-21");
    }
}
