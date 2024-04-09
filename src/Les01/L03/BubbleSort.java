package Les01.L03;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {


    static Random rd = new Random();

    public static void main(String[] args) {
//        int[] arr1 = init();
        int[] arr1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr1));
        bubbleSort2(arr1);
    }

    //O(n^2)
    private static void bubbleSort(int[] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length - 1; j++) {
                if (arr1[j] > arr1[j + 1])
                    swap(arr1, j, j + 1);
                System.out.println("Index - " + j + " " + Arrays.toString(arr1));
            }
        }
    }

    //O(n^2)
    private static void bubbleSort2(int[] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length - 1-i; j++) {
                if (arr1[j] > arr1[j + 1])
                    swap(arr1, j, j + 1);
                System.out.println("Index - " + j + " " + Arrays.toString(arr1));
            }
        }
    }

    //O(1)
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int[] init() {
        int[] newArray = new int[rd.nextInt(20) + 1];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = rd.nextInt(900);
        }
        return newArray;
    }
}
