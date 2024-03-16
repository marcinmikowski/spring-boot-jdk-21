package pl.mikus.learning.jdk21;

import org.junit.jupiter.api.Test;

import static java.util.FormatProcessor.FMT;
import static org.assertj.core.api.Assertions.assertThat;

class TextTemplateTest {

    String interpolationOfJSONBlockWithFMT(String feelsLike, float temperature, String unit) {
        return FMT."""
            {
                "feelsLike": "%1s\{ feelsLike }",
                "temperature": "%2.2f\{ temperature }",
                "unit": "%1s\{ unit }"
            }
            """;
    }

    @Test
    void textTemplateTest() throws Exception {
        var evaluated = interpolationOfJSONBlockWithFMT("Old man", 37.9f, "celsius");
        assertThat(evaluated).isEqualTo("""
                {
                    "feelsLike": "Old man",
                    "temperature": "37.90",
                    "unit": "celsius"
                }
                """);
    }
}
