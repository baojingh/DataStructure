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
         * 贪心算法
         * 1 遍历数组，获取到截止到当前位置的最小的值
         * 2 计算当前值与最小值得差值
         * 3 比较差值与最大利润，取最大值
         *
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int maxPro = 0;
            for (int i = 0; i < prices.length; i++) {
                if (minPrice > prices[i]) {
                    minPrice = prices[i];
                }
                maxPro = Math.max(maxPro, prices[i] - minPrice);
            }
            return maxPro;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}