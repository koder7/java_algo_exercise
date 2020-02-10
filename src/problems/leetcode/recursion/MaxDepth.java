package problems.leetcode.recursion;

public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(1+maxDepth(root.right), 1 + maxDepth(root.left));
    }
}
