public class MyQueue<E> {
    private MyLinkedList<E> list = new MyLinkedList<>();

    public void enqueue(E element) {
        list.add(element);
    }

    public E dequeue() {
        if (isEmpty()) throw new IllegalStateException();
        return list.remove(0);
    }

    public E peek() {
        if (isEmpty()) throw new IllegalStateException();
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
