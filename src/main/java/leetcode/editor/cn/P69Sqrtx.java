//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找


package leetcode.editor.cn;

//Java：x 的平方根
public class P69Sqrtx {
    public static void main(String[] args) {
        String str = "abc";
        Solution solution = new P69Sqrtx().new Solution();
        int sqrt = solution.mySqrt(2147395599);
        System.out.println(sqrt);
        System.out.println(Math.sqrt(2147395599));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 设计算法
         * 1 二分查找算法，初始比较区间是[1, n/2]
         * 2 中间数的平方大，右边界左移；平方比较小，左边界右移
         * 3 直到找到这个数字为止
         * <p>
         * 测试用例
         *
         * @param x
         * @return
         */
        public int mySqrt1(int x) {
            int low = 1;
            int high = x / 2;
            while (low <= high) {
                int mid = low + (high - low) >> 1;
                if (mid * mid > x) {
                    high = high - 1;
                } else if (mid * mid < x) {
                    low = low + 1;
                } else {
                    return mid;
                }
            }
            return 0;
        }























        public int mySqrt(int x) {
            if (x < 2) {
                return x;
            }
            int left = 2;
            int right = x / 2;
            long val = 0;
            int pivot = 0;
            while (left <= right) {
                pivot = left + (right - left) / 2;
                // pivot * pivot有整型溢出的风险
                val = (long) pivot * pivot - x;
                if (val > 0) {
                    right = pivot - 1;
                } else if (val < 0) {
                    left = pivot + 1;
                } else {
                    return pivot;
                }
            }
            return right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}