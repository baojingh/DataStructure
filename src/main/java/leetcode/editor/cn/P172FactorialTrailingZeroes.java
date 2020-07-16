//给定一个整数 n，返回 n! 结果尾数中零的数量。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// Related Topics 数学 
// 👍 310 👎 0


package leetcode.editor.cn;

//Java：阶乘后的零
public class P172FactorialTrailingZeroes {
    public static void main(String[] args) {
        Solution solution = new P172FactorialTrailingZeroes().new Solution();
        int zeroes = solution.trailingZeroes(22);
        System.out.println(zeroes);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int trailingZeroes(int n) {
            int count = 0;
            while (n != 0) {
                count = count + (n / 5);
                n = n / 5;
            }
            return count;
        }


        /**
         * 设计算法
         * https://leetcode-cn.com/problems/factorial-trailing-zeroes/solution/q172-factorial-trailing-zeroes-by-ronhou/
         * 2020.07.16没搞定
         *
         * @param n
         * @return
         */
        public int trailingZeroes_1(int n) {
            long res = 1L;
            int count = 0;
            boolean flag = false;
            for (long i = 2; i <= n; i++) {
                res = res * i;
            }
            System.out.println(res);
            while (res != 0) {
                if (res % 10 == 0) {
                    count = count + 1;
                    flag = true;
                } else {
                    flag = false;
                }
                if (!flag) {
                    break;
                }
                res = res / 10;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}