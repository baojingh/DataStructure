//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划


package leetcode.editor.cn;

import java.util.Arrays;

//Java：最长上升子序列
public class P300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new P300LongestIncreasingSubsequence().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         *
         * https://leetcode.cn/problems/longest-increasing-subsequence/solutions/24173/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
         *
         * 设计算法
         * 1 dp[i]代表以nums[i]结尾的子序列的最大长度
         * 2 dp[0]=1,以num[0]结尾的子序列即元素本身，最大长度是1
         * 3 例如：计算dp[5]，就需要计算dp[4]，即以4结尾的最大子序列长度
         * 4 dp中存储各个数字对应的最大递增序列长度，需要遍历数组，获取最大长度
         *
         *
         * @param nums
         * @return
         */
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            // dp[i]代表以nums[i]结尾的子序列的最大长度
            int len = nums.length;
            int[] dp = new int[len];
            // 数组初始化成1
            Arrays.fill(dp, 1);
            // 以num[0]结尾的子序列即元素本身，最大长度是1，
            dp[0] = 1;
            // 存储最大值
            int max = 0;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        // 计算比num[i]小的，这个需要遍历比num[i]小的数字
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            // 遍历dp获取最大值
            for (int i = 0; i < len; i++) {
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}