package Les03;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DoublyLinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;


    public DoublyLinkedList() {
        head=null;
        tail=null;
        size=0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    //init call constructor
    // head = null
    //  tail = null

    // add(1)
    // newNode = null <- 1 -> null
    // if(haed == null) -> true
    // head = null <- 1 -> null
    // tail = (prev) null <- 1 -> null (next)
    // return true

    // add(2)
    // newNode = null <- 2 -> null
    // if(haed == null) -> false
    // tail = (null <- 1 -> ( null <- 2 -> null))
    // tail = (null <- 1 -> ( 1 <- 2 -> null))
    // tail = ( 1 <- 2 -> null)
    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<>(e);
        if(head==null){
            head = newNode;
            tail= head;
            return true;
        }

        tail.setNext(newNode);
        newNode.setPrev(tail);
        tail=newNode;


        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(head==null)
            return false;

        if (head.getValue().equals(o)) {
            head = head.getNext();

            head.setPrev(null);

            return true;
        }

        Node<E> current = head.getNext();
        Node<E> prev = head;
        while (current != null) {
            if (current.getValue().equals(o)) {
                prev.setNext(current.getNext());
                return true;
            }
            prev=current;
            current = current.getNext();
        }
        return false;

    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
