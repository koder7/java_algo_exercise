package problems.leetcode.april.week1;

import java.util.HashSet;

class HappyNumber {
    public boolean isHappy(int n) {
        int squareSum = numberSquareSum(n);
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            set.add(squareSum);
            squareSum = numberSquareSum(squareSum);
            if(squareSum == 1) return true;
            else if(set.contains(squareSum)) return false;
        }
    }

    public int numberSquareSum(int n) {
        if(n == 0 || n==1) return n;
        int squareSum = 0;
        int remainder = n % 10;

        while(n != 0) {
            squareSum += remainder * remainder;
            n = n/10;
            remainder = n % 10;
        }
        return squareSum;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(3));
    }
}
