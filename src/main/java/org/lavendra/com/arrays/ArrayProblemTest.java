package org.lavendra.com.arrays;

import java.util.Arrays;

public class ArrayProblemTest {

    public static void main(String[] args) {
        ArrayProblems problems = new ArrayProblems();
//        int[][] input = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12}
//        };
//        for (int i = 0; i < input.length; i++) {
//            System.out.println(Arrays.deepToString(new Object[]{input[i]}));
//        }
//        System.out.println("Transposed Matrix ");
//        int[][] output = problems.trasposingMatrix(input);
//        for (int i = 0; i < output.length; i++) {
//            System.out.println(Arrays.deepToString(new Object[]{output[i]}));
//        }
//        int[] inputArray = {2, 2, 1, 3, 0, 4, 2};
//        System.out.println(problems.pairsOfSum(inputArray, 4));
//        System.out.println(problems.pairOfSumOptimized(inputArray, 4));
//        int[][] rotatedMatrix = problems.rotateMatrix90Degree(input);
//        for (int i = 0; i < rotatedMatrix.length; i++) {
//            System.out.println(Arrays.deepToString(new Object[]{rotatedMatrix[i]}));
//        }
        //int[] inputArray2 = {2, 2, 7, 3, 6, 7, 0, 9};
        //int[] inputArray2 = {2, 2, 2, 2};
        //System.out.println(problems.findIndicesOfTargetSumOptimized(inputArray2, 9));
        //System.out.println(problems.findIndicesOfTargetSumOptimized2(inputArray2, 9));
        //int[] smallestElementArray = {2, 3, 4, 1, 5, 0, -1, -2, -5};
        //System.out.println(problems.findMinimumIntegerFromArray(smallestElementArray));
        //int[] productArrayInput = {1, 2, 3, 4};
        //int[] productOutput = problems.findProductOfArrayElementExceptCurrent(productArrayInput);
        //System.out.println(Arrays.deepToString(new Object[]{productOutput}));

        int[] arrayToFindSum = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(Arrays.toString(problems.findSubarrayWithMaximumSum(arrayToFindSum)));
    }
}
