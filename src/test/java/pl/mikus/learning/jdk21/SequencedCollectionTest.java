package pl.mikus.learning.jdk21;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;

class SequencedCollectionTest {

    @Test
    void sequencedCollectionArrayListTest() throws Exception {
        var list = new ArrayList<String>();
        list.add("hello");
        list.add("ciao");
        list.add("hi hao");
        list.add("hola");
        list.addFirst("ola");
        list.addLast("dobry");

        assertThat(list.getFirst()).isEqualTo("ola");
        assertThat(list.getLast()).isEqualTo("dobry");
        assertThat(list.get(0)).isEqualTo("ola");
        assertThat(list.get(list.size() - 1)).isEqualTo("dobry");
    }

    @Test
    void sequencedCollectionLinkedHashSetTest() throws Exception {
        var set = new LinkedHashSet<String>();
        set.add("hello");
        set.add("ciao");
        set.add("hi hao");
        set.add("hola");
        set.addFirst("ola");
        set.addLast("dobry");

        assertThat(set.getFirst()).isEqualTo("ola");
        assertThat(set.getLast()).isEqualTo("dobry");
        assertThat(set.stream().toArray()[0]).isEqualTo("ola");
        assertThat(set.stream().toArray()[set.stream().toArray().length - 1]).isEqualTo("dobry");
    }

}
