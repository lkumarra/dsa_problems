package org.lavendra.com.strings;

public class StringPermutationsProblems {

    public static void main(String[] args) {
        StringPermutationsProblems permutationsProblems = new StringPermutationsProblems();
        permutationsProblems.printAllPermutations("abc".toCharArray(), 0);
        permutationsProblems.printAllSubsequence("abc".toCharArray(), "", 0);
    }

    public void printAllPermutations(char[] charArray, int fi) {
        if (fi == charArray.length - 1) {
            System.out.println(charArray);
            return;
        }
        for (int i = fi; i < charArray.length; i++) {
            swap(charArray, i, fi);
            printAllPermutations(charArray, fi + 1);
            swap(charArray, i, fi);
        }
    }

    public void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    public void printAllSubsequence(char[] charArray, String subsequence, int fi) {
        if (fi == charArray.length) {
            System.out.println(subsequence);
            return;
        }
        printAllSubsequence(charArray, charArray[fi] + subsequence, fi + 1);
        printAllSubsequence(charArray, subsequence, fi + 1);
    }

}
