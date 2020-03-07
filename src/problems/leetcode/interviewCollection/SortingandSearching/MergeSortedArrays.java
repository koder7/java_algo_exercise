package problems.leetcode.interviewCollection.SortingandSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int j = 0, count = 0;
        for (int i = 0; i < m + n; i++) {
            if (i < m)
                queue.add(nums1[i]);
            if (j < n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > nums2[j]) {
                        nums1[i] = nums2[j];
                        j++;
                    } else {
                        nums1[i] = queue.poll();
                    }
                } else {
                    nums1[i] = nums2[j];
                    j++;
                }
            } else {
                count++;
            }
        }
        int index = m + n - count;
        while (!queue.isEmpty()) {
            nums1[index] = queue.poll();
            index++;
        }
    }

    //Merge Simple -- Can simply use the sapces in other array
    public void mergeAnother(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, index = m + n - 1;
        while (index >= 0) {
            if (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[index] = nums1[i];
                    i--;
                } else {
                    nums1[index] = nums2[j];
                    j--;
                }
                index--;
            } else {
                break;
            }
        }
        while (j >= 0) {
            nums1[index] = nums2[j];
            j--;
            index--;
        }
    }

    public static void main(String[] args) {
        MergeSortedArrays sol = new MergeSortedArrays();
        int[] nums1 = {1, 2, 3, 7, 8, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        sol.mergeAnother(nums1, 5, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
