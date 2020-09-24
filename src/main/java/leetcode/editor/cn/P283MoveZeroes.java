//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
// 示例:
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
// 说明:
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。 
// Related Topics 数组 双指针


package leetcode.editor.cn;

import java.util.Arrays;

//Java：移动零
public class P283MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 1};
        Solution solution = new P283MoveZeroes().new Solution();
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 设想
         * 设计算法
         * <p>
         * 1 定义index字段，只想非0的元素
         * 2 如果i位置当前元素是0，则迭代继续
         * 3 如果i位置当前不是0，就将这个元素，移动到index的位置，并且index++
         * 4 迭代完成数组元素，从index位置到数组终点，填充为0
         *
         * 测试用例
         * 1 0,2,3
         * 1 0,2,0,3,0
         * 1 1,2,0,3,4,0,5
         * 2 1,2,3
         * 4 0
         * 5 0,0
         * 6 1,0,0
         * 7
         *
         * @param nums
         */
        public void moveZeroes(int[] nums) {
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[index] = nums[i];
                    index = index + 1;
                }
            }
            for (int i = index; i < nums.length; i++) {
                nums[i] = 0;
            }
        }


        public void moveZeroes1(int[] nums) {
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[index++] = nums[i];
                }
            }
            for (int i = index; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}