package problems.leetcode.recursionToIteration;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        inOrder(root, result);
        return result;
    }

    public List<Integer> inOrder(TreeNode node, List<Integer> result) {
        if(node != null) {
            inOrder(node.left, result);
            result.add(node.val);
            inOrder(node.right, result);
        }
        return result;
    }

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
}
