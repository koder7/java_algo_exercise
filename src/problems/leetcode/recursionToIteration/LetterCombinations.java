package problems.leetcode.recursionToIteration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        backtrack("", digits);
        return result;
    }

    private void backtrack(String combination, String nextDigits) {
        if(nextDigits.length() == 0) {
            result.add(combination);
            return;
        }
        String digit = nextDigits.substring(0,1);
        String letters = phone.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            String letter =  letters.substring(i, i + 1);

            backtrack(combination + letter, nextDigits.substring(1));
        }
    }

    public static void main(String[] args) {
        LetterCombinations sol = new LetterCombinations();
        System.out.println(sol.letterCombinations("234").toString());
    }
}
