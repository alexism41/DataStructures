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
    @DisplayName("Should return true when empty")
    void isEmpty() {
        assertTrue(list.isEmpty());
        list.insert(1);
        assertFalse(list.isEmpty());
        list.insert(2);
        assertFalse(list.isEmpty());
        list.remove();
        assertFalse(list.isEmpty());
        list.remove();
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("Should return data from the front of the list")
    void getHead() {
        assertThrows(NullPointerException.class, () -> list.getHead());
        list.insert(0,1);
        assertEquals(1, list.getHead());
        list.insert(2);
        list.insert(3);
        assertEquals(1, list.getHead());
        list.remove(0);
        assertEquals(2, list.getHead());
        list.remove(0);
        list.remove(0);
        assertThrows(NullPointerException.class, () -> list.getHead());
    }

    @Test
    @DisplayName("Should return data from the last node in the list")
    void getTail() {
        assertThrows(NullPointerException.class, () -> list.getTail());
        list.insert(30);
        assertEquals(30, list.getTail());
        list.insert(1);
        list.insert(5);
        list.insert(8);
        assertEquals(8, list.getTail());
    }

    @Test
    @DisplayName("Should return data at given index")
    void getAt() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.getAt(0));
        list.insert(0, 1);
        list.insert(1, 2);
        list.insert(2, 3);
        list.insert(3, 4);
        assertThrows(IndexOutOfBoundsException.class, () -> list.getAt(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.getAt(4));
        assertEquals(2, list.getAt(1));
        assertEquals(3, list.remove(2));
        assertEquals(4, list.getAt(2));
    }

    @Test
    @DisplayName("Should insert data to list")
    void insert() {
        list.insert(0,1);
        list.insert(2);
        list.insert(3);
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(-1, 4));
        assertEquals(3, list.size());
        list.insert(4);
        list.insert(5);
        assertThrows(NullPointerException.class, () -> list.insert(3, null));
        assertEquals(5, list.size());
        list.insert(5,6);
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(7, 6));
        list.insert(5,7);
        assertEquals(7, list.size());
        assertEquals(6, list.remove());
        assertEquals(6, list.size());
        assertEquals(7, list.remove());
        assertEquals(5,list.size());
    }

    @Test
    @DisplayName("Should remove data from list")
    void remove() {
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