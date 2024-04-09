package Les01.L03;


import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    static Random rd = new Random();

    public static void main(String[] args) {
        int[] arr = init();
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int item = rd.nextInt(900);
        int index = binarySearch(arr, item);

    }

    private static int[] init() {
        int[] newArray = new int[rd.nextInt(20) + 1];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = rd.nextInt(900);
        }
        return newArray;
    }

    static public int binarySearch(int[] arr, int item) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (arr[middle] == item)
                return middle;
            else if (arr[middle] < item)
                low = middle + 1;
            else
                high = middle - 1;
        }
        return -1;
    }

}
