package Les05;


public class QueueNode<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public QueueNode() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //O(1)
    public boolean add(E o) {

        Node<E> newNode = new Node<>(o);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
        return true;
    }

    //O(1)
    public E poll() throws Exception {
        if (isEmpty())
            throw new Exception();
        E value = head.getValue();
        head = head.getNext();
        size--;

        tail=(isEmpty())?null:tail;

        return value;
    }

    //O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    //O(1)
    public E peek() throws Exception {
        if (isEmpty())
            throw new Exception();
        E value = head.getValue();
        return value;
    }


    static class Node<E> {
        private E value;
        private Node<E> next;


        public Node(E value) {
            this.value = value;
            this.next = null;
        }


        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }


        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public boolean hasNext() {
            return next != null;
        }
    }
}
