package pl.mikus.learning.jdk21;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

class LoomTest {
//
//    @Test
//    void sampleTest() throws Exception {
//        assertThat(true).isTrue();
//    }


    private static AtomicInteger ai = new AtomicInteger(0);

    static void handleRequest(Socket socket) throws Exception {

        try (var baos = new ByteArrayOutputStream()) {
            try (var is = socket.getInputStream()) {
                is.transferTo(baos);
//                var i = -1;
//                while ((i = is.read()) != -1) {
//                    baos.write(i);
//                }
            }

            TimeUnit.SECONDS.sleep(1);

            System.out.printf("%d request: %s%n", ai.incrementAndGet(), baos);
        }
    }

    public static void main(String[] args) throws Exception {
        var executor = Executors.newVirtualThreadPerTaskExecutor(); //(Runtime.getRuntime().availableProcessors());

        try (var socket = new ServerSocket(9090)) {
            while (true) {
                Socket accepted = socket.accept();
                executor.submit(() -> {
                    try {
                        handleRequest(accepted);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }
}
