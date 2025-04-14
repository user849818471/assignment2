public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap = new MyArrayList<>();

    public void add(T value) {
        heap.add(value);
        heapifyUp();
    }

    public T peek() {
        if (heap.isEmpty()) throw new IllegalStateException();
        return heap.get(0);
    }

    public T poll() {
        if (heap.isEmpty()) throw new IllegalStateException();
        T result = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.add(0, last);
            heapifyDown();
        }
        return result;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    private void heapifyUp() {
        int index = heap.size() - 1;
        while (index > 0) {
            int parent = (index - 1) / 2;
            T childValue = heap.get(index);
            T parentValue = heap.get(parent);
            if (childValue.compareTo(parentValue) >= 0) break;
            swap(index, parent);
            index = parent;
        }
    }

    private void heapifyDown() {
        int index = 0;
        int size = heap.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;
            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }
            if (smallest == index) break;
            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.add(i, heap.get(j));
        heap.remove(i + 1);
        heap.add(j, temp);
        heap.remove(j + 1);
    }
}
