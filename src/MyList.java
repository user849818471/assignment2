/*
* Interface for a collection representing a list.
* @param <E> The type of elements that can be added to the list.
* @param index Index of the element
* @param element Element to be added
 */

public interface MyList<E> extends Iterable<E> {
    void add(E element); // add element to the end of the list
    void add(int index, E element); //adds element to picked index
    E get(int index); // returns element by its index
    E remove(int index); // deletes element by its index
    boolean remove(E element); // removes the first occurrence of an element from a list.
    int size(); // amount on elements in the list
    boolean isEmpty(); // true if list is empty, false if its not
    void clear(); //deletes all elements in the list
    boolean contains(E element); // checking if element is in the list
}
