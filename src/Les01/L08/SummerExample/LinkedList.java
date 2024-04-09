package Les01.L08.SummerExample;

import Les01.Node;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
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
        if (isEmpty())
            return false;
        Node<T> temp = head;
        while (temp != null) {
            if (temp.getValue().equals(o))
                return true;
            temp = temp.getNext();

        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        Node<T> newNode = new Node<>(t);
        if (head == null)
            head = newNode;
        else {
            Node<T> temp = head;
            while (temp.hasNext())
                temp = temp.getNext();

            temp.setNext(newNode);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (this.isEmpty())
            return false;
        if (head.getValue().equals(o))
            head = head.getNext();

        // סריקת הרשימה עד האיבר השני מהסוף
        // בדיקת האיבר האחרון

        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
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
        this.head = null;
    }

    @Override
    public T get(int index) {
        if (size < index || index < 0)
            throw new IndexOutOfBoundsException();

        Node<T> temp = head;
        while (index != 0) {
            temp = temp.getNext();
            index--;
        }
        return temp.getValue();
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        return null;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        Node<T> newNode = new Node<>(element);

        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        }
        index--;
        Node<T> temp = head;
        while (index != 0) {
            temp = temp.getNext();
            index--;
        }

        if (temp.hasNext()) {
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        } else
            temp.setNext(newNode);

    }

    @Override
    public T remove(int index) {
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
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
