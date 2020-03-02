package problems.leetcode.interviewCollection.string;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagramFailed(String s, String t) {
        if(s.length() != t.length()) return false;
        int sval=0, tval=0;
        for (int i = 0; i < s.length(); i++) {
            sval += s.charAt(i);
            tval += t.charAt(i);
        }
        return (sval == tval) ? true : false;
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }


        return mapS.equals(mapT);
    }

    //From top submission
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s == null) {
                return t == null;
            }
            if (t == null) {
                return s == null;
            }
            if (s.length() != t.length()) {
                return false;
            }
            int[] alpha = new int[128];
            for (char c : s.toCharArray()) {
                alpha[c]++;
            }
            for (char c : t.toCharArray()) {
                alpha[c]--;
            }
            for (int c : alpha) {
                if (c != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        ValidAnagram sol = new ValidAnagram();
        System.out.println(sol.isAnagram("anagram", "nagaram"));
        System.out.println(sol.isAnagram("rat", "car"));
        System.out.println(sol.isAnagram("ac", "bb"));
    }
}
