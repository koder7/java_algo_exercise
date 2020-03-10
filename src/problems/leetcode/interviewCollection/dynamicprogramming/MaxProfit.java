package problems.leetcode.interviewCollection.dynamicprogramming;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit)
                    maxProfit = profit;
            }
        }
        return maxProfit;
    }

//    Single pass
    public int maxProfitSinglePass(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if(minPrice > prices[i]) {
                minPrice = prices[i];
            } else {
                if(maxProfit < prices[i] - minPrice) {
                    maxProfit = prices[i] - minPrice;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit sol = new MaxProfit();
        System.out.println(sol.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(sol.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(sol.maxProfit(new int[]{2, 1, 2, 0, 1}));
        System.out.println(sol.maxProfit(new int[]{2, 1, 2, 1, 0, 1, 2}));
    }
}
