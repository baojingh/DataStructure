//给定一个未排序的整数数组，找到最长递增子序列的个数。 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。 
// Related Topics 动态规划


package leetcode.editor.cn;

//Java：最长递增子序列的个数
public class P673NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new P673NumberOfLongestIncreasingSubsequence().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解释题意
         * 1. dp[i]代表以nums[i]结尾的递增子序列的长度
         * 2. counter[i]代表以nums[i]结尾的最长递增子序列的组合个数
         * <p>
         * 2. 统计每个长度的个数，输出
         * <p>
         * <p>
         * 设计算法
         *
         * @param nums
         * @return
         */
        public int findNumberOfLIS(int[] nums) {

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}