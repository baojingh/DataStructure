//如果数组是单调递增或单调递减的，那么它是单调的。 
//
// 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是
//单调递减的。 
// 当给定的数组 A 是单调数组时返回 true，否则返回 false。
// 示例 1：
//
// 输入：[1,2,2,3]
//输出：true
// 示例 2：
// 输入：[6,5,4,4]
//输出：true
//
// 输入：[1,3,2]
//输出：false
//
// 示例 4： 
//
// 输入：[1,2,4,5]
//输出：true
// 
//
// 示例 5： 
//
// 输入：[1,1,1]
//输出：true
// 
// 1 <= A.length <= 50000
// -100000 <= A[i] <= 100000 
// 
// Related Topics 数组


package leetcode.editor.cn;

//Java：单调数列
public class P896MonotonicArray {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 7, 7};
        Solution solution = new P896MonotonicArray().new Solution();
        boolean monotonic = solution.isMonotonic(nums);
        System.out.println(monotonic);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMonotonic(int[] A) {
            int flag = 0;
            for (int i = 1; i < A.length; i++) {
                int gap = A[i] - A[i - 1];
                // 第一次运行或者
                // 相邻数字相等
                // 获得第一个差值的符号
                if (flag == 0) {
                    flag = gap;
                } else {
                    // 相邻符号不相等
                    if (flag * gap < 0) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}