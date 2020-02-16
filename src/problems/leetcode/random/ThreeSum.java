package problems.leetcode.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums.length == 0 || nums == null) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            int left = i + 1;
            int right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    List<Integer> sol = new ArrayList<>();
                    sol.add(nums[i]);
                    sol.add(nums[left]);
                    sol.add(nums[right]);
                    result.add(sol);
                    int leftValue = nums[left];
                    while(left < nums.length && nums[left] == leftValue) {
                            left++;
                    }
                    int rightValue = nums[right];
                    while (right > left && nums[right] == rightValue) {
                            right--;
                    }
                } else if(sum < 0) {
                    left++;
                } else {
                    right++;
                }
            }
            while (i+1 < nums.length && nums[i] == nums[i+1]) {
                    i++;
            }

        }
        return result;
    }
}
