package pl.mikus.learning.jdk21;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.assertj.core.api.Assertions.assertThat;

class HttpTest {
    @Test
    void httpTest() throws Exception {
        try (var http = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.wp.pl")).GET().build();
            HttpResponse<String> send = http.send(request, HttpResponse.BodyHandlers.ofString());
            assertThat(send.statusCode()).isEqualTo(200);
            System.out.println(send.body());
        }
    }
}
