package problems.leetcode.interviewCollection.array;

import java.util.Arrays;

public class MoveZeros {
    public int[] moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        while(index < nums.length) {
            nums[index] = 0;
            index++;
        }
        return nums;
    }

    public static void main(String[] args) {
        MoveZeros sol = new MoveZeros();
        System.out.println(Arrays.toString(sol.moveZeroes(new int[]{0, 1, 2, 13, 0})));
        System.out.println(Arrays.toString(sol.moveZeroes(new int[]{0,0,1})));
    }
}
