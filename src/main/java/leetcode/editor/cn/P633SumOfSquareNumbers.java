//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。 
//
// 示例1: 
//
// 
//输入: 5
//输出: True
//解释: 1 * 1 + 2 * 2 = 5
// 
//
// 
//
// 示例2: 
//
// 
//输入: 3
//输出: False
// 
// Related Topics 数学 
// 👍 123 👎 0


package leetcode.editor.cn;

//Java：平方数之和
public class P633SumOfSquareNumbers {
    public static void main(String[] args) {
        Solution solution = new P633SumOfSquareNumbers().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解释题意
         * 1 存在两个整数a,b，例如-2，-1，-，1，2，3，4，5，他们的平方之和等于指定的数c
         * 2 a*a,b*b的值分别小于c，也就是a,b的区间范围是[0,sqrt(c)]
         * 3 双指针i,j分别指向区间两端，如他们的平方和偏大，j--；如平方和偏小，i++。直到找到这两个数字
         * 4 循环终止条件j>i
         *
         *
         * <p>
         * 设计算法
         * 1
         * <p>
         * 测试用例
         * <p>
         * 复杂度分析
         * 时间复杂度
         * 空间复杂度
         *
         * @param c
         * @return
         */
        public boolean judgeSquareSum(int c) {
            int i = 0;
            int j = (int) Math.sqrt(c);
            int tmp = 0;
            while (i <= j) {
                tmp = i * i + j * j;
                if (tmp > c) {
                    j = j - 1;
                } else if (tmp < c) {
                    i = i + 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)
}
