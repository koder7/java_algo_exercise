package problems.leetcode.recursionToIteration;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root != null) {
            TreeNode curr = root;
            result.add(Arrays.asList(root.val));
            List<TreeNode> list = new LinkedList<>();
            if (root.left != null)
                list.add(curr.left);
            if (root.right != null)
                list.add(curr.right);

            while (!list.isEmpty()) {
                result.add(addCurrentLevel(list));
                list = nextLevel(list);
            }
        }
        return result;
    }


    private List<TreeNode> nextLevel(List<TreeNode> list) {
        List<TreeNode> result = new LinkedList<>();
        for (TreeNode node : list) {
            if (node.left != null)
                result.add(node.left);
            if (node.right != null)
                result.add(node.right);
        }
        return result;
    }

    public List<Integer> addCurrentLevel(List<TreeNode> list) {
        List<Integer> result = new LinkedList<>();
        for (TreeNode node : list) {
            result.add(node.val);
        }
        return result;
    }

    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root != null)
            helper(root, 0, result);
        return result;
    }

    private void helper(TreeNode root, int level, List<List<Integer>> result) {
        List<Integer> levelResult = new LinkedList<>();

        if(level == result.size()) {
            result.add(new LinkedList<>());
        }
        result.get(level).add(root.val);

        if(root.left != null)
            helper(root.left, level + 1, result);

        if(root.right != null)
            helper(root.right, level + 1, result);

    }


}
