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

        /**
         * Constructs a node storing data and pointing to another node
         * @param data the data to be stored in the node
         * @param next the next node in the list
         */
        Node(T data, Node<T> next)
        {
            this.data = data;
            this.next = next;
        }

    }

    /** Front of the list **/
    private Node<T> head;
    /** Back of the list **/
    private Node<T> tail;
    /** Size of the list **/
    private int size;
    /** Helper function to access nodes in list **/
    private Node<T> getNode(int index) {
        if(index < size) {
            Node<T> cur = head;
            for(int i = 0; i <= index ; ++i)
            {
                if(i == index)
                    return cur;
                cur = cur.next;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    /** Constructs an empty linked list **/
    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Gets the size of the linked list
     *
     * @return the number of nodes in the list
     */
    public int size() {
        return size;
    }

    /**
     * Checks whether the list is empty or not
     *
     * @return {@code true} if the list is empty
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Gets data from the node at the front of the list
     *
     * @return the data from the first node in the list
     * @throws NullPointerException if {@code size() < 1}
     */
    public T getHead() {
        if(size() < 1) throw new NullPointerException();
        return head.data;
    }

    /**
     * Gets data from the node at the end of the list
     *
     * @return the data from the last node in the list
     * @throws NullPointerException if {@code size() < 1}
     */
    public T getTail() {
        if(size() < 1) throw new NullPointerException();
        return tail.data;
    }

    /**
     * Gets data from the node at a specific position in the list
     *
     * @param index the index of the node in the list
     * @return the data from the node at specified index
     * @throws IndexOutOfBoundsException if {@code index < 0 || index >= size()}
     */
    public T getAt(int index) {
        return getNode(index).data;
    }

    /**
     * Inserts data into a specific position in the list
     *
     * @param index the index at which data is to be inserted at
     * @param data the data to be inserted into the list
     * @throws NullPointerException if data is null
     * @throws IndexOutOfBoundsException if {@code index < 0 || index > size()}
     */
    public void insert(int index, T data) {
        if(data == null) throw new NullPointerException();
        if(index == 0) {
            head = new Node<>(data, head);
            if(tail == null)
                tail = head;
        }
        else if(index == size())
        {
            tail.next = new Node<>(data);
            tail = tail.next;
        }
        else{
            Node<T> prev = getNode(index - 1);
            prev.next = new Node<>(data, prev.next);
        }
        size++;
    }

    /**
     * Inserts data to the end of the list
     *
     * @param data the data to be inserted into the list
     * @throws NullPointerException if data is null
     * @throws IndexOutOfBoundsException if {@code index < 0 || index > size()}
     */
    public void insert(T data) {
        insert(size(), data);
    }

    /**
     * Removes data from a specific position in the list
     *
     * @param index the index at which data is to be removed from
     * @return the data that was removed from the list
     * @throws IndexOutOfBoundsException if {@code index < 0 || index >= size()}
     */
    public T remove(int index) {
        if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        T removed;
        if(index == 0) {
            removed = head.data;
            if(head == tail)
            {
                head = tail = null;
            }
            else
                head = head.next;
        }
        else{
            Node<T> prev = getNode(index - 1);
            removed = prev.next.data;
            if(prev.next == tail)
            {
                tail = prev;
                prev.next = null;
            }
            else
                prev.next = prev.next.next;
        }
        size--;
        return removed;
    }

    /**
     * Removes data from the end of the list
     *
     * @return the data that was removed from the list
     * @throws IndexOutOfBoundsException if {@code index < 0 || index >= size()}
     */
    public T remove() {
        return remove(size()-1);
    }

}
