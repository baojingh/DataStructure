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
        public int searchInsert(int[] nums, int target) {
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