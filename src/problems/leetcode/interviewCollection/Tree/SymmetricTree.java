package problems.leetcode.interviewCollection.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymmetricTree {
    public boolean isSymmetricIterative(TreeNode root) {
        while (root != null) {
            TreeNode node = root;
            while (node.left != null) {
                if ((node.left == null || node.right == null) &&
                        !(node.left == null && node.right == null)) {
                    return false;
                }
                node = root.left;
            }
        }
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        if (!symmetric(root, map, 0))
            return false;
        else {
            for (List<Integer> list : map.values()) {
                int n = list.size();
                for (int start = 0, end = n - 1; start < n / 2; start++, end--) {
                    if (list.get(start) != list.get(end)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean symmetric(TreeNode node, Map<Integer, List<Integer>> map, int level) {
        if (node == null) return true;
        List<Integer> list = map.get(level);
        if (list == null) {
            list = new ArrayList<>();
            map.put(level, list);
        }
        list.add(node.left != null ? node.left.val : null);
        list.add(node.right != null ? node.right.val : null);

        level += 1;
        return symmetric(node.left, map, level) && symmetric(node.right, map, level);
    }

    //Simple one from 0 sec submission
    public boolean isSymmetricSimple(TreeNode root) {
        return helper(root, root);
    }

    private boolean helper(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        return n1.val == n2.val && helper(n1.left, n2.right) && helper(n1.right, n2.left);
    }

    public static void main(String[] args) {
        SymmetricTree sol = new SymmetricTree();
//        TreeNode root = new TreeNode(1);
//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(4);
//
//        root.left = node1;
//        root.right = node2;
//        node1.left = node3;
//        node1.right = node4;
//        node2.left = node5;
//        node2.right = node6;

//      [1,2,2,null,3,null,3]

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);

        root.left = node1;
        root.right = node2;
        node1.left = null;
        node1.right = node3;
        node2.left = null;
        node2.right = node4;

        System.out.println(sol.isSymmetric(root));
    }
}
