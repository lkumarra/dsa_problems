package org.lavendra.com.strings;

public class PalindromeStringProblems {
    public static void main(String[] args) {
        PalindromeStringProblems problems = new PalindromeStringProblems();
        System.out.println(problems.isPalindromeString("abc"));
    }

    public boolean isPalindromeString(String inputString) {
        int left = 0;
        int right = inputString.length() - 1;
        while (left < right) {
            if (inputString.charAt(left) != inputString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
