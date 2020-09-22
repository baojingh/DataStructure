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
         * 设计算法
         * 定理：
         * 1 一个数字经过两次相同的异或操作，会得到原数字，例如2^3^3 = 2
         * 2 异或满足结合律，交换律
         * 3 两个相同的数异或，得到0
         * 4 一个数字和0异或，得到原数字
         * <p>
         * 本题目可以利用数组元素及其下标
         * 迭代数组每个元素，讲元素与其索引累计异或，最终得到的是缺失的那个数字
         * https://leetcode-cn.com/problems/missing-number/solution/que-shi-shu-zi-by-leetcode/
         *
         * <p>
         * 测试用例
         * 1 0
         * 2 1,2
         * 3 1,0
         * 4 1,0,3
         *
         * @param nums 1
         * @return 1
         */
        public int missingNumber(int[] nums) {
            int res = nums.length;

            for (int i = 0; i < nums.length; i++) {
                res = res ^ (i ^ nums[i]);
            }
            return res;
        }















        /**
         * 隐含条件：序列中只缺失一个数字
         *
         * @param nums
         * @return
         */
        public int missingNumber1(int[] nums) {
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