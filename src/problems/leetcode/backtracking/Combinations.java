package problems.leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

public class Combinations {
    List<List<Integer>> output = new LinkedList();
    int n;
    int k;

    public void backtrack(int first, LinkedList<Integer> curr) {
        // if the combination is done
        if (curr.size() == k) {
            output.add(new LinkedList(curr));
            return;
        }

        for (int i = first; i < n + 1; ++i) {
            // add i into the current combination
            curr.add(i);
            curr.forEach(System.out::print);
            System.out.println();
            // use next integers to complete the combination
            backtrack(i + 1, curr);
            // backtrack
            curr.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<Integer>());
        return output;
    }

/* Fails with 1 combinations
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int w = k - 1;
        for (int i = 1; i <= n; i += 1) {
            for (int j = i + w; j <= n; j++) {
                int t = w;
                List<Integer> c = new ArrayList<>(k);
                while (t > 0) {
                    t--;
                    c.add(i + t);
                }
                c.add(j);
                result.add(c);
            }
        }
        return result;
    }*/

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
//        combinations.combine(4, 2);
        combinations.combine(4, 2).forEach(System.out::println);
    }
}
