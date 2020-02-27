package problems.leetcode.interviewCollection.array;

import java.util.HashMap;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], 1);
            }
        }
        return map.keySet().stream().findFirst().get();
    }

    public int singleNumberXor(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }

    public static void main(String[] args) {
        SingleNumber sol = new SingleNumber();
        System.out.println(sol.singleNumber(new int[]{1, 1, 2, 3, 3}));
        System.out.println(sol.singleNumber(new int[]{2, 1, 4, 1, 2}));

        System.out.println(sol.singleNumberXor(new int[]{1, 1, 2, 3, 3}));
        System.out.println(sol.singleNumberXor(new int[]{2, 1, 4, 1, 2}));
    }
}
