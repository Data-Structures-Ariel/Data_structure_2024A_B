package Les01;


public class Node<T> {

    protected T value;
    protected Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
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

    public boolean hasNext() {
        return next != null;
    }

    @Override
    public String toString() {

        return  Integer.toHexString(this.hashCode());
    }
}

class MainNode{


    public static void main(String[] args) {

        Node<Integer> chain = new Node<>(1);

        chain.next = new Node<>(2);
        chain.next.next=new Node<>(3);
        chain.next.next.next=new Node<>(4);

        print(chain);
    }

    private static void print(Node<Integer> chain) {

        while(chain!=null) {
            System.out.println(chain.value);
            chain=chain.next;
        }
    }
}