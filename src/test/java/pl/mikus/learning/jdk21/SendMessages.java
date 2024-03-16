package pl.mikus.learning.jdk21;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SendMessages {

    static AtomicInteger ai = new AtomicInteger(0);

    static void sendMessage(int i) throws Exception {
        try (Socket socket = new Socket("localhost", 9090)) {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello world!".getBytes());
        } catch (Exception e) {
            System.out.printf("Cannot send message: %d%n", ai.get());
            return;
            //throw new RuntimeException(e.getMessage(), e);
        }

        System.out.printf("Message sent %d%n", ai.incrementAndGet());
    }

    public static void main(String[] args) throws Exception {
        int concurrency = 100;
        try (ExecutorService service = Executors.newCachedThreadPool()) {

            for (int i = 0; i < concurrency; i++) {
                final int j = i;
                service.submit(() -> {
                    try {
                        sendMessage(j);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            }

            service.shutdown();
            service.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        }
    }
}
