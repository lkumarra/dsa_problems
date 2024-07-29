package org.lavendra.com.arrays;

import java.util.*;


public class ArrayProblems {

    /**
     * input = {
     * {1,2,3}
     * 00,01,02
     * {4,5,6}
     * 10,11,12
     * {7,8,9}
     * 20,21,22
     * }
     * <p>
     * O/P = {
     * {1,4,7}
     * 00,10,20
     * {2,5,8}
     * 01,11,21
     * {3,6,9}
     * 02,12,22
     * }
     */

    public int[][] trasposingMatrix(int[][] inputMatrix) {
        int rowCount = inputMatrix.length;
        int columCount = inputMatrix[0].length;
        int[][] output = new int[columCount][rowCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columCount; j++) {
                output[j][i] = inputMatrix[i][j];
            }
        }
        return output;
    }

    /*
    input = [2,2,1,3,0,4]
    sum = 4 // pair = [1,3], [2,2], [4,0]
     */
    public List<List<Integer>> pairsOfSum(int[] inputArray, int expectedSum) {
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[i] + inputArray[j] == expectedSum) {
                    output.add(List.of(inputArray[i], inputArray[j]));
                }
            }
        }
        return output;
    }

    public List<List<Integer>> pairOfSumOptimized(int[] inputArray, int expectedSum) {
        List<List<Integer>> output = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : inputArray) {
            int complement = expectedSum - num;

            if (map.getOrDefault(complement, 0) > 0) {
                output.add(List.of(complement, num));
                map.put(complement, map.get(complement) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return output;
    }

    /*
    input = [
             [1,2,3]
             00,01,02
             [4,5,6]
             10,11,12
             [7,8,9]
             20,21,22
             ]

     output = [
     [7,4,1]
     00,01,02
     20,10,00
     [8,5,2]
     10,11,12
     21,11,01
     [9,6,3]
     20,21,22
     22,12,01
        ]
     */
    public int[][] rotateMatrix90Degree(int[][] inputArray) {
        int rowCount = inputArray.length;
        int columnCount = inputArray[0].length;
        int[][] output = new int[columnCount][rowCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                output[j][rowCount - 1 - i] = inputArray[i][j];
            }
        }
        return output;
    }
    //input 4, 4-2 = 2 if one
    //4-1 = 3

    //[2,7,3,6]
    //2-0
    //9-2 = 7(
    //9
    public List<List<Integer>> findIndicesOfTargetSum(int[] inputArray, int targetSum) {
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[i] + inputArray[j] == targetSum) {
                    output.add(List.of(i, j));
                }
            }
        }
        return output;
    }

    public List<List<Integer>> findIndicesOfTargetSumOptimized(int[] inputArray, int targetSum) {
        List<List<Integer>> output = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < inputArray.length; i++) {
            if (map.containsKey(inputArray[i])) {
                List<Integer> inputList = map.get(inputArray[i]);
                inputList.add(i);
                map.put(inputArray[i], inputList);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(inputArray[i], list);
            }
        }
        for (int i = 0; i < inputArray.length; i++) {
            int component = targetSum - inputArray[i];
            if (map.containsKey(component)) {
                List<Integer> componentIndex = map.get(component);
                for (Integer number : componentIndex) {
                    if (number > i) {
                        output.add(List.of(i, number));
                    }
                }
            }
        }
        return output;
    }

    public List<List<Integer>> findIndicesOfTargetSumOptimized2(int[] inputArray, int targetSum) {
        List<List<Integer>> output = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        // First pass: populate the map with the indices of each element
        for (int i = 0; i < inputArray.length; i++) {
            if (!map.containsKey(inputArray[i])) {
                map.put(inputArray[i], new ArrayList<>());
            }
            map.get(inputArray[i]).add(i);
        }

        // Second pass: find pairs
        for (int i = 0; i < inputArray.length; i++) {
            int complement = targetSum - inputArray[i];
            if (map.containsKey(complement)) {
                List<Integer> complementIndices = new ArrayList<>(map.get(complement));
                for (int index : complementIndices) {
                    if (index > i) {
                        output.add(List.of(i, index));
                    }
                }
            }
        }
        return output;
    }

    public int findMinimumIntegerFromArray(int[] inputArray) {
        int output = inputArray[0];
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] < output) {
                output = inputArray[i];
            }
        }
        return output;
    }

    public int[] findProductOfArrayElementExceptCurrent(int[] inputArray) {
        int product = 1;
        int[] outputArray = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            product = product * inputArray[i];
        }
        for (int i = 0; i < outputArray.length; i++) {
            outputArray[i] = product / inputArray[i];
        }
        return outputArray;
    }
    //[-1,1,3,-2,2]
    //
    public int[] findSubarrayWithMaximumSum(int[] inputArray) {
        int maximumSum = 0;
        int currentSum = 0;
        int startIndex = 0;
        int endIndex = 0;
        int tempStart = 0;
        for (int i = 0; i < inputArray.length; i++) {
            currentSum = currentSum + inputArray[i];
            if (currentSum > maximumSum) {
                maximumSum = currentSum;
                startIndex = tempStart;
                endIndex = i;
            }
            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }
        return Arrays.copyOfRange(inputArray, startIndex, endIndex+1);
    }


}
