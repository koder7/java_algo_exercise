package problems.leetcode.interviewCollection.linkedlist;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int n = list.size();
        for (int start = 0, end = n-1; start < n / 2; start++, end--) {
            if (list.get(start).val != list.get(end).val) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        return false;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l5;
        l5.next = l3;
        l3.next = l4;

        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(5);

        l11.next = l12;

        PalindromeLinkedList sol = new PalindromeLinkedList();
        System.out.println(sol.isPalindrome(l1));
        System.out.println(sol.isPalindrome(l11));
    }


}
