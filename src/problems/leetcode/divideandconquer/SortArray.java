package problems.leetcode.divideandconquer;

import java.util.Arrays;
import java.util.List;

public class SortArray {
    public int[] sortArray(int[] nums) {
        if(nums == null) {
            return nums;
        }

        if(nums.length > 1) {
            int mid = nums.length / 2;

            // Split left part
            int[] left = new int[mid];
            for(int i = 0; i < mid; i++) {
                left[i] = nums[i];
            }

            // Split right part
            int[] right = new int[nums.length - mid];
            for(int i = mid; i < nums.length; i++) {
                right[i - mid] = nums[i];
            }

            sortArray(left);
            sortArray(right);

            int i = 0;
            int j = 0;
            int k = 0;

            // Merge left and right arrays
            while(i < left.length && j < right.length) {
                if(left[i] < right[j]) {
                    nums[k++] = left[i++];
                } else {
                    nums[k++] = right[j++];
                }
            }

            // Collect remaining elements
            while(i < left.length) {
                nums[k++] = left[i++];
            }

            while(j < right.length) {
                nums[k++] = right[j++];
            }
        }
        return nums;
    }

    public int[] merge_sort(int[] input) {
        if (input.length <= 1) {
            return input;
        }
        int pivot = input.length / 2;
        int[] left_list = merge_sort(Arrays.copyOfRange(input, 0, pivot));
        int[] right_list = merge_sort(Arrays.copyOfRange(input, pivot, input.length));
        return merge(left_list, right_list);
    }

    public int[] merge(int[] left_list, int[] right_list) {
        int[] ret = new int[left_list.length + right_list.length];
        int left_cursor = 0, right_cursor = 0, ret_cursor = 0;

        while (left_cursor < left_list.length &&
                right_cursor < right_list.length) {
            if (left_list[left_cursor] < right_list[right_cursor]) {
                ret[ret_cursor++] = left_list[left_cursor++];
            } else {
                ret[ret_cursor++] = right_list[right_cursor++];
            }
        }
        // append what is remain the above lists
        while (left_cursor < left_list.length) {
            ret[ret_cursor++] = left_list[left_cursor++];
        }
        while (right_cursor < right_list.length) {
            ret[ret_cursor++] = right_list[right_cursor++];
        }
        return ret;
    }

    public static void main(String[] args) {
        SortArray sortArray = new SortArray();

        int[] arr = {3, 4, 2, 8, 5};

        System.out.println(Arrays.toString(sortArray.sortArray(arr)));
    }
}

