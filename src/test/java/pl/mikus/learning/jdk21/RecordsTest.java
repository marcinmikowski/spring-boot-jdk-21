package pl.mikus.learning.jdk21;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RecordsTest {

    record User(String name, int accountNumber) {}

    record UserCreatedEvent(User user) {}
    record UserDeletedEvent(String name) {}

    String message(Object event) {
        return switch(event) {
            case UserCreatedEvent(var user) -> "User name " + user.name + " has been created";
            case UserDeletedEvent(var name) -> "User name " + name + " has been deleted";
            default -> null;
        };
    }

    @Test
    void eventMessageTest() throws Exception {
        assertThat(message(new UserCreatedEvent(new User("mmikowski", 1))))
                .isEqualTo("User name mmikowski has been created");
        assertThat(message(new UserDeletedEvent("mmikowski")))
                .isEqualTo("User name mmikowski has been deleted");
    }
}
