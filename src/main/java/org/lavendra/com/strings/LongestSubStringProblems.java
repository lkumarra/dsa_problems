package org.lavendra.com.strings;

public class LongestSubStringProblems {

    public static void main(String[] args) {
        String inputString = "lavendra";
        LongestSubStringProblems problems = new LongestSubStringProblems();
        System.out.println(problems.findLongestSubString(inputString));
    }

    public String findLongestSubString(String inputString) {
        int max = 0;
        int startIndex = 0;
        int endIndex = 0;
        for (int right = 0, left = 0; right < inputString.length(); right++) {
            int index = inputString.indexOf(inputString.charAt(right), left);
            if (index != right) {
                left = left + 1;
            }
            if (max < right - left + 1) {
                max = right - left + 1;
                startIndex = left;
                endIndex = right;
            }
        }
        return inputString.substring(startIndex, endIndex + 1);
    }
}
