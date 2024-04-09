package Les01.L03;

import java.util.Random;

public class LinearSearch {
    static Random rd = new Random();

    public static void main(String[] args) {
        int[] arr = init();

        int item = rd.nextInt(900);
        int index = search(arr, item);
    }

    private static int[] init() {
        int[] newArray = new int[rd.nextInt(20) + 1];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = rd.nextInt(900);
        }
        return newArray;
    }

    //O(n)
    public static int search(int[] arr, int item) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item)
                return i;
        }
        return index;
    }


}
