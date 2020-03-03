package problems.leetcode.interviewCollection.string;

import java.util.ArrayDeque;
import java.util.Stack;

public class AtoI {
    public int myAtoi(String str) {
        int n = str.length();
        if (n == 0) return 0;

        int index = 0;
        boolean negative = false;
        //Ignore initial whitespace
        while (index < n && str.charAt(index) == ' ') {
            index++;
        }

        if (index >= n || (!isNumeric(str.charAt(index)) && str.charAt(index) != '-' && str.charAt(index) != '+')) return 0;

        if (str.charAt(index) == '-') {
            negative = true;
            index++;
        } else if(str.charAt((index)) == '+') {
            index++;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        //convert string to int

        while (index < n && isNumeric(str.charAt(index))) {
            Character c = str.charAt(index);
            stack.push(toInt(c));
            index++;
        }

        long result = 0;
        while (!stack.isEmpty()) {
            result = result * 10 + stack.removeLast();
            if (negative) {
                if (result > (long) Integer.MAX_VALUE + 1) return Integer.MIN_VALUE;
            } else {
                if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }
        }


        return (negative) ? - (int) result : (int) result;
    }

    private boolean isNumeric(char c) {
        if ((c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }

    private int toInt(char c) {
        switch (c) {
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        AtoI sol = new AtoI();

        System.out.println(sol.myAtoi("9223372036854775808"));
        System.out.println(sol.myAtoi(" "));
        System.out.println(sol.myAtoi("42"));
        System.out.println(sol.myAtoi("   -42"));
        System.out.println(sol.myAtoi("4193 with words"));
        System.out.println(sol.myAtoi("words and 987"));
        System.out.println(sol.myAtoi("-91283472332"));
    }
}
