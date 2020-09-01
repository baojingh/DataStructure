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
        /**
         *
         * 测试用例
         *
         * 1,2 1
         * 1,2 2
         * 1 1
         * 1,1 1
         *
         * 1 1,2,3,4 6
         * 2 3,4,5 2
         * 3 1,2,3 1
         * 4 1,2,3 3
         * 5 1,1,1,2,3 1
         * 6 1,2,3,3,3 3
         * 7 1,2,3,3,4,4,5 4
         * 8 1,2,3,4 3
         *
         *
         *
         * @param nums
         * @param target
         * @return
         */
        public int[] searchRange(int[] nums, int target) {
            int[] arr = {-1, -1};
            int low = 0;
            int high = nums.length - 1;
            int res = -1;
            // 寻找左边界
            while (low <= high) {
                // 处理[1,2] 2的情况
                int mid = low + (high - low) / 2;
                if (nums[mid] < target) {
                    low = mid + 1;
                } else if (nums[mid] > target) {
                    high = high - 1;
                } else {
                    // 5，7，7，8，8 7的情况
                    // 保存上一个
                    res = high;
                    // 收缩左侧的
                    high = high - 1;
                }
            }
            arr[0] = res;
            low = 0;
            high = nums.length - 1;
            // 寻找右边界
            while (low <= high) {
                // 处理[1,2] 2的情况
                int mid = low + (high - low) / 2;
                if (nums[mid] < target) {
                    low = mid + 1;
                } else if (nums[mid] > target) {
                    high = high - 1;
                } else {
                    // 5，7，8，8，8 8的情况
                    // 保存上一个
                    res = low;
                    // 收缩左侧的
                    low = low + 1;
                }
            }
            arr[1] = res;
            return arr;
        }



















        public int[] searchRange1(int[] nums, int target) {
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