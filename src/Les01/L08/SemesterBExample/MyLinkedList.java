package Les01.L08.SemesterBExample;

import Les01.Node;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<E> implements List<E> {

    private Node<E> head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {

        if (head == null)
            return false;
        else {
            Node<E> temp = head;
            while (temp.getValue() != o) {
                temp = temp.getNext();
            }
            return (temp != null) ? true : false;
        }
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

    @Override
    public boolean add(E e) {
        if (head == null)
            head = new Node<>(e);
        else {
            Node<E> temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(e));
        }
        size++;
        return true;
    }

    public boolean addToFirst(E e) {
        Node<E> temp = new Node<>(e);
        temp.setNext(head);
        head=temp;
        size++;
        return true;
    }

    public void print() {
        if (head == null)
            System.out.println("head->null");
        else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp + " ->" + ((temp.getNext() == null) ? "null" : ""));
                temp = temp.getNext();
            }
            System.out.println();
        }

    }
    //IMpl
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
    //IMpl
    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size)
            return null;

        Node<E> temp = head;
        int count = 0;
        while (temp != null && count != index) {
            count++;
            temp = temp.getNext();
        }

        return temp.getValue();
    }
    //IMpl
    @Override
    public E set(int index, E element) {
        return null;
    }
    //IMpl
    @Override
    public void add(int index, E element) {

    }
    //IMpl
    @Override
    public E remove(int index) {
        return null;
    }
    //IMpl
    @Override
    public int indexOf(Object o) {
        return 0;
    }

    //IMpl
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


