package list;


//----------------------------------------------------------------------------------------------------------------------

/**
 * Node<T> represents a generic node used in various data structures like linked lists.
 * @param <T>
 */
public class Node<T> {
    private T data; // Data stored in the node.
    private Node<T> next; // Reference to the next node.
    private Node<T> previous; // Reference to the previous node.

//----------------------------------------------------------------------------------------------------------------------

    /**
     * Constructor to create a new node with the given data.
     * @param data
     */
    public Node(T data) {
        this.data = data;
        next = null;
        previous = null;
    }

//----------------------------------------------------------------------------------------------------------------------

    /**
     * Getter method to retrieve the data stored in the node.
     * @return
     */
    public T getData() {
        return data;
    }

//----------------------------------------------------------------------------------------------------------------------

    /**
     * Setter method for the data being renamed
     * @param data
     */

    public void setData(T data) {
        this.data = data;
    }

//----------------------------------------------------------------------------------------------------------------------

    /**
     * Setter method to set the reference to the next node.
     * @param node
     */
    public void setNext(Node<T> node) {
        next = node;
    }

//----------------------------------------------------------------------------------------------------------------------

    /**
     * Setter method to set the reference to the previous node.
     * @param node
     */
    public void setPrevious(Node<T> node) {
        previous = node;
    }

//----------------------------------------------------------------------------------------------------------------------

    /**
     * Getter method to retrieve the reference to the next node.
     * @return
     */
    public Node<T> getNext() {
        return next;
    }

//----------------------------------------------------------------------------------------------------------------------

    /**
     * Getter method to retrieve the reference to the previous node.
     * @return
     */
    public Node<T> getPrevious() {
        return previous;
    }

//----------------------------------------------------------------------------------------------------------------------
} // end of Node<T> class
//----------------------------------------------------------------------------------------------------------------------

