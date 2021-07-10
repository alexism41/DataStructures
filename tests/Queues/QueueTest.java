package Queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue<Integer> queue;

    @BeforeEach
    void construct() {
        queue = new Queue<>();
    }

    @Test
    @DisplayName("Should get the size of the queue")
    void size() {
        assertEquals(0, queue.size());
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        assertEquals(3, queue.size());
        queue.poll();
        assertEquals(2, queue.size());
    }

    @Test
    @DisplayName("Should check if queue is empty")
    void isEmpty() {
        assertTrue(queue.isEmpty());
        queue.offer(1);
        queue.peek();
        assertFalse(queue.isEmpty());
        queue.poll();
        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("Should check if queue is full")
    void isFull() {
        Queue<Integer> q2 = new Queue<>(3);
        assertFalse(q2.isFull());
        q2.offer(1);
        q2.offer(2);
        assertFalse(q2.isFull());
        q2.offer(3);
        q2.offer(4);
        q2.offer(5);
        assertTrue(q2.isFull());
        q2.peek();
        assertTrue(q2.isFull());
    }

    @Test
    @DisplayName("Should check if methods remove data")
    void removing() {
        assertTrue(queue.isEmpty());
        assertNull(queue.poll());
        assertThrows(NoSuchElementException.class, () -> queue.remove());
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        assertEquals(1, queue.poll());
        assertEquals(2, queue.remove());
        queue.offer(4);
        queue.offer(5);
        assertEquals(3,queue.poll());
        assertEquals(4, queue.remove());
        assertEquals(5, queue.remove());
        assertThrows(NoSuchElementException.class, () -> queue.remove());
        assertNull(queue.poll());
    }

    @Test
    @DisplayName("Should check if methods insert data")
    void inserting() {
        Queue<Integer> q2 = new Queue<>(5);
        assertTrue(q2.offer(1));
        assertTrue(q2.offer(2));
        assertTrue(q2.add(3));
        assertTrue(q2.add(4));
        assertThrows(NullPointerException.class, () -> q2.add(null));
        assertThrows(NullPointerException.class, () -> q2.offer(null));
        assertEquals(4, q2.size());
        assertTrue(q2.add(5));
        assertTrue(q2.isFull());
        assertFalse(q2.offer(6));
        assertThrows(IllegalStateException.class, () -> q2.add(6));
        q2.poll();
        assertFalse(q2.isFull());
        assertTrue(q2.offer(6));
    }

    @Test
    @DisplayName("Should check if methods access data")
    void access() {
        assertTrue(queue.isEmpty());
        assertNull(queue.peek());
        assertThrows(NoSuchElementException.class, () -> queue.element());
        queue.offer(1);
        queue.offer(2);
        assertEquals(1, queue.peek());
        assertEquals(1, queue.element());
        queue.poll();
        assertEquals(2, queue.peek());
        assertEquals(2, queue.element());
        queue.poll();
        assertNull(queue.peek());
        assertThrows(NoSuchElementException.class, () -> queue.element());
    }
}