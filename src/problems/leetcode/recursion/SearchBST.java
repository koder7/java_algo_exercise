package problems.leetcode.recursion;

public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root.val == val) {
            return root;
        }
            if (val < root.val && root.left != null) {
                return searchBST(root.left, val);
            } else if(root.right != null) {
                return searchBST(root.right, val);
            }
        return null;
    }
}
