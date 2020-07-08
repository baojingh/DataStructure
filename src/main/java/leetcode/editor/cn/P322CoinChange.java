//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
// 如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划


package leetcode.editor.cn;

import java.util.Arrays;

//Java：零钱兑换
public class P322CoinChange {
    public static void main(String[] args) {
        Solution solution = new P322CoinChange().new Solution();
        int change = solution.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(change);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-ming-zhi-shan-you-m9rfkv/
         *
         * @param coins
         * @param amount
         * @return
         */
        public int coinChange(int[] coins, int amount) {
            // 类似下面的解法
            return 0;
        }

        /**
         * {1,2,5}, 11
         * dp[11] = min(dp[1], dp[2],dp[5])
         * <p>
         * <p>
         * dp[i]: 凑齐总和是i的最少硬币个数
         * dp[i] = Math.min(dp[amount - coin[i]]+1, dp[amount - coin[i]]+1, dp[amount - coin[i]]+1)
         * <p>
         * <p>
         * for(int coin:coins)
         * {
         * if(coin <= amount)
         * dp[amount] = min(dp[amount-coin] + 1);
         * }
         * <p>
         * https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-shi-yong-wan-quan-bei-bao-wen-ti-/
         *
         * @param coins
         * @param amount
         * @return
         */
        public int coinChange_1(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            // 计算个数的最小值，需要
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            // 根据状态方程
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            if (dp[amount] == Integer.MAX_VALUE) {
                // 如果[2], 3，没有合适的硬币，就返回-1
                dp[amount] = -1;
                System.out.println(dp[amount]);
            }
            return dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}