public class BestTimeToBuyAndSellStockIV {
    public static void main(String args[]) {

    }

    public static int maxProfit(int K, int[] prices) {
        int result = 0;
        memo = new int[2][3][prices.length];
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < prices.length; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }

        result = cal(prices, K, 0, false);
        return result;
    }

    static int memo[][][];
    public static int cal(int[] prices, int t, int pos, boolean buy) {
        if (pos >= prices.length || t == 0) return 0;

        if (memo[buy ? 1 : 0][t][pos] != -1) return memo[buy ? 1 : 0][t][pos];

        int result = cal(prices, t, pos + 1, buy);
        if (buy) {
            result = Math.max(result, cal(prices, t-1, pos + 1, false) + prices[pos]);
        } else {
            result = Math.max(result, cal(prices, t, pos + 1, true) - prices[pos]);
        }
        return memo[buy ? 1 : 0][t][pos] = result;
    }
}
