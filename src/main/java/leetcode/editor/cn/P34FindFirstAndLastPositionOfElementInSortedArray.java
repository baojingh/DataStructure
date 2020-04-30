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
        int[] nums = new int[]{2};
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] ints = solution.searchRange(nums, 3);
        for (int num : ints) {
            System.out.print(num + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length < 1) {
                return new int[]{-1, -1};
            }
            int left = leftBound(nums, target);
            int right = rightBound(nums, target);
            int[] arr = new int[]{left, right};
            return arr;
        }

        /**
         * 寻找左边界，即使找到了目标值，也要判断一下是否是最左边的值或者左边的值
         *
         * @param nums
         * @param target
         * @return
         */
        private int leftBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int mid = 0;
            int res = -1;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    res = mid;
                    right = mid - 1;
                }
            }
            return res;
        }

        private int rightBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int mid = 0;
            int res = -1;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    res = mid;
                    left = mid + 1;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}