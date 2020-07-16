//编写一个程序判断给定的数是否为丑数。 
//
// 丑数就是只包含质因数 2, 3, 5 的正整数。 
//
// 示例 1: 
//
// 输入: 6
//输出: true
//解释: 6 = 2 × 3 
//
// 示例 2: 
//
// 输入: 8
//输出: true
//解释: 8 = 2 × 2 × 2
// 
//
// 示例 3: 
//
// 输入: 14
//输出: false 
//解释: 14 不是丑数，因为它包含了另外一个质因数 7。 
//
// 说明： 
//
// 
// 1 是丑数。 
// 输入不会超过 32 位有符号整数的范围: [−231, 231 − 1]。 
// 
// Related Topics 数学 
// 👍 133 👎 0


package leetcode.editor.cn;

//Java：丑数
public class P263UglyNumber {
    public static void main(String[] args) {
        Solution solution = new P263UglyNumber().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 设计算法
         * 1 如果一个数是丑，则uglyNumber = i*2 + j*3 + k*5, i,j,k属于[0,无穷大]
         * 2 先将此数循环除以2,最后得到的数不能整除2为止，进入3
         * 3 先将2中的数循环除以3,最后得到的数不能整除3为止，进入4
         * 4 先将4中的数循环除以4,最后得到的数不能整除5为止，进入5
         * 5 最后判断这个数字是否是1，如果是1，则是丑数，否则非丑数
         *
         * @param num
         * @return
         */
        public boolean isUgly(int num) {
            if (num < 1) {
                return false;
            }
            int[] arr = {2, 3, 5};
            int tmp = 0;
            for (int i = 0; i < arr.length; i++) {
                tmp = arr[i];
                while (num % tmp == 0) {
                    num = num / tmp;
                }
            }
            if (num == 1) {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}