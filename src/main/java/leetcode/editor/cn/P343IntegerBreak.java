//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。 
//
// 示例 1: 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 说明: 你可以假设 n 不小于 2 且不大于 58。 
// Related Topics 数学 动态规划


package leetcode.editor.cn;

//Java：整数拆分
public class P343IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new P343IntegerBreak().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * https://leetcode-cn.com/problems/integer-break/solution/ba-yi-ba-zhe-chong-ti-de-wai-tao-343-zheng-shu-cha/
         *
         * @param n
         * @return
         */
        public int integerBreak(int n) {
            if (n <= 3) return n - 1;
            int[] dp = new int[n + 1];
            //初始化,1,2,3特殊处理
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 3;
            for (int i = 4; i <= n; i++) {
                for (int j = 1; j <= i / 2; j++) {
                    dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}