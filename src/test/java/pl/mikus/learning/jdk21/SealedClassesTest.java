package pl.mikus.learning.jdk21;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SealedClassesTest {

    sealed interface Animal permits Cat, Dog, Bird {
    }

    static final class Cat implements Animal {
        String meow() {
            return "meow";
        }
    }

    static final class Dog implements Animal {
        String bark() {
            return "woof";
        }
    }

    static final class Bird implements Animal {
        String chirp() {
            return "chirp";
        }
    }

    String communicateClassic(Animal animal) {
        String message = null;
        if (animal instanceof Cat cat) {
            message = cat.meow();
        }
        if (animal instanceof Dog dog) {
            message = dog.bark();
        }
        return message;
    }

    @Test
    void communicateClassicTest() throws Exception {
        assertThat(communicateClassic(new Cat())).isEqualTo("meow");
        assertThat(communicateClassic(new Dog())).isEqualTo("woof");
        // assertThat(communicate(new Animal())).isNull();
    }


    String communicate(Animal animal) {
        return switch (animal) {
            case Cat c -> c.meow();
            case Dog d -> d.bark();
            case Bird b -> b.chirp();
        };
    }

    @Test
    void communicateTest() throws Exception {
        assertThat(communicate(new Cat())).isEqualTo("meow");
        assertThat(communicate(new Dog())).isEqualTo("woof");
        assertThat(communicate(new Bird())).isEqualTo("chirp");
        // assertThat(communicate(new Animal())).isNull();
    }

}
