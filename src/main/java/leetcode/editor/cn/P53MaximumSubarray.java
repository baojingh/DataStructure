//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划


package leetcode.editor.cn;

//Java：最大子序和
public class P53MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2};
        Solution solution = new P53MaximumSubarray().new Solution();
        int sum = solution.maxSubArray(nums);
        System.out.println(sum);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 设计算法
         * 1 dp[i]的长度等同于原数组长度，记录以原数组索引i以及之前的连续数组之和最大值
         * 2 初始值是num[0]表示索引0以及之前的连续之和的最大值是nums[0]
         * 3 迭代开始位置是1
         * 4 如果dp[i-1]是负值，说明之前的先保存起来，要从nums[i]开始从新计算
         * 5 如果dp[i-1]是正值，说明nums[i-1]有增益，就做累加
         * 6 计算dp中的最大值
         *
         *
         *
         * @param nums
         * @return
         */
        public int maxSubArray(int[] nums) {
            // 以i结尾的序列中，连续数组的最大和
            int[] dp = new int[nums.length];
            // 初始值
            dp[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (dp[i - 1] < 0) {
                    // 如果前一个元素是负数，对连续数组和没有增益，就舍弃，从当前元素重新开始
                    dp[i] = nums[i];
                } else {
                    // 如果前一个元素是整数，对连续数组和有增益，可以将当前值累加起来
                    dp[i] = dp[i - 1] + nums[i];
                }
            }
            for (int num : dp) {
                max = Math.max(max, num);
            }
            return max;
        }


        /**
         * https://leetcode-cn.com/problems/maximum-subarray/solution/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/
         *
         * @param nums
         * @return
         */
        public int maxSubArray1(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int subMax = nums[0];
            int max = nums[0];
            int len = nums.length;
            for (int i = 1; i < len; i++) {
                if (subMax > 0) {
                    subMax = subMax + nums[i];
                } else {
                    subMax = nums[i];
                }
                max = Math.max(max, subMax);
            }
            return max;
        }


        /**
         * @param nums
         * @return
         */
        public int maxSubArray_arr(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int len = nums.length;
            int[] dp = new int[len];
            dp[0] = nums[0];
            for (int i = 1; i < len; i++) {
                if (dp[i - 1] > 0) {
                    dp[i] = dp[i - 1] + nums[i];
                } else {
                    dp[i] = nums[i];
                }
            }

            int max = dp[0];
            for (int i = 0; i < dp.length; i++) {
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}