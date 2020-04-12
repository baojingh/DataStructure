//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找


package leetcode.editor.cn;

//Java：在排序数组中查找元素的第一个和最后一个位置
public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3};
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] ints = solution.searchRange(nums, 3);
        for (int num : ints) {
            System.out.print(num + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] arr = {-1, -1};
            int low = extremeInsertionIndex(nums, target);
            int high = extremeInsertionIndex(nums, target + 1);
            System.out.println(new StringBuffer().append("low:").append(low).append(",high:").append(high));
            // 为何要判断nums[low] != target
            if (low == nums.length || nums[low] != target) {
                return arr;
            }
            arr[0] = low;
            arr[1] = high - 1;
            return arr;
        }

        /**
         * target+1是找到第一个>=target+1的元素位置b，那么最后一个target的元素位置自然是b-1【因为数组全是整数】
         * 算是一种取巧 这样写是为了使用同一个逻辑的二分查找，而非写两个逻辑二分查找。
         * <p>
         * 本质查找第一个大于等于target的数组下标
         *
         * @param nums
         * @param target
         * @return
         */
        private int extremeInsertionIndex(int[] nums, int target) {
            int low = 0;
            int high = nums.length;
            while (low < high) {
                int mid = (low + ((high - low) >> 1));
                if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}