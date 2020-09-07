//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组


package leetcode.editor.cn;

import java.util.ArrayList;

//Java：加一
public class P66PlusOne {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Solution solution = new P66PlusOne().new Solution();
        int[] ints = solution.plusOne(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 优化
         * 0 迭代数组
         * 1 获取数值并且加一
         *      如果之和等于10，说明这个原数字是9，应该将这一位变成，放心：下一次的循环会直接digits[i] = digits[i] + 1;
         *      如果之和不扽与10，说明没有进位，就可以直接返回当前的结果
         * 2 继续迭代
         * 3 数组迭代完成，说明最高位还有进位，创建新数组保存
         * <p>
         * 测试用例
         * 0 1
         * 1 1,9
         * 2 1,2
         * 3 8,9,9
         * 4 9,9,9
         *
         * @param digits
         * @return
         */
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >-1 ; i--) {
                digits[i] = digits[i] + 1;
                if (digits[i] == 10) {
                    digits[i] = 0;
                } else {
                    return digits;
                }
            }
            int[] arr = new int[digits.length + 1];
            arr[0] = 1;
            return arr;

        }


        /**
         * 设计算法
         * 0 创建ArrayList，存储结果的每一位
         * 1 循环累加
         * 2 获取数组的最后一位，加一，获取进位
         * 3 下一位，不需要累加，做特殊判断，加上进位，获取新的进位
         * 4 迭代完数组
         * 4 判断进位是否是1，如果是1，还需要在首位加上1。
         * 5 将列表转换成数组
         * <p>
         * 优化
         * 0 迭代数组
         * 1 获取个位数加一，将结果保存入原位置，变量保存进位
         * 2 继续迭代
         * 3 迭代结束条件是进位是0
         *
         *
         *
         *
         *
         * <p>
         * 测试用例
         * 0 1
         * 1 1,9
         * 2 1,2
         * 3 8,9,9
         * 4 9,9,9
         *
         * @param digits
         * @return
         */
        public int[] plusOne3(int[] digits) {
            ArrayList<Integer> list = new ArrayList<>();
            int carry = 0;
            for (int i = digits.length - 1; i > -1; i--) {
                int sum = 0;
                if (i == digits.length - 1) {
                    // 第一次计算的是末尾，加一，
                    sum = digits[i] + 1 + carry;
                } else {
                    // 不是第一次了，计算的是加上进位
                    sum = digits[i] + carry;
                }
                carry = sum / 10;
                sum = sum % 10;
                // 保持高位在前，低位在后
                list.add(0, sum);
            }
            if (carry == 1) {
                // 处理999这样的情况
                list.add(0, carry);
            }
            // 列表转换成数组
            int[] arr = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }
            return arr;
        }


        /**
         * 1 没有进位情况，例如1，2，3
         * 2 中间有进位，119，199
         * 3 最高位有进位， 999，99，需要扩充数组
         *
         * @param digits
         * @return
         */
        public int[] plusOne2(int[] digits) {
            int len = digits.length;
            for (int i = len - 1; i >= 0; i--) {
                digits[i] = digits[i] + 1;
                // 取余数
                digits[i] = digits[i] % 10;
                if (digits[i] != 0) {
                    // 应对1，2，3这种情况
                    return digits;
                }
            }
            // 如是99，则后两位是00，还有一个1，需要创建一个新的数组长度是3。
            // 新数组创建成功后，默认的是填充是0，0，0
            // 因此只需要在arr[0]= 1，后两位是0，0
            int[] arr = new int[len + 1];
            arr[0] = 1;
            return arr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}