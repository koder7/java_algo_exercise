package problems.leetcode.recursion;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead =  reverse(head, head.next);
        head.next = null;
        return newHead;
    }

    private ListNode reverse(ListNode node, ListNode nextNode) {
       if(nextNode.next == null) {
            nextNode.next = node;
            return nextNode;
        }
        ListNode next = nextNode.next;
        nextNode.next = node;
        return reverse(nextNode, next);
    }

    private static void printNode(ListNode listNode) {
        while (listNode.next != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = reverseLinkedList.reverseList(l1);
        ReverseLinkedList.printNode(head);
    }

    //quite compact
    public ListNode reverseListLeetCode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
