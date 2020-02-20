package problems.leetcode.recursionToIteration;

public class TreeToDoublyLinkedList {
    Node first;
    Node last;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        helper(root);
        first.left = last;
        last.right = first;
        return first;
    }

    private void helper(Node node) {

        if(node != null) {
            helper(node.left);
            if(first != null) {
                last.right = node;
                node.left = last;
            } else {
                first = node;
            }
            last = node;
            helper(node.right);
        }
    }
}
