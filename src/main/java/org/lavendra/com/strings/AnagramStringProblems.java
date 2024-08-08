package org.lavendra.com.strings;

import java.util.Arrays;

public class AnagramStringProblems {
    public static void main(String[] args) {
        AnagramStringProblems problems = new AnagramStringProblems();
        System.out.println(problems.isGivenStringAnagrams("speed", "deepd"));
    }

    public boolean isGivenStringAnagrams(String firstString, String secondString) {
        if (firstString.length() != secondString.length()) {
            return false;
        }
        int[] countArray = new int[256];
        for (int i = 0; i < firstString.length(); i++) {
            int count = firstString.charAt(i);
            countArray[count] = countArray[count] - 1;
        }
        for (int i = 0; i < secondString.length(); i++) {
            int count = secondString.charAt(i);
            countArray[count] = countArray[count] + 1;
        }
        for (int num : countArray) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

}
