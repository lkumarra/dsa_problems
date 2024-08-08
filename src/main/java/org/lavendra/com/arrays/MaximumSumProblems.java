package org.lavendra.com.arrays;

import java.util.Arrays;

public class MaximumSumProblems {

    public static void main(String[] args) {
        MaximumSumProblems maximumSumProblems = new MaximumSumProblems();
        int[] inputArray = {-2, 1, 4, 3, -1, -5};
        System.out.println(maximumSumProblems.findMaximumSumOfSubArray(inputArray));
        System.out.println(Arrays.toString(maximumSumProblems.findMaximumSumSubArray(inputArray)));
    }

    public int findMaximumSumOfSubArray(int[] array) {
        int maximumSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int j : array) {
            currentSum = currentSum + j;
            maximumSum = Math.max(currentSum, maximumSum);
            currentSum = Math.max(currentSum, 0);
        }
        return maximumSum;
    }

    public int[] findMaximumSumSubArray(int[] inputArray) {
        int maximumSum = Integer.MIN_VALUE;
        int currentSum = 0, startIndex = 0, endIndex = 0, temp = 0;
        for (int i = 0; i < inputArray.length; i++) {
            currentSum = currentSum + inputArray[i];
            if (maximumSum < currentSum) {
                maximumSum = currentSum;
                startIndex = temp;
                endIndex = i;
            }
            if (currentSum < 0) {
                currentSum = 0;
                temp = i + 1;
            }
        }
        return Arrays.copyOfRange(inputArray, startIndex, endIndex + 1);
    }
}
