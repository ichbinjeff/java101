package Array;

/**
 * Created by shli15 on 12/3/16.
 */
public class StockI {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                min = Math.min(prices[j], min);
            }
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        StockI si = new StockI();
        int[] rst = new int[]{7,1,5,3,6,4};
        si.maxProfit(rst);
    }
}
