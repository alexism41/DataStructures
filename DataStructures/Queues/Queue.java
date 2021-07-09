package Queues;

/**
 * Implementation of a Queue (FIFO)
 *
 * @author Alexis Muro
 * @param <T> type of element in the queue.
 */

public class Queue<T> {
    /** Implementation of the nodes in the queue **/
    private static class Node<T> {
        /** Data this node stores **/
        T data;

        /** Pointer to the next node in the stack **/
        Node<T> next;

        /**
         * Constructs a node storing data
         *
         * @param data the data to be stored in the node
         */
        Node(T data) {
            this.data = data;
            next = null;
        }

        /**
         * Constructs a node storing data and pointing to the next node
         * @param data the data to be stored in the node
         * @param next the next node in the list
         */
        Node(T data, Node<T> next)
        {
            this.data = data;
            this.next = next;
        }
    }

    /** front of the queue **/
    private Node<T> front;
    /** back of the queue **/
    private Node<T> back;
    /** Max capacity of the queue **/
    private int capacity;
    /** Size of the queue **/
    private int size;

    /** Constructs an empty Queue **/
    public Queue() {
        this.front = null;
        this.back = null;
        this.capacity = Integer.MAX_VALUE;
        this.size = 0;
    }

    /**
     * Constructs an empty queue with a specific capacity
     *
     * @param capacity the max capacity for the stack
     * @throws IllegalArgumentException if capacity is not at least 1
     */
    public Queue(int capacity){
        if(capacity < 1) throw new IllegalArgumentException();
        this.front = null;
        this.back = null;
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * Gets the size of the queue
     *
     * @return the number of nodes in the queue
     */
    public int size() {
        return size;
    }

    /**
     * Checks whether the queue is empty or not
     *
     * @return {@code true} if the queue is empty
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Checks whether the queue is full
     *
     * @return {@code true} if {@code size == capacity}
     */
    public boolean isFull() {
        return size == capacity;
    }


}
