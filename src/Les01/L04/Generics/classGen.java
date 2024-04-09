package Les01.L04.Generics;

import java.util.Arrays;
import java.util.Random;

public class classGen<T> {

    private Object[] arr;
    private int index;

    public Object[] getArr() {
        return arr;
    }

    public classGen() {
        this.arr = new Object[1];
        index = 0;
    }

    public void add(T value) {
        if (index == arr.length)
            init();
        arr[index++] = value;
    }

    private void init() {
        Object[] temp = new Object[index * 2];
        for (int i = 0; i < index; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }
}

class Test5 {

    public static void main(String[] args) throws InterruptedException {
        classGen<String> c = new classGen();
        for (int i = 0; i < 20; i++) {
            c.add((char) (new Random().nextInt(26) + 65) + "");
            System.out.println(Arrays.toString(c.getArr()));
            Thread.sleep(500);
        }

        classGen obj = new classGen();
        for (int i = 0; i < 20; i++) {
            obj.add((char) (new Random().nextInt(26) + 65) );
            obj.add((new Random().nextInt(26) + 65) );
            obj.add( (new Random().nextFloat()) );
            System.out.println(Arrays.toString(obj.getArr()));
            Thread.sleep(500);
        }
    }
}
