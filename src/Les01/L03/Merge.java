package Les01.L03;

import java.util.Arrays;
import java.util.Random;

public class Merge {
    static Random rd = new Random();

    public static void main(String[] args) {
        int[] arr1 = init();
        int[] arr2 = init();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        int[] mergeArray = merge(arr1, arr2);
        System.out.println(Arrays.toString(mergeArray));

    }

    //O(sizeA+sizeB)
    private static int[] merge(int[] A, int[] B) {
        int indexA = 0, indexB = 0;
        int sizeA = A.length;
        int sizeB = B.length;
        int[] mergeArray = new int[sizeA + sizeB];
        int index = 0;
        while (indexA != sizeA && indexB != sizeB) {
            if (A[indexA] < B[indexB])
                mergeArray[index++] = A[indexA++];
            else
                mergeArray[index++] = B[indexB++];
        }
        while (indexA != sizeA)
            mergeArray[index++] = A[indexA++];

        while (indexB != sizeB)
            mergeArray[index++] = B[indexB++];
        return mergeArray;
    }
    private static int[] init() {
        int[] newArray = new int[rd.nextInt(20) + 1];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = rd.nextInt(900);
        }
        return newArray;
    }
}
