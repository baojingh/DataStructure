//给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 
//的 min(ai, bi) 总和最大。 
//
// 示例 1: 
//
// 
//输入: [1,4,3,2]
//
//输出: 4
//解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
// 
//
// 提示: 
//
// 
// n 是正整数,范围在 [1, 10000]. 
// 数组中的元素范围在 [-10000, 10000]. 
// 
// Related Topics 数组


package leetcode.editor.cn;

import java.util.Arrays;

//Java：数组拆分 I
public class P561ArrayPartitionI {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1,2};
        Solution solution = new P561ArrayPartitionI().new Solution();
        int sum = solution.arrayPairSum(nums);
        System.out.println(sum);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 田忌赛马：
         * 第一大与第一小组合，第二大与第二小组合，例如1，2，3，4，5，6，变成1 6，2 5，3 4，总和1+2+3
         * 第一大与第二大组合，第三大与第四大组合，这样得到的是1+3+5
         *
         * @param nums
         * @return
         */
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length; i = i + 2) {
                sum = sum + nums[i];
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}