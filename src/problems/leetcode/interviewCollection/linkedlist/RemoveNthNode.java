package problems.leetcode.interviewCollection.linkedlist;

import java.util.List;
import java.util.Stack;

public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        if(head.next == null) return null;

        ListNode node = head;
        Stack<ListNode> stack = new Stack<>();
        while(node != null) {
            stack.push(node);
            node = node.next;
        }

        while(!stack.isEmpty() && n > 1) {
            stack.pop();
            n--;
        }

        ListNode t = stack.pop();
        if(t.next != null) {
            t.val = t.next.val;
            t.next = t.next.next;
        } else {
            t = stack.pop();
            t.next = null;
        }
        return head;
    }

    //Count and traverse --faster than mine
    public ListNode removeNthFromEndCountandTraverse(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length  = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
    //Single pass -- uses two pointers spaced n nodes apart -- second pointer ends up at the right place
    public ListNode removeNthFromEndSinglePass(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    private static void printNode(ListNode listNode) {
        while (listNode != null) {
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

        RemoveNthNode sol = new RemoveNthNode();
//        sol.removeNthFromEnd(l1, 2);
//        printNode(l1);

        sol.removeNthFromEnd(l11, 1);
        printNode(l11);

        sol.removeNthFromEnd(l11, 1);
        printNode(l11);
    }

}
