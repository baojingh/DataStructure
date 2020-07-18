//实现 pow(x, n) ，即计算 x 的 n 次幂函数。 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
// Related Topics 数学 二分查找 
// 👍 444 👎 0


package leetcode.editor.cn;

//Java：Pow(x, n)
public class P50PowxN {
    public static void main(String[] args) {
        Solution solution = new P50PowxN().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * https://leetcode-cn.com/problems/powx-n/solution/marvelzhong-deng-de-xue-xi-bi-ji-50-by-tyanyonecan/
         * <p>
         * 2020.07.18未搞定
         *
         * @param x
         * @param n
         * @return
         */
        public double myPow(double x, int n) {
            long N = Math.abs((long) n);//当n取范围的左边界时，此处取绝对值用int会溢出
            double ans = 1;
            while (N > 0) {
                if ((N & 1) == 1)
                    ans *= x;
                x *= x;
                N >>= 1;
            }
            if (n < 0)
                ans = 1 / ans;
            return ans;
        }


        /**
         * 暴力法，超时
         *
         * @param x
         * @param n
         * @return
         */
        public double myPow_1(double x, int n) {
            double res = 1;
            for (int i = 1; i <= Math.abs(n); i++) {
                res = res * x;
            }
            if (n < 0) {
                res = 1 / res;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}