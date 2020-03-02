package problems.leetcode.interviewCollection.string;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseInt {
    public int reverse(int x) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        boolean negative = false;
        if(x<0) {
            x = -x;
            negative = true;
        }
        while(x > 0) {
            arrayDeque.push(x%10);
            x = x/10;
        }
        double power = 0;
        double result = arrayDeque.isEmpty() ? 0 : arrayDeque.removeLast();
        while(!arrayDeque.isEmpty()) {
            result = result * 10 + arrayDeque.removeLast();
            if(result > Integer.MAX_VALUE) {
                return 0;
            }
            power++;
        }
        return negative ? -(int) result : (int) result;
    }

    //Even simpler solution from submission
    public int reverseSub(int x) {
        long res =0;

        while(x != 0){
            int m = x %10;
            res = Math.addExact(res *10, m);

            if(res > Integer.MAX_VALUE || res< Integer.MIN_VALUE){
                res = 0;
                break;
            }

            x = x/10;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        ReverseInt sol = new ReverseInt();
        System.out.println(sol.reverse(123));
        System.out.println(sol.reverse(0));
        System.out.println(sol.reverse(2147483647));
    }
}
