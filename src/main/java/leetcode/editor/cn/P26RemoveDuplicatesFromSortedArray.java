//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。 
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
// 示例 1:
// 给定数组 nums = [1,1,2],
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
//你不需要考虑数组中超出新长度后面的元素。
// 示例 2:
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//你不需要考虑数组中超出新长度后面的元素。
// 说明: 
// 为什么返回数值是整数，但输出的答案是数组呢?
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
// 你可以想象内部操作如下:
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// Related Topics 数组 双指针
package leetcode.editor.cn;

//Java：删除排序数组中的重复项
public class P26RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        Solution solution = new P26RemoveDuplicatesFromSortedArray().new Solution();
        int i = solution.removeDuplicates(nums);
        System.out.println(i);
        for (int j = 0; j < i; j++) {
            System.out.print(nums[j] + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 设计算法
         * 1 快慢指针slow，fast分别指向0，1位置元素
         * 2 fast与slow是否相等
         * 相等，fast前进，过滤掉相等元素
         * 不相等，fast指向的元素移动到slow+1位置，slow与fast同时前进一步
         * slow所在位置就是新数组的索引，新数组长度是slow+1
         * 3 循环结束条件是fast到达数组尾部
         *
         * @param nums
         * @return
         */
        public int removeDuplicates(int[] nums) {
            int slow = 0;
            for (int fast = 1; fast < nums.length;) {
                if (nums[slow] == nums[fast]) {
                    fast = fast + 1;
                } else {
                    nums[slow + 1] = nums[fast];
                    // 两个指针同时前进一步
                    fast = fast + 1;
                    slow = slow + 1;
                }
            }
            return slow + 1;
        }









































        /**
         * 快慢指针
         * 快指针与慢指针比较是否相等，相等快指针就向前移动，
         *
         * @param nums
         * @return
         */
        public int removeDuplicates_1(int[] nums) {
            int slow = 0;
            int fast = 1;
            while (fast < nums.length) {
                if (nums[fast] == nums[slow]) {
                    // 如果快慢指针对应的值相等，快指针可向前进，过滤掉重复的值
                    // 当快慢指针对应的值不等时，将第一个不相登的值赋给慢指针的下一个位置，
                    fast = fast + 1;
                } else {
                    // 如果没有会重复元素，fast与slow始终相差1，则此处赋值是自己给自己赋值
                    nums[slow + 1] = nums[fast];
                    // 快慢指针向前一步
                    slow = slow + 1;
                    fast = fast + 1;
                }
            }
            int len = slow + 1;
            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}