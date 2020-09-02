//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
// 你可以假设数组中无重复元素。
// 示例 1:
// 输入: [1,3,5,6], 5
//输出: 2
// 示例 2:
// 输入: [1,3,5,6], 2
//输出: 1
// 示例 3:
//输出: 4
// 示例 4:
// 输入: [1,3,5,6], 0
//输出: 0
// Related Topics 数组 二分查找

package leetcode.editor.cn;

//Java：搜索插入位置
public class P35SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        Solution solution = new P35SearchInsertPosition().new Solution();
        int i = solution.searchInsert(nums, 7);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 设计算法
         * 1 二分查找目标元素，如果找到了返回索引值
         * 2 同时使用两个变量存储最近两次的中间位置mid1,mid2
         * 3 没有找到就将目标值查到mid1,mid2中间位置
         *
         * 测试用例
         * 1 1,3,5,7 5
         * 1 1,3,5,7 1
         * 1 1,3,5,7 7
         * 2 1,3,5 0
         * 2 1,3,5 6
         * 2 1,3,5 4
         *
         * 或者归纳一下，可知返回的是low
         * 1,3,5,6 7
         * 1,3,5,6 0
         * 1,3,5,6 4
         *
         *
         * @param nums
         * @param target
         * @return
         */
        public int searchInsert(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            int mid = 0;

            while (low <= high) {
                mid = low + (high - low) / 2;
                if (nums[mid] < target) {
                    low = mid + 1;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
            // 运行到这里，说明没有找到目标值
            return low;
        }

















        public int searchInsert1(int[] nums, int target) {
            // 模版1，low是0；high是length
            int low = 0;
            int high = nums.length;
            // 模版2，low < high
            while (low < high) {
                // 注意溢出
                int mid = low + ((high - low) >> 1);
                if (nums[mid] > target) {
                    // 模板3
                    high = mid;
                } else if (nums[mid] < target) {
                    // 模板4
                    low = mid + 1;
                } else {
                    return mid;
                }
            }
            // 没有目标值，返回当前low的位置
            return low;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}