//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1143 👎 0


package leetcode.editor.cn;

//Java：回文数
public class P9PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new P9PalindromeNumber().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 将数字反转
         * 即使反转出现溢出，说明此数也不是回文数
         *
         * @param x
         * @return
         */
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            int res = 0;
            int tmp = 0;
            int buf = x;
            while (x != 0) {
                tmp = x % 10;
                res = res * 10 + tmp;
                x = x / 10;
            }
            return res == buf;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}















































