package problems.leetcode.recursion;

public class MatchPow {
    //Mine is throwing SO error for large n
    public double myPow(double x, int n) {
        if (n > 0) {
            if (n == 1) return 1;
            return x * myPow(x, --n);
        } else {
            if (n == -1) return 1;
            return x / myPow(x, ++n);
        }
    }

    //fast power recursive O(log n) time and space complexity
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPowFast(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    //    same iterative with O(log n) time and O(1) space
    public double myPowFastIterative(double x, int n) {
        if( n == 0)
            return 1.00;
        long N = n;
        if(N < 0) {
            x = 1/x;
            N = -N;
        }
        double ans = x;
        double cunrentproduct = x;
        for(long i = N; i > 0; i /= 2) {
            if(N % 2 == 0) {
                ans = ans * x;
            }
            cunrentproduct = cunrentproduct * cunrentproduct;
        }
        return ans;
    }
}
