package org.lavendra.com.arrays;

import java.util.Arrays;

public class SortArrays {

    public static void main(String[] args) {
        int[] inputArray = {1, 3, 2, 5, 4};
        SortArrays arrays = new SortArrays();
        System.out.println(Arrays.toString(arrays.sortArray(inputArray)));
    }

    public int findMax(int[] inputArray) {
        int max = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (max < inputArray[i]) {
                max = inputArray[i];
            }
        }
        return max;
    }

    //Counting sort for non-negative integers
    public int[] sortArray(int[] inputArray) {
        int max = findMax(inputArray);
        int[] count = new int[max + 1];
        for (int num : inputArray) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                inputArray[index++] = i;
                count[i]--;
            }
        }
        return inputArray;
    }

    //Redix sort for non-negative integers

}
