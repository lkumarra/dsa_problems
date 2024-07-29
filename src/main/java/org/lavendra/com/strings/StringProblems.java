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

    //Reverse a String while keeping space at same position
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

    public void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    public void printALlSubsequence(char[] charArray, int fi, String subsequences) {
        if (fi == charArray.length) {
            System.out.println(subsequences);
            return;
        }
        printALlSubsequence(charArray, fi + 1, charArray[fi] + subsequences);
        printALlSubsequence(charArray, fi + 1, subsequences);
    }


}
