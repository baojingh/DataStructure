//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。 
//
// 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。 
// 示例 1:
// 给定 nums = [3,2,2,3], val = 3,
//函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
//
//你不需要考虑数组中超出新长度后面的元素。
// 示例 2:
//
// 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
//
//函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
//
//注意这五个元素可为任意顺序。
//
//你不需要考虑数组中超出新长度后面的元素。
// 说明:
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
//int len = removeElement(nums, val);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// Related Topics 数组 双指针


package leetcode.editor.cn;

import java.util.Arrays;

//Java：移除元素
public class P27RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        Solution solution = new P27RemoveElement().new Solution();
        int element = solution.removeElement(nums, 2);
        for (int i = 0; i < element; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 设计算法
         * 1 迭代数组元素，slow指针
         * 2 如果当前元素等于目标值，创建fast指针指向slow+1，判断是否也等于目标值
         * 3 如果等于目标值就fast继续前进一步;如果不等于目标值，就将fast的元素覆盖到slow位置
         * 4 slow与fast同时前进一步
         * 5 内层fast循环结束条件是fast与slow位置的元素不相等
         * 6 外层循环结束条件是slow或者fast到达数组最后
         *
         * 测试用例
         * 1 1,2,3 4
         * 2 1,1,2,3 1
         * 3 1,2,3,3 3
         * 4 1,1,1 1
         * 5 1,2,2,3,4 2
         * 解答失败: 测试用例:[0,1,2,2,3,0,4,2] 2 测试结果:[0,0,1,3,3,3,4] 期望结果:[0,1,4,0,3] stdout
         * 0,0,1,2,2,2,3,4
         * 0 1 2 3 4 5 6 7
         * @param val
         * @return
         */
        public int removeElement(int[] nums, int val) {
            Arrays.sort(nums);
            int fast = 0;
            int slow = 0;
            while (fast < nums.length) {
                if (nums[slow] == val) {
                    fast = slow + 1;
                    while (fast < nums.length && val == nums[fast]) {
                        // fast < nums.length 防止1，1，1的情况
                        fast = fast + 1;
                    }
                }
                if (fast >= nums.length) {
                    // 处理1，2，3，3 3的情况
                    return slow;
                }
                nums[slow] = nums[fast];
                slow = slow + 1;
                fast = fast + 1;
            }
            return slow;
        }




















        /**
         * 拷贝覆盖
         * 1 设置动态指针index=0，用于指向最终数组的下标。遍历数组，判断元素是否与目标元素相等
         * 2 如果不相等，就将nums[i]赋值给num[index++]
         * 3 如果相等，继续遍历，直到数组结束
         * 4 目标数组长度就是index
         * <p>
         * 时间复杂度O(n)，空间复杂度是O(1)
         *
         * @param nums
         * @param val
         * @return
         */
        public int removeElement_1(int[] nums, int val) {
            // 设置动态指针，指向非目标元素值
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                // 不是目标元素，就拷贝覆盖，同时移动动态指针指向下一个位置
                if (nums[i] != val) {
                    nums[index] = nums[i];
                    index = index + 1;
                }
                // 如果是目标元素，就跳过这个元素
            }
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}