package problems.leetcode.interviewCollection.array;

import java.util.Arrays;

public class RotateArray {
    public int[] rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int last = nums[nums.length - 1];
            for (int j = 0; j < nums.length - 1; j++) {
                int prev = nums[0];
                nums[0] = nums[j + 1];
                nums[j + 1] = prev;
            }
            nums[0] = last;
        }
        return nums;
    }

    public int[] rotateSinglePass(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
        return nums;
    }

    public static void main(String[] args) {
        RotateArray sol = new RotateArray();
//        System.out.println(Arrays.toString(sol.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
//        System.out.println(Arrays.toString(sol.rotateSinglePass(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
        System.out.println(Arrays.toString(sol.rotateSinglePass(new int[]{1, 2, 3, 4, 5, 6}, 2)));

    }
}
