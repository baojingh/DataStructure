//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。 
//
// 说明：不要使用任何内置的库函数，如 sqrt。 
//
// 示例 1： 
//
// 输入：16
//输出：True 
//
// 示例 2： 
//
// 输入：14
//输出：False
// 
// Related Topics 数学 二分查找


package leetcode.editor.cn;

//Java：有效的完全平方数
public class P367ValidPerfectSquare {
    public static void main(String[] args) {
        String str = "abc";
        Solution solution = new P367ValidPerfectSquare().new Solution();
        boolean square = solution.isPerfectSquare(808201);
        System.out.println(square);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            if (num < 2) {
                return true;
            }
            int low = 2;
            int high = num / 2;
            int mid = 0;
            long val = 0;
            while (low <= high) {
                mid = low + (high - low) / 2;
                // 有mid*mid有溢出风险，转换成long
                val = (long) mid * mid;
                if (val > num) {
                    high = mid - 1;
                } else if (val < num) {
                    low = mid + 1;
                } else if (val == num) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}