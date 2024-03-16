package pl.mikus.learning.jdk21;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;

class FutureTest {

    @Test
    void futureTest() throws Exception {

        try (var executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())) {
            Future<String> future = executor.submit(() -> "Hello from Future Task!!");

            Thread.sleep(100);

            var result = switch(future.state()) {
                case CANCELLED, FAILED -> throw new IllegalStateException();
                case SUCCESS -> future.resultNow();
                default -> null;
            };

            assertThat(result).isEqualTo("Hello from Future Task!!");
        }
    }
}
