//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 3 * 10 ^ 4 
// 0 <= prices[i] <= 10 ^ 4 
// 
// Related Topics 贪心算法 数组


package leetcode.editor.cn;

//Java：买卖股票的最佳时机 II
public class P122BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        Solution solution = new P122BestTimeToBuyAndSellStockIi().new Solution();
        int profit = solution.maxProfit(nums);
        System.out.println(profit);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/
         *
         * @param nums
         * @return
         */
        public int maxProfit(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int len = nums.length;
            // dp[i][j]代表第i天，状态j即持有现金(0)，还是买入股票(1)
            int[][] dp = new int[len][2];
            // 第1天，先买股票，收益为负数
            dp[0][0] = 0;
            dp[0][1] = -nums[0];
            for (int i = 1; i < len; i++) {
                // 持有现金即没有买股票时，最大收益
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i]);
                // 未持有现金即持有股票时，最大收益
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - nums[i]);
            }
            return dp[len - 1][0];

        }


        /**
         * 1 股票趋势上涨，第一天买入，最后一天卖出，就可以获得最大利润
         * 2 股票趋势下降，不买入
         * 时间复杂度O(n)，空间复杂度O(1)
         * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
         * solution/best-time-to-buy-and-sell-stock-ii-zhuan-hua-fa-ji/
         *
         * @param nums
         * @return
         */
        public int maxProfit_1(int[] nums) {
            int profit = 0;
            for (int i = 1; i < nums.length; i++) {
                // 贪心算法
                // 第二天的价格减去前一天的价格，如果差值为负，说明不能买入；如果是正值，可以进行利润累加
                int tmp = nums[i] - nums[i - 1];
                if (tmp > 0) {
                    profit = profit + tmp;
                }
                // 差值为负，跳过
            }
            return profit;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}