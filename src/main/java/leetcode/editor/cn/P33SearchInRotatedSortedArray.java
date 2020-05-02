//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找


package leetcode.editor.cn;

//Java：搜索旋转排序数组
public class P33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 3};
        Solution solution = new P33SearchInRotatedSortedArray().new Solution();
        int search = solution.search(nums, 3);
        System.out.println(search);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 三种情况
         * 1 旋转点在中间位置
         * - 直接获取中间位置索引，返回
         * 2 旋转点在中间偏左
         * - 在左半部分查找
         * 3 旋转点在中间偏右
         * - 在右半部分查找
         * <p>
         * 中间位置的值与左边界值比较
         * - 中间位置的数据较大，说明左半部分是递增的
         * -- 如果目标值在左半部分，则high=mid-1
         * -- 如果目标值不在左半部分，则low=mid+1
         * - 中间位置的数据较小，说明右半部分是递增的
         * -- 同上
         *
         * @param nums
         * @param target
         * @return
         */
        public int search(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            int mid = 0;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[low] <= nums[mid]) {
                    // [low, mid]区间是有序的
                    // [mid + 1, high] 存在target
                    if (nums[low] <= target && target <= nums[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else if (nums[mid] < nums[low]) {
                    if (nums[mid] <= target && target <= nums[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}