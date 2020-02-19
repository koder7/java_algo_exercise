package problems.leetcode.recursionToIteration;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();

        if (n == 0) {
            return result;
        }
        backtrack("", 0, 0, n, result);
        return result;
    }

    private void backtrack(String s, int open, int close, int max, List<String> result) {
        if (s.length() == 2 * max) {
            result.add(s);
            return;
        }
        if (open < max) {
            backtrack(s + "(", open + 1, close, max, result);
        }
        if (close < open) {
            backtrack(s + ")", open, close + 1, max, result);
        }
    }

    private void backtrackIterative(String s, int open, int close, int max, List<String> result) {
        if (s.length() == 2 * max) {
            result.add(s);
            return;
        }
        ArrayDeque<String> stack = new ArrayDeque<>();
        if (open < max) {
            stack.add("(");
            open++;
            backtrack(s + "(", open + 1, close, max, result);
        }
        if (close < open) {
            backtrack(s + ")", open, close + 1, max, result);
        }
    }

    private void helper(int n, int open, int close, StringBuilder sb, List<String> res) {
        if (open == n && close == n) {
            res.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append("(");
            helper(n, open+1, close, sb, res);// open
            sb.deleteCharAt(sb.length()-1);
        }
        if (close < open) {
            sb.append(")");
            helper(n, open, close+1, sb, res);// close
            sb.deleteCharAt(sb.length()-1);
        }
    }

/* With String builder
    public List<String> generateParenthesis(int n) {
        if (n == 0) return Collections.emptyList();
        if (n == 1) return Arrays.asList("()");
        List<String> res = new ArrayList<String>();
        helper(n, 0, 0, new StringBuilder(), res);
        return res;
    }*/

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        generateParenthesis.generateParenthesis(3).forEach(System.out::println);
    }
}
