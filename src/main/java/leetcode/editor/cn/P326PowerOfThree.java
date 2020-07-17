//给定一个整数，写一个函数来判断它是否是 3 的幂次方。 
//
// 示例 1: 
//
// 输入: 27
//输出: true
// 
//
// 示例 2: 
//
// 输入: 0
//输出: false 
//
// 示例 3: 
//
// 输入: 9
//输出: true 
//
// 示例 4: 
//
// 输入: 45
//输出: false 
//
// 进阶： 
//你能不使用循环或者递归来完成本题吗？ 
// Related Topics 数学 
// 👍 116 👎 0


package leetcode.editor.cn;

//Java：3的幂
public class P326PowerOfThree {
    public static void main(String[] args) {
        Solution solution = new P326PowerOfThree().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfThree_1(int n) {
            if (n < 1) {
                return false;
            }
            while (n % 3 == 0) {
                n = n / 3;
            }
            if (n == 1) {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
























