package problems.leetcode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int number1 = generateNumber(l1);
        int number2 = generateNumber(l2);

//            System.out.println("Total is " + String.valueOf(number1 + number2));

        return generateList(number1+number2);
    }

    private int generateNumber(ListNode listNode) {
        int index = 0;
        int number = 0;
        while (listNode != null) {
            number += Math.pow(10, index) * listNode.val;
            listNode = listNode.next;
            index++;
        }
        return number;
    }

    private ListNode generateList(int number) {
        ListNode prevNode = null;
        ListNode node = new ListNode(0);
        while (number > 0) {
            int nextDigit = number % 10;
            number = number / 10;

            if (prevNode != null) {
                ListNode nextNode = new ListNode(nextDigit);
                prevNode.next = nextNode;
                prevNode = nextNode;
            } else {
                node.val = nextDigit;
                prevNode = node;
            }
        }
        return node;
    }

    public void printNode(ListNode listNode) {
        while (listNode.next != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
    }

}

