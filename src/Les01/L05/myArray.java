package Les01.L05;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class myArray implements List {

    private static final int DEFAULT_CAPACITY = 10;

    private int[] arr;
    private int index;
    private int capacity;

    public myArray() {
        arr = new int[DEFAULT_CAPACITY];
        index = 0;
        capacity = DEFAULT_CAPACITY;
    }

    public myArray(int initialCapacity) {
        if (initialCapacity <= 0)
            arr = new int[DEFAULT_CAPACITY];
        else
            arr = new int[initialCapacity];
        index = 0;
        capacity = DEFAULT_CAPACITY;
    }


    @Override
    public int size() {
        return index;
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        if (index == capacity)
            init();
        arr[index++] = (int) o;
        return true;
    }

    private void init() {
        int[] temp = new int[capacity*2];
        for (int i = 0; i < capacity; i++) {
            temp[i] = arr[i];
        }
        capacity *= 2;
        arr = temp;

    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty())
            return false;
        int i = 0;
        for (; i < index; i++) {
            if (o.equals(arr[i])) {
                index--;
                break;
            }
        }
        for (int j = i; j < index; j++) {
            arr[j] = arr[j + 1];
        }

        return i != index;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
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
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
