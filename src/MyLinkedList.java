import java.util.Iterator;

public class MyLinkedList<E> implements MyList<E> { // realization of MyList interface
    private class MyNode {
        E data; // data in node
        MyNode next, prev; // pointers to next and prev. node
        MyNode(E data) {
            this.data = data;
        }
    }

    private MyNode head, tail; // pointer for beginning and end of the list
    private int size; // amount of elements in list

    public void add(E element) {
        MyNode newNode = new MyNode(element);
        if (isEmpty()) {
            head = tail = newNode; // if list is empty new node is both head and tail
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode; // new node becomes tail
        }
        size++;
    }

    public void add(int index, E element) {
        checkIndexForAdd(index); // checking for index
        MyNode newNode = new MyNode(element);
        if (index == size) { // if inserting to the end calls add method
            add(element);
            return;
        }
        MyNode current = getNode(index); // receiving node by index
        MyNode prev = current.prev;
        newNode.next = current;
        newNode.prev = prev;
        current.prev = newNode;
        if (prev != null) {
            prev.next = newNode;
        } else {
            head = newNode; // if inserting to the beginning
        }
        size++;
    }

    public E get(int index) {
        checkIndex(index); // checking index
        return getNode(index).data;
    }
// removing elements by index and returning deleted element
    public E remove(int index) {
        checkIndex(index);
        MyNode current = getNode(index);
        MyNode prev = current.prev;
        MyNode next = current.next;
        if (prev != null) {
            prev.next = next;
        } else {
            head = next; // if deletes head
        }
        if (next != null) {
            next.prev = prev;
        } else {
            tail = prev; // if deletes tail
        }
        size--;
        return current.data;
    }
// removing first occurency of element
    public boolean remove(E element) {
        MyNode current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                MyNode prev = current.prev;
                MyNode next = current.next;
                if (prev != null) {
                    prev.next = next;
                } else {
                    head = next;
                }
                if (next != null) {
                    next.prev = prev;
                } else {
                    tail = prev;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }
// returning the amount of elements
    public int size() {
        return size;
    }
// checking if list empty or not
    public boolean isEmpty() {
        return size == 0;
    }
// removing all elements
    public void clear() {
        head = tail = null;
        size = 0;
    }
// checking in element in the list
    public boolean contains(E element) {
        MyNode current = head;
        while (current != null) {
            if (current.data.equals(element)) return true;
            current = current.next;
        }
        return false;
    }
// returning node by index
    private MyNode getNode(int index) {
        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }
// checking index for methods add and remove
    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }
// checking index for method add
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private MyNode current = head;
            public boolean hasNext() {
                return current != null;
            }
            public E next() {
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
