package Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack<Integer> stack;

    @BeforeEach
    void construct() {
        stack = new Stack<>();
    }

    @Test
    @DisplayName("Should get the size of the stack")
    void size() {
        assertEquals(0, stack.size());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
        stack.pop();
        assertEquals(2, stack.size());
    }

    @Test
    @DisplayName("Should check if stack is empty")
    void isEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("Should check if stack is at capacity")
    void isFull() {
        Stack<Integer> stack1 = new Stack<>(3);
        assertFalse(stack1.isFull());
        stack1.push(1);
        assertFalse(stack1.isFull());
        stack1.push(2);
        stack1.push(3);
        assertTrue(stack1.isFull());
    }

    @Test
    @DisplayName("Should get the data from the top of the stack")
    void top() {
        assertNull(stack.top());
        stack.push(1);
        assertEquals(1, stack.top());
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(4, stack.top());
        stack.pop();
        assertEquals(3, stack.top());
    }

    @Test
    @DisplayName("Should add data to the stack")
    void push() {
        Stack<Integer> stack1 = new Stack<>(3);
        assertEquals(0, stack1.size());
        assertTrue(stack1.push(1));
        assertEquals(1, stack1.size());
        assertTrue(stack1.push(2));
        assertThrows(NullPointerException.class, () -> stack1.push(null));
        assertEquals(2, stack1.size());
        stack1.push(3);
        assertEquals(3, stack1.size());
        assertFalse(stack1.push(4));
        assertEquals(3, stack1.size());
        stack1.pop();
        assertTrue(stack1.push(5));

    }

    @Test
    @DisplayName("Should remove data from the stack")
    void pop() {
        assertNull(stack.pop());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        stack.push(4);
        assertEquals(4, stack.pop());
    }
}