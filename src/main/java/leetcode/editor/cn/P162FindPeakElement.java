//峰值元素是指其值大于左右相邻值的元素。 
//
// 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。 
//
// 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。 
//
// 你可以假设 nums[-1] = nums[n] = -∞。 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1]
//输出: 2
//解释: 3 是峰值元素，你的函数应该返回其索引 2。 
//
// 示例 2: 
//
// 输入: nums = [1,2,1,3,5,6,4]
//输出: 1 或 5 
//解释: 你的函数可以返回索引 1，其峰值元素为 2；
//     或者返回索引 5， 其峰值元素为 6。
// 
//
// 说明: 
//
// 你的解法应该是 O(logN) 时间复杂度的。 
// Related Topics 数组 二分查找


package leetcode.editor.cn;

//Java：寻找峰值
public class P162FindPeakElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        Solution solution = new P162FindPeakElement().new Solution();
        int peakElement = solution.findPeakElement(nums);
        System.out.println(peakElement);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 设计算法
         * 1 基于二分查找思想，获取数组中间节点mid
         * 2 num[mid] < num[mid+1] 升序，峰值在右侧，low = mid+1
         * 3 num[mid] > num[mid+1] 这部分是降序，峰值在左侧 high = mid - 1
         * 4 最终可以返回low/high索引
         *
         *
         *
         * 测试用例
         * 1 1,2,3,1
         * 2 1,2,3
         * 3 3,2,1
         * 4 1,2,3,4,3,4,3,2,1
         * 5 1
         * 6 []
         * 1,1,1,1
         *
         *
         *
         * @param nums
         * @return
         */
        public int findPeakElement(int[] nums) {

            int low = 0;
            int high = nums.length - 1;
            while (low < high) {
                // 不能是"="，无法处理[1]以及[1,2]的情况
                int mid = low + (high - low) / 2;
                if (nums[mid] < nums[mid + 1]) {
                    low = mid + 1;
                } else if (nums[mid] > nums[mid + 1]) {
                    high = mid;
                }
                // 不会出现相邻元素相等的情况
            }
            return low;
        }





















        /**
         * 1 找到序列中点位置
         * 2 如果中点元素<下一个元素，峰值在右侧，low=mid+1，有可能mid+1位置就是峰值点
         * 3 如果中点元素>下一个元素，峰值在左侧，high=mid，有可能mid位置就是峰值点
         * 4 low==high代表找到峰值点，注意while条件中没有"="
         * <p>
         * 局限性
         * 只能找到随机的峰值，无法找到所有的峰值
         *
         * @param nums
         * @return
         */
        public int findPeakElement1(int[] nums) {
            if (nums.length < 1) {
                return -1;
            }
            int low = 0;
            int high = nums.length - 1;
            int mid = 0;
            // 相等表示找到峰值点
            while (low < high) {
                mid = low + (high - low) / 2;
                if (nums[mid] < nums[mid + 1]) {
                    // 递增序列，峰值在右边
                    low = mid + 1;
                } else if (nums[mid] > nums[mid + 1]) {
                    // 峰值在左边
                    high = mid;
                }
            }
            return low;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}