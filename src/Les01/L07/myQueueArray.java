package Les01.L07;

public class myQueueArray<T> {

    public static final int DEFAULT_CAPACITY = 10;

    private Object[] objects;
    private int index;
    private int removeIndex;
    private int size;


    public myQueueArray() {
        this.objects = new Object[DEFAULT_CAPACITY];
        this.index = 0;
        this.removeIndex = 0;
        this.size = 0;
    }


    public myQueueArray(int capacity) {
        if (capacity < 1)
            this.objects = new Object[DEFAULT_CAPACITY];
        else
            this.objects = new Object[capacity];
        this.index = this.removeIndex = 0;
        this.size = 0;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(T t) {
        if (size >= objects.length)
            return false;

        objects[index++] = t;

        if (index == objects.length)
            index = 0;

        size++;
        return true;
    }


    public T remove() {
        if (size == 0)
            return null;

        Object item =  objects[removeIndex++];

        if (removeIndex == objects.length)
            removeIndex = 0;

        return (T) item;

    }

    public T poll() {
        return null;
    }


    public T peek() {
        return null;
    }
}
