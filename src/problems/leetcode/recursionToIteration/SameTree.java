package problems.leetcode.recursionToIteration;

import java.util.ArrayDeque;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p ==null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val == q.val) return true;
        return false;
    }

    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(!check(p,q)) return false;

        ArrayDeque<TreeNode> pDeque = new ArrayDeque<>();
        ArrayDeque<TreeNode> qDeque = new ArrayDeque<>();

        pDeque.add(p);
        qDeque.add(q);

        while(!pDeque.isEmpty() && !qDeque.isEmpty()) {
            TreeNode a = pDeque.removeFirst();
            TreeNode b = qDeque.removeFirst();

            if(check(a.right,b.right)) {
                if(a.right != null) {
                    pDeque.add(a.right);
                    qDeque.add(b.right);
                }

            } else {
                return false;
            }
            if(check(a.left,b.left)) {
                if(a.left != null) {
                    pDeque.add(a.left);
                    qDeque.add(b.left);
                }
            }
            else {
                return false;
            }

        }
        return true;
    }
}
