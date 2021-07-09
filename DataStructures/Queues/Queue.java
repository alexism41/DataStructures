package Queues;

import Stacks.Stack;

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
}
