package DynamicProgramming;

public class buyandsellstocks {
    public static void main(String[] args) {
        System.out.println(max_profit(new int[]{7, 6, 4, 3, 2, 1}));
    }

    public static int max_profit(int[] prices) {
        int maxProfit = 0;
        int minprice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minprice = Math.min(minprice, prices[i]);
            int profit = prices[i] - minprice;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
