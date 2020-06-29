//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划


package leetcode.editor.cn;

//Java：最佳买卖股票时机含冷冻期
public class P309BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new P309BestTimeToBuyAndSellStockWithCooldown().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 状态转换是i与i-2
         *
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1) {
                return 0;
            }
            int len = prices.length;
            int[][] dp = new int[len][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            // 第一天没有股票
            // 前一天没有
            // 前一天有，第一天卖出去
            dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);

            // 第一天有股票
            // 前一天有
            // 前一天没有，今天买
            dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);
            for (int i = 2; i < len; i++) {
                //今手里没有股票
                // 昨天没有，今天没有
                // 昨天有，今天卖
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

                //今手里有股票
                // 昨天有股票，今天继续持有股票
                // 昨天没有股票，今天买入股票
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }
            return dp[len - 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}