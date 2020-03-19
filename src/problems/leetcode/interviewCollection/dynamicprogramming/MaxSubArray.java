package problems.leetcode.interviewCollection.dynamicprogramming;

public class MaxSubArray {
    //Brute force approach .. time exceeding
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            int sum = countMaxSlidingWindow(nums, i);
            if (maxSum < sum)
                maxSum = sum;
        }
        return maxSum;
    }

    public int countMaxSlidingWindow(int[] nums, int w) {
        int n = nums.length;
        int slidingSum = Integer.MIN_VALUE;
        for (int i = 0; i <= n - w; i++) {
            int sum = 0;
            for (int j = i; j < i + w; j++) {
                sum += nums[j];
            }
            if (slidingSum < sum) {
                slidingSum = sum;
            }
        }
        return slidingSum;
    }

    //Single pass
    public int maxSubArraySinglePass(int[] nums) {
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];

        for (int i = 1; i < n; ++i) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubArray sol = new MaxSubArray();

//        System.out.println(sol.countMaxSlidingWindow(new int[] {2,1,-3,4,-1,2,1,-5,4}, 9));
        System.out.println(sol.maxSubArraySinglePass(new int[]{2, 1, -7, 4, -1, 2, 1, -5, 4}));
//        System.out.println(sol.maxSubArray(new int[] {-1}));

    }
}
