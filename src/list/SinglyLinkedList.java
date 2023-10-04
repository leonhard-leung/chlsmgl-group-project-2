package list;

import java.util.NoSuchElementException;

//----------------------------------------------------------------------------------------------------------------------

/**
 * MySinglyLinkedList<T> is a generic class that implements the MyList<T> interface.
 * @param <T>
 */
public class SinglyLinkedList<T> implements MyList<T> {
    private Node<T> next; // Reference to the first node in the list.
    private int size = 0; // Track the current number of elements in the list.

//----------------------------------------------------------------------------------------------------------------------

    /**
     * Get the current size of the list.
     * @return
     */
    @Override
    public int getSize() {
        return size;
    } // end of getSize method

//----------------------------------------------------------------------------------------------------------------------

    /**
     * Insert an element into the linked list.
     * @param data
     */
    @Override
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (next == null) next = newNode;
        else {
            Node<T> currentPointer = next;
            while (currentPointer.getNext() != null) currentPointer = currentPointer.getNext();
            currentPointer.setNext(newNode);
        }
        size++;
    } // end of insert method

//----------------------------------------------------------------------------------------------------------------------

    /**
     * Get an element from the list based on the provided data.
     * Throw NoSuchElementException if the data is not found.
     * @param data
     * @return
     * @throws NoSuchElementException
     */
    @Override
    public T getElement(T data) throws NoSuchElementException {
        Node<T> currentPointer = next;
        for (int i = 0; i < getSize(); i++) {
            if (currentPointer.getData().equals(data)) return currentPointer.getData();
            currentPointer = currentPointer.getNext();
        }
        throw new NoSuchElementException();
    } // end of getElement method

//----------------------------------------------------------------------------------------------------------------------

    /**
     * Get an element from the list based on the provided index.
     * Throw NoSuchElementException if the index is out of bounds.
     * @param index
     * @return
     * @throws NoSuchElementException
     */
    public T getElement(int index) throws NoSuchElementException {
        Node<T> currentPointer = next;
        for (int i = 0; i < getSize(); i++) {
            if (i == index) return currentPointer.getData();
            currentPointer = currentPointer.getNext();
        }
        throw new NoSuchElementException();
    } // end of getElement method

//----------------------------------------------------------------------------------------------------------------------

    /**
     * Delete an element from the list based on the provided data.
     * Returns true if the deletion is successful, false otherwise.
     * @param data
     * @return
     */
    @Override
    public boolean delete(T data) {
        Node<T> currentPointer = next;
        Node<T> previousPointer = null;
        while (currentPointer != null) {
            if (currentPointer.getData().equals(data)) {
                if (currentPointer == next)
                    next = currentPointer.getNext();
                else
                    previousPointer.setNext(currentPointer.getNext());
                size--;
                return true;
            }
            previousPointer = currentPointer;
            currentPointer = currentPointer.getNext();
        }
        return false;
    } // end of delete method

//----------------------------------------------------------------------------------------------------------------------

    /**
     * Search for an element in the list based on the provided data.
     * Return the index of the data if found, otherwise return -1.
     * @param data
     * @return
     */
    @Override
    public int search(T data) {
        Node<T> currentPointer = next;
        for (int i = 0; i < getSize(); i++) {
            if (currentPointer.getData().equals(data))
                return i;
            currentPointer = currentPointer.getNext();
        }
        return -1;
    } // end of search method

//----------------------------------------------------------------------------------------------------------------------

    public void setElement(int index, T data) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> currentPointer = next;
        for (int i = 0; i < index; i++) {
            currentPointer = currentPointer.getNext();
        }
        currentPointer.setData(data);
    }

//----------------------------------------------------------------------------------------------------------------------
} // end of MySinglyLinkedList<T> class
//----------------------------------------------------------------------------------------------------------------------
