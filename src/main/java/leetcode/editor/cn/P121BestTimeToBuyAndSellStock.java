//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 
//
// 注意：你不能在买入股票前卖出股票。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划


package leetcode.editor.cn;

//Java：买卖股票的最佳时机
public class P121BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0};
        Solution solution = new P121BestTimeToBuyAndSellStock().new Solution();
        int maxProfit = solution.maxProfit(nums);
        System.out.println(maxProfit);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/gu-piao-wen-ti-python3-c-by-z1m/
         * <p>
         * 状态方程：
         *
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int max = 0;
            int len = prices.length;
            // dp[i]代表第i天的最大利润
            int[] dp = new int[len];
            int min = prices[0];
            for (int i = 1; i < len; i++) {
                // 统计数组中的最小值
                min = Math.min(min, prices[i]);
                // 当天的利润，存入数组
                dp[i] = prices[i] - min;
            }

            // dp中存储的是天对应的利润，在数组中找到最大值
            for (int i = 0; i < dp.length; i++) {
                max = Math.max(dp[i], max);
            }
            return max;
        }


        /**
         * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/solutions/1692872/by-jyd-cu90/
         * @param prices
         * @return
         */
        public int maxProfit_2(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int len = prices.length;
            // dp[i]代表前i天的最大利润
            int[] dp = new int[len];
            int min = prices[0];
            for (int i = 1; i < len; i++) {
                min = Math.min(min, prices[i]);
                // 最大利润=（当天的价格-最低值）或者是前一天的利润，取最大值
                dp[i] = Math.max(dp[i - 1], prices[i] - min);
            }
            return dp[len - 1];
        }

        /**
         * 状态方程：
         *
         * @param prices
         * @return
         */
        public int maxProfit_1(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int len = prices.length;
            int max = 0;
            int gap = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    gap = prices[j] - prices[i];
                    if (gap > 0) {
                        max = Math.max(max, gap);
                    }
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}