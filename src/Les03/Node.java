package Les03;

public class Node<T> {

    private T value;
    private Node<T> next;
    private Node<T> prev;

    public Node(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public Node(T value, Node<T> next, Node<T> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> next) {
        this.prev = prev;
    }
    public boolean hasNext() {
        return next != null;
    }
    public boolean hasPrev() {
        return next != null;
    }
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
