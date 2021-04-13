//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。 
//
// 示例: 
//
// 输入: 38
//输出: 2 
//解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
// 
//
// 进阶: 
//你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？ 
// Related Topics 数学 
// 👍 330 👎 0


package leetcode.editor.cn;

//Java：各位相加
public class P258AddDigits {
    //public class JianZhiAddDigits{
    public static void main(String[] args) {
        Solution solution = new P258AddDigits().new Solution();
        int i = solution.addDigits(99);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 设计算法
         * 1. 基于循环，获取一个数字的各个位
         * 2. 内层循环，拆分分别相加，循环退出条件是num=0
         * 3. 外层循环看是否小于9.如果大于9，就继续循环拆分这个数字，外层循环退出条件是num < 10
         * 测试用例
         *
         * @param num
         * @return
         */
        public int addDigits(int num) {
            while (num > 9) {
                int sum = 0;
                while (num != 0) {
                    int digit = num % 10;
                    sum = sum + digit;
                    num = num / 10;
                }
                num = sum;
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}