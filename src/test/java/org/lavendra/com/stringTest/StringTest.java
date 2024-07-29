package org.lavendra.com.stringTest;

import org.lavendra.com.strings.StringProblems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringTest {

    public static void main(String[] args) {
//        List<String> words = List.of("speed", "sdeep", "deeps", "deesp", "peeds", "peers", "reeps", "resep");
//        List<String> queries = List.of("speed", "deeps", "peers", "pee", "deep", "reep", "resep", "speeds");
        StringProblems stringProblems = new StringProblems();
//        Map<String, List<String>> anagrams = stringProblems.getAnagrams(words, queries);
//        System.out.println(anagrams);
//        System.out.println(stringProblems.getLargestSubString("worldhellow"));
//        System.out.println(stringProblems.reverseStringWithSpaceAtSamePosition("today is saturday"));
        // stringProblems.printAllPermutations("abcd".toCharArray(), 0);
        //stringProblems.printFabonaciSeries(100);
        //System.out.println(stringProblems.fabonaciSeries(10));
        stringProblems.printALlSubsequence("abc".toCharArray(), 0, "");
    }

}
