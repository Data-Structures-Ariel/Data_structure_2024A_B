package Les01.L06;

public class myStackArray<T>  {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] objects;
    private int size;

    public myStackArray(int capacity) {
        if (capacity <= 0)
            this.objects = new Object[DEFAULT_CAPACITY];
        this.objects = new Object[capacity];
        size = 0;
    }

    public myStackArray() {
        this.objects = new Object[DEFAULT_CAPACITY];
        size = 0;
    }


    public T push(T item) {
        if (objects.length > size)
            objects[size++] = item;
        else
            throw new IndexOutOfBoundsException("SIZE IS CAPACITY");
        return item;
    }

    public T pop() {
        if (isEmpty())
            throw new ArrayIndexOutOfBoundsException();
        // {1,2,3,4,5,6,7,0,0,0}
        //size=6;
        T obj;
        obj = (T) objects[--size];
        return obj;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < size; i++) {
            str += objects[i] + ((i + 1 == size) ? "" : ", ");
        }

        str += "]";
        return str;
    }
}
