package com.company;

import java.util.List;

public class SwapNodePairs {

    public ListNode swapPairs(ListNode head) {
        return swap(head, head.next, null);
    }

    private ListNode swap(ListNode node, ListNode nextNode, ListNode prevNode) {
        ListNode head = node.next;
        ListNode temp = nextNode.next;
        if(prevNode != null) {
            prevNode.next = nextNode;
        }
        nextNode.next = node;
        node.next = temp;
        if(node.next != null) {
            swap(temp, temp.next, node);
        }
        return head;
    }

    private static void printNode(ListNode listNode) {
        while (listNode.next != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
    }

    public ListNode swapPairsLeetCode(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next  = swapPairsLeetCode(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        SwapNodePairs swapNodePairs = new SwapNodePairs();

        ListNode head = swapNodePairs.swapPairs(l1);

        SwapNodePairs.printNode(head);
    }
}
