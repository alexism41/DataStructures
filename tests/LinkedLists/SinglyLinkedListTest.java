package LinkedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {
    SinglyLinkedList<Integer> list;

    @BeforeEach
    void construct() {
        list = new SinglyLinkedList<>();
    }

    @Test
    @DisplayName("Should return size of the list")
    void size() {
        construct();
        assertEquals(0, list.size());
        list.insert(1);
        assertEquals(1, list.size());
        list.insert(3);
        list.insert(9);
        list.insert(23);
        list.insert(7);
        assertEquals(5, list.size());

    }

    @Test
    void isEmpty() {
    }

    @Test
    void getHead() {
    }

    @Test
    @DisplayName("Should return data from the last node in the list")
    void getTail() {
        construct();
        assertThrows(IndexOutOfBoundsException.class, () -> list.getTail());
        list.insert(30);
        assertEquals(30, list.getTail());
        list.insert(1);
        list.insert(5);
        list.insert(8);
        assertEquals(8, list.getTail());
    }

    @Test
    void getAt() {
    }

    @Test
    void insert() {
    }

    @Test
    @DisplayName("Should remove data from list")
    void remove() {
        construct();
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove());
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        assertEquals( 6, list.remove());
        assertEquals( 2, list.remove(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(8));
        assertEquals( 5, list.remove());
        assertEquals( 4, list.remove());
        assertEquals( 3, list.remove());
        assertEquals(1, list.remove(0));
    }
}