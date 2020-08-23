//给定两个数组，编写一个函数来计算它们的交集。 
//
// 示例 1: 
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2]
// 
//
// 示例 2: 
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [9,4] 
//
// 说明: 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;

//Java：两个数组的交集
public class P349IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 13};
        Solution solution = new P349IntersectionOfTwoArrays().new Solution();
        boolean res = solution.isExists(nums1, 2);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1 == null || nums2 == null) {
                return new int[0];
            }
            Arrays.sort(nums1);
            HashSet<Integer> list = new HashSet<>();
            for (int ele : nums2) {
                if (isExist(nums1, ele)) {
                    list.add(ele);
                }
            }
            int[] arr = new int[list.size()];
            int i = 0;
            for (int ele : list) {
                arr[i++] = ele;
            }
            list = null;
            return arr;
        }

        private boolean isExist(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            // "="可以处理[1,2], 2的情况
            while (low <= high) {
                int mid = low + ((high - low) / 2);
                if (nums[mid] < target) {
                    low = mid + 1;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
            return false;
        }


        /**
         * 对数组排序
         * 二分查找获取某个元素是否在数组内
         * 时间复杂度n*log(n)
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public int[] intersection_1(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < nums2.length; i++) {
                boolean exists = isExists(nums1, nums2[i]);
                if (exists) {
                    set.add(nums2[i]);
                }
            }
            int[] arr = new int[set.size()];
            int i = 0;
            for (int val : set) {
                arr[i] = val;
                i = i + 1;
            }
            return arr;
        }

        /**
         * 二分查找
         *
         * @param nums
         * @param target
         * @return
         */
        private boolean isExists(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            int mid = 0;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (nums[mid] > target) {
                    high = mid - 1;
                } else if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}