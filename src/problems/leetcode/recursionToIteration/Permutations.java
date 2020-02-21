package problems.leetcode.recursionToIteration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();
        List<Integer> numList = new ArrayList<>();
        for (int i : nums) {
            numList.add(i);
        }
        int n = nums.length;
        backtrack(n, numList, output, 0);
        return output;
    }

    private void backtrack(int n,
                           List<Integer> numList,
                           List<List<Integer>> output,
                           int first) {
        if(first == n) {
            output.add(new ArrayList<>(numList));
        }

        for (int i = first; i < n; i++) {

            Collections.swap(numList, first, i);

            backtrack(n, numList, output, first+1);

            Collections.swap(numList, first, i);
        }
    }
}
