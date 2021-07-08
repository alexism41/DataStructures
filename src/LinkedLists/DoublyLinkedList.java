package LinkedLists;

/**
 * Implementation of a Doubly Linked List
 *
 * @author Alexis Muro
 * @param <T> type of element in the linked list.
 */
public class DoublyLinkedList<T> {
    /** Implementation of the nodes in a linked list **/
    private static class Node<T> {
        /** Data this node stores **/
        T data;

        /** Pointer to the previous node in the list **/
        Node<T> prev;
        /** Pointer to the next node in the list **/
        Node<T> next;

        /**
         * Constructs a node storing data
         *
         * @param data the data to be stored in the node
         */
        Node(T data) {
            this.data = data;
            prev = null;
            next = null;
        }

        /**
         * Constructs a node storing data and pointing to both the previous and next node
         * @param data the data to be stored in the node
         * @param prev the previous node in the list
         * @param next the next node in the list
         */
        Node(T data, Node<T> prev, Node<T> next)
        {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

    }

    /** Front of the list **/
    private Node<T> head;
    /** Back of the list **/
    private Node<T> tail;
    /** Size of the list **/
    private int size;
}
