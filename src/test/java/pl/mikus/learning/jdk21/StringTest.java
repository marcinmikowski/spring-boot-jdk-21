package pl.mikus.learning.jdk21;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringTest {

    @Test
    void repeatTest() {
        var sb = new StringBuilder();
        sb.repeat("-", 10);
        assertThat(sb.toString()).isEqualTo("----------");
    }

    @Test
    void stringEmojiTest() throws Exception {
        var shockedFaceEmoji = "\uD83E\uDD2F";
        int i = shockedFaceEmoji.codePointAt(0);
        assertThat(Character.isEmoji(i)).isTrue();
        System.out.println(shockedFaceEmoji);
    }
}
