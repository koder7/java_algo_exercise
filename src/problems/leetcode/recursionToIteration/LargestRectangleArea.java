package problems.leetcode.recursionToIteration;

import java.util.Stack;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        return helper(heights, 0, heights.length - 1);
    }

    private int helper(int[] heights, int start, int end) {
        if (start > end)
            return 0;
        int minIndex = start;
        for (int i = start; i <= end; i++) {
            if (heights[minIndex] > heights[i]) minIndex = i;
        }
        int area = heights[minIndex] * (end - start + 1);
        return Math.max(area, Math.max(helper(heights, start, minIndex - 1),
                helper(heights, minIndex + 1, end)));
    }

    public int largestRectangleAreaStack(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek()-1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() -1));

        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleArea sol = new LargestRectangleArea();
        int[] input = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(sol.largestRectangleAreaStack(input));
    }
}
