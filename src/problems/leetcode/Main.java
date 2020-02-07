package problems.leetcode;

public class Main {

    public static void main(String[] args) {
	// write your code her
//        GregorianCalendar gregorianCalendar = new GregorianCalendar(2018, 1, 1, 10, 15, 20);
//        Date date = gregorianCalendar.getTime();
//
//        DateFormat ffInstance = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
//
//        System.out.println(ffInstance.format(date));
//        System.out.println(DateFormat.getDateInstance(DateFormat.SHORT, Locale.CANADA).format(new Date()));


//        TestAddTwoNumbers();

        TestLongestSubString();

    }

    private static void TestAddTwoNumbers() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;

        AddTwoNumbers solution = new AddTwoNumbers();

        ListNode node = solution.addTwoNumbers(l4, l5);
        solution.printNode(node);

        /* This code fails if the numbers are out of java int range.
            Better solution is add numbers like you do on paper
         */

    }

    private static void TestLongestSubString() {
        String testString1 = "abcabcbb";
        String testString2 = "bbbbb";
        String testString3 = "pwwkew";
        String testString4 = "bpfbhmipx";
        LongestSubString solution = new LongestSubString();

//        System.out.println(solution.lengthOfLongestSubstring(testString1));
//        System.out.println(solution.lengthOfLongestSubstring(testString2));
//        System.out.println(solution.lengthOfLongestSubstring(testString3));
        System.out.println(solution.lengthOfLongestSubstring(testString4));
    }
}
