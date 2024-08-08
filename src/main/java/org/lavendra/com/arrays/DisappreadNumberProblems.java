package org.lavendra.com.arrays;

import java.util.ArrayList;
import java.util.List;

public class DisappreadNumberProblems {
    public static void main(String[] args) {
        DisappreadNumberProblems disappreadNumberProblems = new DisappreadNumberProblems();
        int[] inputArray = {1, 2, 3, 2, 7, 1, 3};
        System.out.println(disappreadNumberProblems.findDisAppearedNumbers(inputArray));
    }

    public List<Integer> findDisAppearedNumbers(int[] inputArray) {
        List<Integer> numbersList = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            int index = Math.abs(inputArray[i]) - 1;
            if (inputArray[index] > 0) {
                inputArray[index] = -inputArray[index];
            }
        }
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] > 0) {
                numbersList.add(i + 1);
            }
        }
        return numbersList;
    }

}
