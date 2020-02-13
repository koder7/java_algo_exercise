package problems.leetcode.divideandconquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArray {
    public List<Integer> sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        int left, middle, right;
        for (int step = 2; step < nums.length; step *= 2) {
            for (int i = 0; i < nums.length; i += 2 * step) {
                if(i + step < nums.length) {
                    left = i;
                    middle = i + step;
                    right = i + step * 2;
                    merge(nums, left, middle, right, temp);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = temp[i];
            }
        }
        List<Integer> result = new ArrayList<>(nums.length);
        for (int i : nums) {
            result.add(i);
        }
        return result;
    }

    private void merge(int[] nums, int left, int middle, int right, int[] temp) {
        int i = left;
        int j = middle;
        int k = left;

        middle = Math.min(middle, nums.length);
        right = Math.min(right, nums.length);

        while (i < middle || j < right) {
            if (i < middle && j < right) {
                if (nums[i] < nums[j]) {
                    temp[k++] = nums[i++];
                } else {
                    temp[k++] = nums[j++];
                }
            } else if (i == middle) {
                temp[k++] = nums[j++];
            } else if (j == right) {
                temp[k++] = nums[i++];
            }
        }
        while (k < nums.length) {
            temp[k] = nums[k];
            k++;
        }
    }

    public int[] sortArrayRecursiveDiv(int[] nums) {
        if (nums == null) {
            return nums;
        }

        if (nums.length > 1) {
            int mid = nums.length / 2;

            // Split left part
            int[] left = new int[mid];
            for (int i = 0; i < mid; i++) {
                left[i] = nums[i];
            }

            // Split right part
            int[] right = new int[nums.length - mid];
            for (int i = mid; i < nums.length; i++) {
                right[i - mid] = nums[i];
            }

            sortArray(left);
            sortArray(right);

            int i = 0;
            int j = 0;
            int k = 0;

            // Merge left and right arrays
            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    nums[k++] = left[i++];
                } else {
                    nums[k++] = right[j++];
                }
            }

            // Collect remaining elements
            while (i < left.length) {
                nums[k++] = left[i++];
            }

            while (j < right.length) {
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

        System.out.println(sortArray.sortArray(arr));
    }
}

