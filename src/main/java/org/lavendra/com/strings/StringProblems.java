package org.lavendra.com.strings;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProblems {

    //Permutations and Combinations of String
    public void printAllPermutationAndCombinations(char[] charArray) {

    }

    public String getLargestSubstring(String inputString) {
        Set<String> stringSet = new LinkedHashSet<>();
        String largestSubstring = "";
        List<String> strings = new ArrayList<>();
        int startIndex = 0;
        int indexTrack = 0;
        for (int i = 0; i < inputString.length(); i++) {
            String substr = inputString.substring(i, i + 1);
            if (stringSet.contains(substr)) {
                indexTrack++;
                i = indexTrack - 1;
                startIndex++;
                stringSet.clear();
            } else {
                stringSet.add(substr);
                largestSubstring = inputString.substring(startIndex, i + 1);
                strings.add(largestSubstring);
            }
        }
        int previousStringLen = 0;
        int previousStringIndex = 0;
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() >= previousStringLen) {
                previousStringLen = strings.get(i).length();
                previousStringIndex = i;
            }
        }
        System.out.println(strings);
        return strings.get(previousStringIndex);
    }

    //Reverse a String
    public String getReveresdString(String inputString) {
        assert inputString != null;
        StringBuilder stringBuffer = new StringBuilder();
        String[] stringArray = inputString.split("");
        for (int i = stringArray.length - 1; i >= 0; i--) {
            stringBuffer.append(stringArray[i]);
        }
        return stringBuffer.toString();
    }

    //Subsequence of given string
    public void printAllSubsequenceOfString(String inputString) {

    }

    /**
     * Find fabonaci number
     */
    public int fabonaciSeries(int index) {
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else {
            return fabonaciSeries(index - 1) + fabonaciSeries(index - 2);
        }
    }

    public void printFabonaciSeries(int index) {
        for (int i = 0; i < index; i++) {
            System.out.println(fabonaciSeries(i));
        }
    }


    public void extractNumSpecialChar(String inputString) {
        String input = "Aman1234Maithani@125ABCD!*/A";
        Pattern pattern = Pattern.compile("(?<numbers>\\d+)|(?<special>[^\\w\\s])|(?<alphabets>[a-zA-Z]+)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            if (matcher.group("numbers") != null) {
                System.out.println("Number: " + matcher.group("numbers"));
            } else if (matcher.group("special") != null) {
                System.out.println("Special Character: " + matcher.group("special"));
            } else if (matcher.group("alphabets") != null) {
                System.out.println("Alphabet: " + matcher.group("alphabets"));
            }
        }
    }

    public String getLargestSubString(String inputString) {
        List<String> subStrings = new ArrayList<>();
        int startIndex = 0;
        for (int i = startIndex; i < inputString.length(); i++) {
            if (isAllCharacterUnique(inputString.substring(startIndex, i + 1))) {
                subStrings.add(inputString.substring(startIndex, i + 1));
            } else {
                startIndex++;
            }
        }
        String output = "";
        int previousLength = 0;
        for (String word : subStrings) {
            System.out.println("SubString: " + word);
            if (word.length() > previousLength) {
                previousLength = word.length();
                output = word;
            }
        }
        return output.trim();
    }

    public boolean isAllCharacterUnique(String inputString) {
        boolean isUnique = true;
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < inputString.length(); i++) {
            if (characterSet.contains(inputString.charAt(i))) {
                isUnique = false;
                break;
            } else {
                characterSet.add(inputString.charAt(i));
            }
        }
        return isUnique;
    }


    public Map<String, List<String>> getAnagrams(List<String> words, List<String> queries) {
        HashMap<String, List<String>> output = new HashMap<>();
        HashMap<String, List<String>> wordMap = new HashMap<>();
        for (String word : words) {
            List<String> workList = new ArrayList<>();
            char[] wordsArray = word.toCharArray();
            Arrays.sort(wordsArray);
            String sortedWord = new String(wordsArray);
            if (wordMap.containsKey(sortedWord)) {
                wordMap.get(sortedWord).add(word);
            } else {
                workList.add(word);
                wordMap.put(sortedWord, workList);
            }
        }
        for (String query : queries) {
            char[] queryArray = query.toCharArray();
            Arrays.sort(queryArray);
            String sortedQuery = new String(queryArray);
            if (wordMap.containsKey(sortedQuery)) {
                output.put(query, wordMap.get(sortedQuery));
            } else {
                output.put(query, new ArrayList<>());
            }
        }
        return output;
    }

    /**
     * Reverse string keeping space at same position
     */
    public String reverseStringWithSpaceAtSamePosition(String inputString) {
        List<Integer> spacePosition = new ArrayList<>();
        char[] charArray = inputString.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                spacePosition.add(i);
            }
        }
        StringBuilder output = new StringBuilder(inputString.replace(" ", ""));
        output.reverse();
        for (int i : spacePosition) {
            output.insert(i, " ");
        }
        return output.toString().trim();
    }

    /**
     * Print all permutation and combinations
     */
    public void printAllPermutations(char[] charArray, int fixedIndex) {
        if (fixedIndex == charArray.length - 1) {
            System.out.println(charArray);
            return;
        }
        for (int i = fixedIndex; i < charArray.length; i++) {
            swap(charArray, i, fixedIndex);
            printAllPermutations(charArray, fixedIndex + 1);
            swap(charArray, i, fixedIndex);
        }
    }


    /**
     * Print all subsequence of a string
     */
    public void printALlSubsequence(char[] charArray, int fi, String subsequences) {
        if (fi == charArray.length) {
            System.out.println(subsequences);
            return;
        }
        printALlSubsequence(charArray, fi + 1, charArray[fi] + subsequences);
        printALlSubsequence(charArray, fi + 1, subsequences);
    }


    //Find all permutation and combinations of a string
    public void printAllPermutationsOfaString(char[] charArray, int fi) {
        if (fi == charArray.length - 1) {
            System.out.println(charArray);
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


    public void printAllSubsequenceOfAString(char[] charArray, int fi, String subsequence) {
        if (fi == charArray.length) {
            System.out.println(subsequence);
            return;
        }
        printAllSubsequenceOfAString(charArray, fi + 1, charArray[fi] + subsequence);
        printAllSubsequenceOfAString(charArray, fi + 1, subsequence);
    }

    public String findLongestSubStringWithUniqueCharacters(String inputString) {
        if (inputString == null || inputString.length() == 0) {
            return "";
        }
        Set<Character> uniqueChars = new HashSet<>();
        int startIndex = 0, endIndex = 0;
        int maxLength = 0;
        int maxStartIndex = 0;

        while (endIndex < inputString.length()) {
            char endChar = inputString.charAt(endIndex);
            if (!uniqueChars.contains(endChar)) {
                uniqueChars.add(endChar);
                endIndex++;
                if (endIndex - startIndex > maxLength) {
                    maxLength = endIndex - startIndex;
                    maxStartIndex = startIndex;
                }
            } else {
                uniqueChars.remove(inputString.charAt(startIndex));
                startIndex++;
            }
        }

        return inputString.substring(maxStartIndex, maxStartIndex + maxLength);
    }

    public boolean isAllCharsUnique(String inputString) {
        Set<Character> charSet = new HashSet<>();
        for (char chars : inputString.toCharArray()) {
            if (charSet.contains(chars)) {
                return false;
            } else {
                charSet.add(chars);
            }
        }
        return true;
    }

    public String findLongestPalindrome(String inputString) {
        String longestPalindrome = "";
        String currentPalindrome = "";
        int startIndex = 0;
        int endIndex = 0;
        while (endIndex < inputString.length()) {
            if (isPalindrome(inputString.substring(startIndex, endIndex + 1))) {
                currentPalindrome = inputString.substring(startIndex, endIndex + 1);
            }
            endIndex++;
            if (currentPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = currentPalindrome;
            }
        }
        return longestPalindrome;
    }

    public boolean isPalindrome(String inputString) {
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


    public boolean isTwoStringsAreAnagram(String string1, String string2) {
        char[] charArray1 = string1.toCharArray();
        char[] charArray2 = string2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.toString(charArray1).equals(Arrays.toString(charArray2));
    }

    /**
     * **Anagrams**
     * *Description**: Given two strings, check if they are anagrams of each other.
     * *Input**: s = "anagram", t = "nagaram"
     * *Output**: true
     */
    public boolean isTwoStringAnagramOptimised(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        int[] charArray = new int[256];
        for (int i = 0; i < string1.length(); i++) {
            charArray[string1.charAt(i)] = charArray[string1.charAt(i)] - 1;
        }

        for (int j = 0; j < string1.length(); j++) {
            charArray[string1.charAt(j)] = charArray[string1.charAt(j)] + 1;
        }

        for (int num : charArray) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * **Group Anagrams**
     * **Description**: Group a list of strings into anagrams.
     * **Input**: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * **Output**: [["eat","tea","ate"],["tan","nat"],["bat"]]
     */
    public List<List<String>> groupAnagrams(List<String> inputString) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String word : inputString) {
            char[] wordArray = word.toCharArray();
            Arrays.sort(wordArray);
            String key = new String(wordArray);
            List<String> anagramList = map.getOrDefault(key, new ArrayList<>());
            anagramList.add(word);
            map.put(key, anagramList);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * **Longest Substring Without Repeating Characters**
     * **Description**: Find the length of the longest substring without repeating characters.
     * **Input**: s = "abcabcbb"
     * **Output**: 3 (substring "abc" is the longest)
     */
    public String findLargestSubString(String string) {
        int max = 0;
        int startIndex = 0;
        int endIndex = 0;
        for (int right = 0, left = 0; right < string.length(); right++) {
            int index = string.indexOf(string.charAt(right), left);
            if (index != right) {
                left = index + 1;
            }
            if (max < right - left + 1) {
                max = right - left + 1;
                startIndex = left;
                endIndex = right;
            }
        }
        return string.substring(startIndex, endIndex + 1);
    }

    /**
     * **Longest Common Prefix**
     * **Description**: Write a function to find the longest common prefix string amongst an array of strings.
     * **Input**: strs = ["flower","flow","flight"]
     * **Output**: "fl"
     */
    public String findLongestCommonPrefix(String[] stringArray) {
        int index = stringArray[0].length();
        int minIndex = 0;
        int startIndex = 0;
        int endIndex = 1;
        String longestPrefix = "";
        while (minIndex < index) {
            String currentPrefix = stringArray[0].substring(startIndex, endIndex);
            boolean isAllPrefixMatched = false;
            for (int i = 1; i < stringArray.length; i++) {
                if (endIndex <= stringArray[i].length()) {
                    System.out.println(i);
                    String subString = stringArray[i].substring(startIndex, endIndex);
                    if (currentPrefix.equals(subString)) {
                        isAllPrefixMatched = true;
                    } else {
                        isAllPrefixMatched = false;
                        break;
                    }
                } else {
                    isAllPrefixMatched = false;
                }
            }
            if (isAllPrefixMatched) {
                longestPrefix = currentPrefix;
            } else {
                break;
            }
            endIndex++;
            minIndex++;
        }
        return longestPrefix;
    }

    //Find character count from string
    public String findCharacterCount(String string) {
        Map<Character, Integer> characterCountMap = new HashMap<>();
        char[] characterArray = string.toCharArray();
        for (char chars : characterArray) {
            characterCountMap.put(chars, characterCountMap.getOrDefault(chars, 0) + 1);
        }
        StringBuilder builder = new StringBuilder();
        characterCountMap.forEach((k, v) -> {
            builder.append(k).append(v);
        });
        return builder.toString();
    }

    public String insertSemicolonInString(String inputString) {
        StringBuilder builder = new StringBuilder();
        int endIndex = 2;
        for (int i = 0; i < inputString.length(); i = i + 2) {
            String subStr = inputString.substring(i, endIndex);
            builder.append(subStr);
            builder.append(":");
            endIndex = endIndex + 2;
        }
        return builder.toString();
    }

}
