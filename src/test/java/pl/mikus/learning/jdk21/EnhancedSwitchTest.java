package pl.mikus.learning.jdk21;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

import static org.assertj.core.api.Assertions.assertThat;

class EnhancedSwitchTest {

    private int calculateTimeOffClassic(DayOfWeek dayOfWeek) {
        var timeOff = 0;
        switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY:
                timeOff = 16; break;
            case SATURDAY, SUNDAY:
                timeOff = 24; break;
//            case null:
//                timeOff = 0; break;
        }
        return timeOff;
    }

    @Test
    void calculateTimeOffClassicTest() {
        assertThat(calculateTimeOffClassic(DayOfWeek.MONDAY)).isEqualTo(16);
        assertThat(calculateTimeOffClassic(DayOfWeek.SUNDAY)).isEqualTo(24);
        // assertThat(calculateTimeOffClassic(null)).isEqualTo(0);
    }

    private int calculateTimeOff(DayOfWeek dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> 16;
            case SATURDAY, SUNDAY -> 24;
            case null -> 0;
        };
    }

    @Test
    void calculateTimeOffTest() {
        assertThat(calculateTimeOff(DayOfWeek.MONDAY)).isEqualTo(16);
        assertThat(calculateTimeOff(DayOfWeek.SUNDAY)).isEqualTo(24);
        assertThat(calculateTimeOff(null)).isEqualTo(0);
    }

}
