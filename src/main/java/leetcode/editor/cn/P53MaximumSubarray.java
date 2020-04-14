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
        int[] nums = new int[]{4,-1,3};
        Solution solution = new P53MaximumSubarray().new Solution();
        int sum = solution.maxSubArray(nums);
        System.out.println(sum);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1 sum是累加之和，ans是最大之和
         * 2 sum先进行累加，如果sum<0，对于累加无益，将当前值赋值给sum，从当前位置开始重新计算累加和；反之sum累加num[i]
         * 3 每次比较sum与ans，取出最大值
         * @param nums
         * @return
         */
        public int maxSubArray(int[] nums) {
            int sum = 0;
            // 存储最大值
            int ans = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (sum >= 0) {
                    sum = sum + nums[i];
                } else {
                    // 当前值对于结果无增益
                    sum = nums[i];
                }
                ans = Math.max(sum, ans);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}