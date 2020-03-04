package problems.leetcode.interviewCollection.linkedlist;

public class DeleteNode {
    public void deleteNode(ListNode node) {
        //Move the value from the next node to current and delete next node
        ListNode next = node.next;
        ListNode nextNext = (next.next != null) ? next.next :null;
        node.val = next.val;
        node.next = nextNext;
        next.next = null;
    }

    private static void printNode(ListNode listNode) {
        while (listNode.next != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(9);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(5);

        l11.next = l12;


        DeleteNode sol = new DeleteNode();
        sol.deleteNode(l2);
        printNode(l1);

        sol.deleteNode(l11);
        printNode(l12);
    }



}
