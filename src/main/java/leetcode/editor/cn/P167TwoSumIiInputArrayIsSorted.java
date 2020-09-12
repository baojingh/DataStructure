//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。 
//
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。 
//
// 说明: 
//
// 
// 返回的下标值（index1 和 index2）不是从零开始的。 
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 
// 
//
// 示例: 
//
// 输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。 
// Related Topics 数组 双指针 二分查找


package leetcode.editor.cn;

//Java：两数之和 II - 输入有序数组
public class P167TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7, 8};
        Solution solution = new P167TwoSumIiInputArrayIsSorted().new Solution();
        int[] ints = solution.twoSum(nums, 108);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 设计算法
         * 1 数组已经排序，设置前后指针low=0，high=nums.length-1
         * 2 计算两个指针之和是否是目标值，如果是则返回
         * 3 如果和大于target，说明high左移可以让和变小（数组有序），high左移
         * 4 如果和小于target，说明low右移可以让和变大（数组有序），low右移
         * 5 循环存在条件是low < high
         * 6 返回low+1,high+1
         *
         *
         * 测试用例
         * 1,3,5,7,10 10
         * 2 1,3,4,5,6 4
         * 3 1 2
         * 4 1 1
         * 5 1,3,5,7,9 20
         * 6 7,9,13,16,18 2
         * 7 1,2 3
         * 8 3,5 2
         * 9 3,5 9
         *
         *
         * @param numbers
         * @param target
         * @return
         */
        public int[] twoSum(int[] numbers, int target) {
            return null;
        }


        public int[] twoSum1(int[] numbers, int target) {
            int[] indexArray = new int[2];
            int len = numbers.length;
            int low = 0;
            int high = len - 1;
            for (int i = 0; i < len; i++) {
                int sum = numbers[low] + numbers[high];
                if (sum > target) {
                    high = high - 1;
                } else if (sum < target) {
                    low = low + 1;
                } else {
                    indexArray[0] = low + 1;
                    indexArray[1] = high + 1;
                }
            }
            return indexArray;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}