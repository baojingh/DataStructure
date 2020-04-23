//给定一个未经排序的整数数组，找到最长且连续的的递增序列。 
// 示例 1:
//输入: [1,3,5,4,7]
//输出: 3
//解释: 最长连续递增序列是 [1,3,5], 长度为3。
//尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。 
// 示例 2:
//输入: [2,2,2,2,2]
//输出: 1
//解释: 最长连续递增序列是 [2], 长度为1。
// 注意：数组长度不会超过10000。
// Related Topics 数组


package leetcode.editor.cn;

//Java：最长连续递增序列
public class P674LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        Solution solution = new P674LongestContinuousIncreasingSubsequence().new Solution();
        int length = solution.findLengthOfLCIS(nums);
        System.out.println(length);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            int max = 1;
            int count = 1;
            int len = nums.length;
            if (len < 1) {
                return 0;
            }
            for (int i = 1; i < len; i++) {
                if (nums[i - 1] < nums[i]) {
                    count = count + 1;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}