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
        int maximumSum = Integer.MIN_VALUE;
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
        return Arrays.copyOfRange(inputArray, startIndex, endIndex + 1);
    }

    //Find the largest sum of a subarray

    public int findMaximumSumOfSubArray(int[] inputArray) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < inputArray.length; i++) {
            currentSum = currentSum + inputArray[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }

    // Find subarray with maximum sum
    public int[] findMaximumSumSubArray(int[] inputArray) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int startIndex = 0;
        int endIndex = 0;
        int tempIndex = 0;

        for (int i = 0; i < inputArray.length; i++) {
            currentSum = currentSum + inputArray[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                startIndex = tempIndex;
                endIndex = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
                tempIndex = i + 1;
            }
        }
        return Arrays.copyOfRange(inputArray, startIndex, endIndex + 1);
    }

    //Find pair of sum from an array of given target
    public List<List<Integer>> findPairsOfSumOfGivenTarget(int[] inputArray, int target) {
        List<List<Integer>> output = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : inputArray) {
            int component = target - num;
            if (map.getOrDefault(component, 0) > 0) {
                output.add(List.of(component, num));
                map.put(component, map.get(component) - 1);
            } else {
                map.put(num, 1);
            }
        }
        return output;
    }

    //Find pairs of given target
    public List<List<Integer>> findIndicesOfMaximumSum(int[] inputArray, int target) {
        List<List<Integer>> output = new ArrayList<>();
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < inputArray.length; i++) {
            List<Integer> list = indexMap.getOrDefault(inputArray[i], new ArrayList<>());
            list.add(i);
            indexMap.put(inputArray[i], list);
        }
        for (int j = 0; j < inputArray.length; j++) {
            int component = target - inputArray[j];
            if (indexMap.containsKey(component)) {
                List<Integer> complementIndices = indexMap.get(component);
                for (int index : complementIndices) {
                    if (index > j) {
                        output.add(List.of(j, index));
                    }
                }
            }
        }
        return output;

    }

    public List<int[]> mergeIntervals(int[][] inputArray) {
        List<int[]> output = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            int[] firstArray = inputArray[i];
            for (int j = i + 1; j < inputArray.length; j++) {
                int substraction = Math.abs(firstArray[0] - firstArray[firstArray.length - 1]);
                int[] secondArray = inputArray[j];
                if (substraction == secondArray[0]) {
                    firstArray[firstArray.length - 1] = secondArray[secondArray.length - 1];
                }
            }
            output.add(firstArray);
        }
        return output;
    }


    // Buy and Sell Stock Problem
    public int findMaxProfitSellDay(int[] stockPrices) {
        int maxProfit = Integer.MIN_VALUE;
        int purchaseDay = 0;
        int sellDay = 0;
        for (int i = 0; i < stockPrices.length; i++) {
            for (int j = 1; j < stockPrices.length; j++) {
                int profit = stockPrices[j] - stockPrices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                    sellDay = j;
                }
            }
        }
        return sellDay + 1;
    }

    //Find the day for which profit is maximum
    public int findMaxProfitSellDayOptimised(int[] stockPricesArray) {
        int minPurchasePrice = stockPricesArray[0];
        int maxProfitDay = 0;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i < stockPricesArray.length; i++) {
            int currentProfit = stockPricesArray[i] - minPurchasePrice;
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
                maxProfitDay = i + 1;
            }
            if (minPurchasePrice > stockPricesArray[i]) {
                minPurchasePrice = stockPricesArray[i];
            }
        }
        return maxProfitDay;
    }

    //Find the missing or disappeared number in an array
    public List<Integer> findDisappearedNumber(int[] numberArray) {
        List<Integer> missingNumberList = new ArrayList<>();
        for (int i = 0; i < numberArray.length; i++) {
            int index = Math.abs(numberArray[i]) - 1;
            if (numberArray[index] > 0) {
                numberArray[index] = -numberArray[index];
            }
        }
        for (int i = 0; i < numberArray.length; i++) {
            if (numberArray[i] > 0) {
                missingNumberList.add(i + 1);
            }
        }
        return missingNumberList;
    }

    //Merge two sorted array// input1 = [1,2,4,5], input2 = [3,6,7,8]
    public int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr1[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            mergedArray[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            mergedArray[k++] = arr2[j++];
        }
        return mergedArray;
    }
}
