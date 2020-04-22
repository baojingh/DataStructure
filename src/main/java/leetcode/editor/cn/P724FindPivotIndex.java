//给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。 
//
// 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。 
//
// 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。 
// 示例 1:
//输入:
//nums = [1, 7, 3, 6, 5, 6]
//输出: 3
//解释: 
//索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
//同时, 3 也是第一个符合要求的中心索引。
// 示例 2:
//输入:
//nums = [1, 2, 3]
//输出: -1
//解释: 
//数组中不存在满足此条件的中心索引。 
//
// 说明: 
// nums 的长度范围为 [0, 10000]。
// 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。 
// 
// Related Topics 数组


package leetcode.editor.cn;

//Java：寻找数组的中心索引
public class P724FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, -1, -1, 0, 1, 1};
        Solution solution = new P724FindPivotIndex().new Solution();
        int index = solution.pivotIndex(nums);
        System.out.println(index);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 左+右 + 中间 = 总和
         * 演变成2*左+中间= 总和
         * 找出一个num[i],使得2*left + num[i+1] = sum即可
         *
         * @param nums
         * @return
         */
        public int pivotIndex(int[] nums) {
            int len = nums.length;
            int sum = 0;
            int left = 0;
            for (int i = 0; i < len; i++) {
                sum = sum + nums[i];
            }
            for (int i = 0; i < len; i++) {
                if (2 * left + nums[i] == sum) {
                    return i;
                }
                left = left + nums[i];
            }
            return -1;


            /**
             * 本方法bug：如果输入的是[-1, -1, -1, -1, -1, 0]，则不能正确处理，需要添加判断正负数的功能，复杂度提高了

             int len = nums.length;
             if (len <= 2) {
             return -1;
             }
             int left = nums[0];
             int right = nums[len - 1];
             int leftIndex = 1;
             int rightIndex = len - 2;
             while (leftIndex <= rightIndex) {
             if (left > right) {
             right = right + nums[rightIndex];
             rightIndex = rightIndex - 1;
             } else if (left < right) {
             left = left + nums[leftIndex];
             leftIndex = leftIndex + 1;
             } else {
             if (leftIndex == rightIndex) {
             return leftIndex;
             }
             rightIndex = rightIndex - 1;
             leftIndex = leftIndex + 1;
             }
             }
             return -1;
             */
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}