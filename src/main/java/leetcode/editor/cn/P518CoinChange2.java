//给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
// 示例 1:
// 输入: amount = 5, coins = [1, 2, 5]
//输出: 4
//解释: 有四种方式可以凑成总金额:
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 示例 2:
//
// 输入: amount = 3, coins = [2]
//输出: 0
//解释: 只用面额2的硬币不能凑成总金额3。
//
// 示例 3: 
//
// 输入: amount = 10, coins = [10] 
//输出: 1
// 0 <= amount (总金额) <= 5000 
// 1 <= coin (硬币面额) <= 5000 
// 硬币种类不超过 500 种 
// 结果符合 32 位符号整数


package leetcode.editor.cn;

//Java：零钱兑换 II
public class P518CoinChange2 {
    public static void main(String[] args) {
        Solution solution = new P518CoinChange2().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 状态方程：
         * 使用前i个硬币，凑出的金额是j，方案数量是dp[i][j]
         * dp[0][0]=0
         * dp[0][1] = 1
         * dp[1][0] = 0
         * <p>
         * 2020.07.10未搞定
         *
         * @param amount
         * @param coins
         * @return
         */
        public int change(int amount, int[] coins) {
            int len = coins.length;
            int[][] dp = new int[len + 1][amount + 1];
            for (int i = 0; i <= len; i++) {
                dp[i][0] = 1;
            }

            for (int i = 1; i <= len; i++) {
                for (int j = 1; j <= amount; j++) {
                    if (j - coins[i - 1] < 0) {
                        // 不将coins[i]放入，则
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        // 将coins[i]放入，则
                        // 前i个硬币，凑出的金额是j = 前i-1个硬币，凑出j + 前i个硬币，凑出的金额是
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                    }
                }
            }
            return dp[len][amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}