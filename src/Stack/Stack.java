package Stack;

import LinkedLists.DoublyLinkedList;

/**
 * Implementation of a Stack (LIFO)
 *
 * @author Alexis Muro
 * @param <T> type of element in the linked list.
 */
public class Stack<T> {
    /** Implementation of the nodes in the stack **/
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

    /** top of the stack **/
    private Node<T> top;
    /** Max capacity of the stack **/
    private int capacity;
    /** Size of the list **/
    private int size;


}
