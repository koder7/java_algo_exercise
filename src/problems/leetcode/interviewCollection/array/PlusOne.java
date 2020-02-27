package problems.leetcode.interviewCollection.array;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry=0;
        for (int i = digits.length-1; i >= 0 ; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
                carry = 1;
            }
        }
        int[] result;
        if(carry == 1) {
            result = new int[digits.length+1];
            result[0] = 1;
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne sol = new PlusOne();
        System.out.println(Arrays.toString(sol.plusOne(new int[]{9,9,9})));
    }
}
