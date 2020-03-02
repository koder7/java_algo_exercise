package problems.leetcode.interviewCollection.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueCharacter {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, i);
            } else {
                map.put(c, -1);
            }
        }

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() != -1) {
                return e.getValue();
            }
        }

        return -1;
    }

    //simple - contant amount of work
    public int firstUniqCharSubmission(String s) {
        int index = s.length();
        for (char c = 'a'; c <= 'z'; c++) {
            int id = s.indexOf(c);
            if (id != -1 && id == s.lastIndexOf(c)) {
                index = Math.min(index, id);
            }
        }
        return index == s.length() ? -1: index;
    }

    public static void main(String[] args) {
        UniqueCharacter sol = new UniqueCharacter();
        System.out.println(sol.firstUniqChar("leetcode"));
    }
}
