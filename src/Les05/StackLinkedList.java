package Les05;


import java.util.LinkedList;

public class StackLinkedList<T> {

    private LinkedList<T> ll;

    public StackLinkedList() {
        this.ll = new LinkedList<>();
    }

    public T push(T item) {
       ll.addFirst(item);
       return ll.getFirst();
    }

    public T pop() {
        return ll.removeFirst();
    }

    public int size() {
        return ll.size();
    }

    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public String toString() {
        return ll.toString();
    }


}
