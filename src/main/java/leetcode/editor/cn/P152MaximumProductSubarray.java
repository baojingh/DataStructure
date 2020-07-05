//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
// Related Topics 数组 动态规划


package leetcode.editor.cn;

//Java：乘积最大子数组
public class P152MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new P152MaximumProductSubarray().new Solution();
        int i = solution.maxProduct(new int[]{2, 3, -2, 4});
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * https://leetcode-cn.com/problems/maximum-product-subarray/solution/duo-chong-si-lu-qiu-jie-by-powcai-3/
         * https://leetcode-cn.com/problems/maximum-product-subarray/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--36/
         * <p>
         * 设计算法：
         * https://leetcode-cn.com/problems/maximum-product-subarray/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--36/
         * 那么 dpMax[i] 的话有几种取值。
         * <p>
         * 当 nums[i] >= 0 并且dpMax[i-1] > 0，dpMax[i] = dpMax[i-1] * nums[i]
         * 当 nums[i] >= 0 并且dpMax[i-1] < 0，此时如果和前边的数累乘的话，会变成负数，所以dpMax[i] = nums[i]
         * 当 nums[i] < 0，此时如果前边累乘结果是一个很大的负数，和当前负数累乘的话就会变成一个更大的数。所以我们还需要一个数组 dpMin 来记录以第 i 个元素的结尾的子数组，乘积最小的值。
         * 当dpMin[i-1] < 0，dpMax[i] = dpMin[i-1] * nums[i]
         * 当dpMin[i-1] >= 0，dpMax[i] = nums[i]
         * 当然，上边引入了 dpMin 数组，怎么求 dpMin 其实和上边求 dpMax 的过程其实是一样的。
         * <p>
         * 按上边的分析，我们就需要加很多的 if else来判断不同的情况，这里可以用个技巧。
         * <p>
         * 我们注意到上边dpMax[i] 的取值无非就是三种，dpMax[i-1] * nums[i]、dpMin[i-1] * nums[i] 以及 nums[i]。
         * <p>
         * 所以我们更新的时候，无需去区分当前是哪种情况，只需要从三个取值中选一个最大的即可。
         *
         * @param nums
         * @return
         */
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int tmpMin = nums[0];
            int tmpMax = nums[0];
            int max = tmpMax;
            int min = tmpMax;
            int preMax = tmpMax;
            for (int i = 1; i < nums.length; i++) {
                //更新 dpMin 的时候需要 dpMax 之前的信息，所以先保存起来
                // 最小值有可能是最大值乘以当前的负值
                preMax = tmpMax;
                tmpMax = Math.max(Math.max(tmpMax * nums[i], nums[i]), tmpMin * nums[i]);
                tmpMin = Math.min(Math.min(preMax * nums[i], nums[i]), tmpMin * nums[i]);
                max = Math.max(tmpMax, max);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}