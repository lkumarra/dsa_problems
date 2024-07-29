package org.lavendra.com.maps;

import java.util.HashMap;
import java.util.Map;

public class MapProblems {

    public String findOccurance(String inputString) {
        StringBuilder outputString = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < inputString.length(); i++) {
            map.put(inputString.charAt(i), map.getOrDefault(inputString.charAt(i), 0) + 1);
        }
        for(Character charac:map.keySet()){
            outputString.append(charac).append(map.get(charac));
        }
        return outputString.toString().trim();
    }
}
