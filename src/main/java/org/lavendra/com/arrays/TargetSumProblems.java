package org.lavendra.com.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TargetSumProblems {

    public static void main(String[] args) {
        TargetSumProblems targetSumProblems = new TargetSumProblems();
        int[] input = {2, 7, 3, 6, 0, 9, 7, 2};
        System.out.println(targetSumProblems.findPairsOfTargetSum(input, 9));
        System.out.println(targetSumProblems.findIndicesOfTargetSum(input, 9));
    }

    public List<List<Integer>> findPairsOfTargetSum(int[] inputArray, int target) {
        List<List<Integer>> pairsList = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : inputArray) {
            int component = target - num;
            if (countMap.getOrDefault(component, 0) > 0) {
                pairsList.add(List.of(num, component));
                countMap.put(component, countMap.get(component) - 1);
            } else {
                countMap.put(num, 1);
            }
        }
        return pairsList;
    }

    public List<List<Integer>> findIndicesOfTargetSum(int[] inputArray, int target) {
        List<List<Integer>> indicesList = new ArrayList<>();
        Map<Integer, List<Integer>> indexCountMap = new HashMap<>();
        for (int i = 0; i < inputArray.length; i++) {
            List<Integer> indexList = indexCountMap.getOrDefault(inputArray[i], new ArrayList<>());
            indexList.add(i);
            indexCountMap.put(inputArray[i], indexList);
        }
        for (int i = 0; i<inputArray.length; i++) {
            int component = target - inputArray[i];
            if (indexCountMap.containsKey(component)) {
                List<Integer> indexList = indexCountMap.get(component);
                for (Integer index : indexList) {
                    if (index > i) {
                        indicesList.add(List.of(i, index));
                    }
                }
            }
        }
        return indicesList;
    }
}
