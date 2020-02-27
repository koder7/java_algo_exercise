package problems.leetcode.interviewCollection.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ArrayIntersection {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] shorter, longer;
        if (nums1.length > nums2.length) {
            shorter = nums2;
            longer = nums1;
        } else {
            shorter = nums1;
            longer = nums2;
        }

        for (int n : shorter) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for(int n : longer) {
            int cnt = map.getOrDefault(n, 0);
            if(cnt > 0) {
                nums1[k++] = n;
                map.put(n, cnt-1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static void main(String[] args) {
        ArrayIntersection sol = new ArrayIntersection();
        System.out.println(Arrays.toString(sol.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
}
