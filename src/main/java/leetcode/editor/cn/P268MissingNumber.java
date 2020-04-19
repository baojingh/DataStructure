//给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。 
// 示例 1:
// 输入: [3,0,1]
//输出: 2
// 示例 2:
// 输入: [9,6,4,2,3,5,7,0,1]
//输出: 8
// 说明:
//你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现? 
// Related Topics 位运算 数组 数学


package leetcode.editor.cn;


import java.util.HashSet;

//Java：缺失数字
public class P268MissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 2, 1};
        Solution solution = new P268MissingNumber().new Solution();
        int number = solution.missingNumber(nums);
        System.out.println(number);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 隐含条件：序列中只缺失一个数字
         *
         * @param nums
         * @return
         */
        public int missingNumber(int[] nums) {
            HashSet<Integer> set = new HashSet<Integer>();
            // 原有数字放入集合中
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }
            // 仅仅缺失一个数字
            for (int i = 0; i < nums.length + 1; i++) {
                if (!set.contains(i)) {
                    return i;
                }
            }
            return -1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}