package Les01.L03;

import java.util.Arrays;
import java.util.Random;

public class BinaryVSLinear {
    static Random rd = new Random();

    public static void main(String[] args) {
        int[] arr = init();
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        int item = rd.nextInt(900);

        long start = System.currentTimeMillis();
        int inx = LinearSearch.search(arr, item);
        System.out.println("Linear index = "+inx);
        long end = System.currentTimeMillis();
        System.out.println("Linear Time: " + (end - start));

        start = System.currentTimeMillis();
        inx = BinarySearch.binarySearch(arr, item);
        System.out.println("Binary index = "+inx);
        end = System.currentTimeMillis();
        System.out.println("Binary Time: " + (end - start));

    }

    private static int[] init() {
        int[] newArray = new int[100000];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = rd.nextInt(900);
        }
        return newArray;
    }
}
