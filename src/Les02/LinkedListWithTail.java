package Les02;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedListWithTail<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedListWithTail() {

        head=null;
        tail=null;
        size=0;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
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


    // head = null
    // tail = null
    // add(1)
    //head = 1
    //tail = 1
    // add(2)
    //head = 1
    //tail = 2
    // add(3)
    //head = 1
    //tail = 3
    //O(n)
    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<>(e); // O(1)
        if(head==null) // O(1)
        {
            head = newNode;
            tail=newNode;
//            tail=head;
        }
        else
        {
            tail.setNext(newNode);
            tail=newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
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

    public void print(){
        Node<E> temp = head;
        while(temp!=null)
        {
            System.out.print(temp.getValue()+" -> ");
            temp=temp.getNext();
        }
        System.out.println("null");
    }
}


