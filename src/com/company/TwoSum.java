package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        List<Integer> twoSum = new ArrayList();
        int sum = 0;
        Map<Integer, Integer> arr = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if(arr.containsKey(target - nums[i])) {
                return new int[] {arr.get(target - nums[i]), i};
            }
            arr.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {

        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum.twoSum(nums,9)));
    }
}