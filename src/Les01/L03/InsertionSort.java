package Les01.L03;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr1));
        insertionSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    private static void insertionSort(int[] arr1) {

        for (int i = 1; i < arr1.length; i++) {
            int j = i - 1;
            int value = arr1[i];
            System.out.println("Index - " + i);
            while (j >= 0 && arr1[j] > value) {
                arr1[j + 1] = arr1[j--];
                System.out.println("Index - " + j + " " + Arrays.toString(arr1));
            }
            arr1[j + 1] = value;
            System.out.println("Index - " + j + " " + Arrays.toString(arr1));
        }
    }
}
