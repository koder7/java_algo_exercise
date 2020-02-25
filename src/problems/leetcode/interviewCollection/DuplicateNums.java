package problems.leetcode.interviewCollection;

import java.util.Arrays;

public class DuplicateNums {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int num = nums[0], j = 1, temp = 0, unique = 1, index = 0;
        boolean duplicate = false;
        for (int i = 1; i < nums.length; i++) {
            while(i < nums.length && num == nums[i] ) {
                i++;
                duplicate = true;
            }
            if( i < nums.length) {
                num = nums[i];
                if (duplicate) {
                    nums[i] = nums[unique];
                    nums[unique] = num;
                }
                unique++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return unique;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        System.out.println(Arrays.toString(nums));
        return i + 1;
    }
    public static void main(String[] args) {
        DuplicateNums sol = new DuplicateNums();
//        System.out.println(sol.removeDuplicates(new int[]{1,1,2,3}));
//        System.out.println(sol.removeDuplicates(new int[]{1,2}));
//        System.out.println(sol.removeDuplicates(new int[]{1,2,3}));
//        System.out.println(sol.removeDuplicates(new int[]{0,1,1,2}));
//        System.out.println(sol.removeDuplicates(new int[]{1,1,1,1}));
//        System.out.println(sol.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));

        System.out.println(sol.removeDuplicates2(new int[]{1,1,2,3}));
        System.out.println(sol.removeDuplicates2(new int[]{1,2}));
        System.out.println(sol.removeDuplicates2(new int[]{1,2,3}));
        System.out.println(sol.removeDuplicates2(new int[]{0,1,1,2}));
        System.out.println(sol.removeDuplicates2(new int[]{1,1,1,1}));
        System.out.println(sol.removeDuplicates2(new int[]{0,0,1,1,1,2,2,3,3,4}));

    }
}
