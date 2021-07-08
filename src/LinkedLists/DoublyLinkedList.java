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
    /** Helper function to access nodes in list **/
    private Node<T> getNode(int index) {
        if(index < size) {
            // start traversal from the front if index is in the first half or middle
            int count = 0;
            if(index <= size/2){
                Node<T> cur = head;
                for(int i = 0; i <= index ; ++i)
                {
                    if(i == index)
                        return cur;
                    cur = cur.next;
                    count++;
                    System.out.println(count);
                }
            }
            else
            {
                // start traversal from the end if index is in the second half
                Node<T> cur = tail;
                for(int i = size-1; index <= i; --i)
                {
                    if(i == index)
                        return cur;
                    cur = cur.prev;
                    count++;
                    System.out.println(count);
                }
            }
        }
        throw new IndexOutOfBoundsException();
    }

    /** Constructs an empty linked list **/
    public DoublyLinkedList() {
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
     * @throws IndexOutOfBoundsException if {@code index < 0 || index > size()}
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
            head = new Node<>(data,null, head);
            if(tail == null)
                tail = head;
        }
        else if(index == size())
        {
            tail.next = new Node<>(data, tail, null);
            tail = tail.next;
        }
        else{
            Node<T> cur = getNode(index);
            Node<T> prev = cur.prev;
            prev.next = new Node<>(data, prev, cur);
            cur.prev = prev.next;
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

}
