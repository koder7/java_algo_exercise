package problems.leetcode.interviewCollection;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit sol = new MaxProfit();
        System.out.println(sol.maxProfit(new int[]{7,6,4,3,1}));
    }
}
