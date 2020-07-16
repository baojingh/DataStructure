//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学 
// 👍 218 👎 0


package leetcode.editor.cn;

//Java：2的幂
public class P231PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new P231PowerOfTwo().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 位运算
         * 设计算法
         * 1 n如果是2的次幂，转换成二进制就是最高位是1，其余为全部是0
         * 2 n-1，最高位是0，其余为全部是1。
         * 3 两部分&，一定是0
         *
         * https://leetcode-cn.com/problems/power-of-two/solution/power-of-two-er-jin-zhi-ji-jian-by-jyd/
         *
         * @param n
         * @return
         */
        public boolean isPowerOfTwo(int n) {
            if (n < 1) {
                return false;
            }
            if ((n & (n - 1)) == 0) {
                return true;
            }
            return false;
        }


        /**
         * 设计算法
         * 1 这个数一定可以整除2，最后的结果是1，余数是0。
         *
         * @param n
         * @return
         */
        public boolean isPowerOfTwo_1(int n) {
            if (n < 0) {
                return false;
            }
            while (n % 2 == 0) {
                n = n / 2;
            }
            if (n == 1) {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}