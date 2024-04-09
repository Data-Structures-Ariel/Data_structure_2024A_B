package Les01.L03;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

    static Random rd = new Random();

    public static void main(String[] args) {
        int[] arr = init();
        int[] arr1 = init(9);

        System.out.println(Arrays.toString(arr1));

        System.out.println("---------- Before ----------");
        System.out.println(Arrays.toString(arr));

        selectionSort(arr);

        System.out.println("---------- After ----------");
        System.out.println(Arrays.toString(arr));
    }

    //O(n^2)
    public static void selectionSort(int[] arr) {
        int minIndex;
        for (int i = 0; i < arr.length; i++) {
            minIndex = minByIndex(arr, i, arr.length); //O(n)
            swap(arr, i, minIndex);//O(1)
            System.out.println("Index - "+i +" "+Arrays.toString(arr));
        }
    }

    //O(1)
    private static void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    //O(n)
    private static int minByIndex(int[] arr, int from, int to) {
        int index=from;
        for (int i = from; i < to; i++) {
            if(arr[index]>arr[i]){
                index=i;
            }
        }
        return index;
    }

    private static int[] init() {
        int[] newArray = new int[rd.nextInt(20) + 1];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = rd.nextInt(900);
        }
        return newArray;
    }

    private static int[] init(int size) {
        int[] newArray = new int[size];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = rd.nextInt(900);
        }
        return newArray;
    }


}
