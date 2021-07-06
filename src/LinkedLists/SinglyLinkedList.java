package LinkedLists;

/**
 * Implementation of a Singly Linked List
 *
 * @author Alexis Muro
 * @param <T> type of element in the linked list.
 */
public class SinglyLinkedList<T> {
    /** Implementation of the nodes in a linked list **/
    private static class Node<T> {
        /** Data this node stores **/
        T data;
        /** Pointer to the next node in the list **/
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

    }

    /** Front of the list **/
    private Node<T> head;
    /** Back of the list **/
    private Node<T> tail;
    /** Size of the list **/
    private int size;


}
