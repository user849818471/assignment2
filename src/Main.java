public class Main {
    public static void main(String[] args) {
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add(1, "X");
        System.out.println(arrayList.get(1)); // X
        arrayList.remove("B");
        System.out.println(arrayList.contains("C")); // true

        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(0, 0);
        System.out.println(linkedList.get(0)); // 0
        linkedList.remove((Integer) 2);
        System.out.println(linkedList.size()); // 2

        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        System.out.println(stack.pop()); // 20

        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("First");
        queue.enqueue("Second");
        System.out.println(queue.dequeue()); // First

        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.add(4);
        heap.add(1);
        heap.add(3);
        System.out.println(heap.poll()); // 1
    }
}
