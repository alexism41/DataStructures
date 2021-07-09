package LinkedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    DoublyLinkedList<Integer> list;

    @BeforeEach
    void construct() {
        list = new DoublyLinkedList<>();
    }

    @Test
    @DisplayName("Should return size of the list")
    void size() {
        assertEquals(0, list.size());
        list.insert(1);
        assertEquals(1, list.size());
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        assertEquals(5, list.size());
    }

    @Test
    @DisplayName("Should return true when empty")
    void isEmpty() {
    }

    @Test
    @DisplayName("Should return data from the front of the list")
    void getHead() {
    }

    @Test
    @DisplayName("Should return data from the last node in the list")
    void getTail() {
    }

    @Test
    @DisplayName("Should return data at given index")
    void getAt() {
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
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        assertEquals( 6, list.remove());
        assertEquals( 4, list.remove(3));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(8));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(list.size()));
        assertEquals( 5, list.remove());
        assertEquals( 3, list.remove());
        assertEquals(1, list.remove(0));
        assertEquals(2, list.remove());
    }
}