package Les01.L07;

import java.util.Stack;

public class MyQueueWithStack<E> {

    private Stack<E> st1;
    private Stack<E> st2;
    private int size;


    public MyQueueWithStack() {
        this.st1 = new Stack<>();
        this.st2 = new Stack<>();
        this.size = 0;
    }

    //O(n)
    public boolean add(E o) {

        while (!st2.isEmpty()) {
            st1.add(st2.pop());
        }
       boolean bool = st2.add(o);
        while (!st1.isEmpty()) {
            st2.add(st1.pop());
        }
        return bool;
    }


    //O(1)
    public boolean isEmpty() {
        return st2.isEmpty();
    }

    //O(1)
    public E poll() {
        return st2.pop();
    }

    //O(1)
    public E peek() {
        return st2.peek();
    }
}
