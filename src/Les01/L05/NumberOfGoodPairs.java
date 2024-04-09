package Les01.L05;

import java.util.ArrayList;
import java.util.Random;

public class NumberOfGoodPairs {
    static Random rd = new Random();

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < rd.nextInt(100); i++) {
            nums.add(rd.nextInt(100));
        }

        System.out.println(nums);
        int size= nums.size();
        int counter = numIdenticalPairs(nums);
        int size2=nums.size();
        System.out.println(nums);
        System.out.printf("There are %d good pairs " ,counter);
        for (int i = size; i <size2-1 ; i+=2) {
            System.out.printf("(%d,%d), ",nums.get(i),nums.get(i+1));
        }
    }


    public static int numIdenticalPairs(ArrayList<Integer> nums) {
        int size = nums.size();
        int counter = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums.get(i).equals(nums.get(j))) {
                    counter++;
                    nums.add(i);
                    nums.add(j);
                }
//                counter += (nums.get(i).equals(nums.get(j))) ? 1 : 0;
            }
        }
        return counter;
    }

}
