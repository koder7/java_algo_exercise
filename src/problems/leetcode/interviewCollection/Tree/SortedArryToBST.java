package problems.leetcode.interviewCollection.Tree;

import java.util.Random;

public class SortedArryToBST {
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helperRand(0, nums.length-1);
    }

    //left
    private TreeNode helper(int left, int right) {
        if(left > right) return null;

        int p = (left + right)/2;

        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p-1);
        root.right = helper(p+1, right);
        return root;
    }

    //right
    private TreeNode helperRight(int left, int right) {
        if(left > right) return null;

        int p = (left + right)/2;
        if ((left + right) % 2 == 1) ++p;

        TreeNode root = new TreeNode(nums[p]);
        root.left = helperRight(left, p-1);
        root.right = helperRight(p+1, right);
        return root;
    }

    //randdom
    private TreeNode helperRand(int left, int right) {
        if(left > right) return null;
        Random rand = new Random();

        int p = (left + right) / 2;
        if ((left + right) % 2 == 1) p += rand.nextInt(2);

        TreeNode root = new TreeNode(nums[p]);
        root.left = helperRand(left, p-1);
        root.right = helperRand(p+1, right);
        return root;
    }

    public static void printBinaryTree(TreeNode root, int level){
        if(root==null)
            return;
        printBinaryTree(root.right, level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++)
                System.out.print("|\t");
            System.out.println("|-------"+root.val);
        }
        else
            System.out.println(root.val);
        printBinaryTree(root.left, level+1);
    }

    public static void main(String[] args) {
        SortedArryToBST sol = new SortedArryToBST();
        TreeNode root = sol.sortedArrayToBST(new int[] {-10,-3,0,5,9});

        printBinaryTree(root, 0);
    }
}
