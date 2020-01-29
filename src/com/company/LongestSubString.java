package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubString {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> indexMap = new HashMap<>();
        int startIndex = 0;
        for(int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))) {
                maxLength = Math.max(set.size(), maxLength);
                if (s.charAt(i) == s.charAt(i-1)) {
                    set.clear();
                    set.add(s.charAt(i));
                    indexMap.put(s.charAt(i), i);
                    startIndex = i;
                } else {
                    // remove till fist index
                    int index = indexMap.get(s.charAt(i));
                    for(int j = startIndex; j < index; j++) {
                        set.remove(s.charAt(j));
                    }
                    indexMap.put(s.charAt(i), i);
                    startIndex = index + 1;
                }
            } else {
                set.add(s.charAt(i));
                indexMap.put(s.charAt(i), i);
            }
        }
        maxLength = Math.max(set.size(), maxLength);

        return (maxLength == 0 && s.length() > 0) ? 1 : maxLength;
    }
}
