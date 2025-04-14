import java.util.Iterator; //import iterator

public class MyArrayList<E> implements MyList<E> {
    private Object[] data; // array for elements
    private int size;
    private static final int INITIAL_CAPACITY = 10; // itinial capacity is set to 10

    public MyArrayList() {
        data = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(E element) {
        ensureCapacity(size + 1); // increasing capacity if needed
        data[size++] = element; // increasing element and size
    }

    public void add(int index, E element) {
        checkIndexForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element; // inserting new element
        size++;
    }

    public E get(int index) {
        checkIndex(index); // checking index
        return (E) data[index]; // returning element in specified type
    }
    // deletes first occurency of element, returns true if element was found
    public E remove(int index) {
        checkIndex(index);
        E removed = (E) data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
        return removed;
    }

    public boolean remove(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        data = new Object[INITIAL_CAPACITY];
        size = 0;
    }
// checking if there is element in array
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = data.length * 2;
            Object[] newData = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i]; // copying old elements
            }
            data = newData;
        }
    }
// checking index for adding
    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int cursor = 0; // current position

            public boolean hasNext() {
                return cursor < size; // if there is next element
            }

            public E next() {
                return (E) data[cursor++]; // increasing cursor and return element
            }
        };
    }
}
