package problems.leetcode.interviewCollection.linkedlist;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        int n = 0;
        ListNode node = head;
        head = head.next;
        while(head != null) {
            if(node.val == head.val &&
                    node.next == head.next) {
                return true;
            }
            head = head.next;
            n++;
            if(n%10 == 7) {
                node = node.next;
            }
        }
        return false;
    }

    public boolean hasCycleSimple(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr.val == fastPtr.val &&
                    slowPtr.next == fastPtr.next)
                return true;
        }
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
        l4.next = l2;

        LinkedListCycle sol = new LinkedListCycle();
        System.out.println(sol.hasCycle(l1));
    }
}
