//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"ae
//c"不是）。 
//
// 进阶： 
//
// 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代
//码？ 
//
// 致谢： 
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
//
// 
//
// 示例 1：
//
// 
//输入：s = "abc", t = "ahbgdc"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "axc", t = "ahbgdc"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 100 
// 0 <= t.length <= 10^4 
// 两个字符串都只由小写字符组成。 
// 
// Related Topics 贪心算法 二分查找 动态规划 
// 👍 438 👎 0


package leetcode.editor.cn;

//Java：判断子序列
public class P392IsSubsequence {
    //public class JianZhiIsSubsequence{
    public static void main(String[] args) {
        Solution solution = new P392IsSubsequence().new Solution();
        boolean subsequence = solution.isSubsequence("ace", "abcsdfmap");
        System.out.println(subsequence);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 设计算法
         * 1. 双指针分别指向两个字符串的首字母si,ti
         * 2. 比较索引对应的字符是否相等
         * 3. 循环结束条件是其中一个指针指向字符串尾部
         *
         * 时间复杂度：O(t.length())
         * @param s
         * @param t
         * @return
         */
        public boolean isSubsequence(String s, String t) {
            int si = 0;
            int ti = 0;
            int sLen = s.length();
            int tLen = t.length();
            if (sLen > tLen) {
                return false;
            }
            char[] sCharArr = s.toCharArray();
            char[] tCharArr = t.toCharArray();

            /**
             * si == sLen这个条件可以优化如下情况：
             * s:abc
             * t:abcdfhnsoinbivsdnio
             */
            while (ti < tLen && si < sLen) {
                char sChar = sCharArr[si];
                char tChar = tCharArr[ti];
                if (sChar == tChar) {
                    si++;
                    /**
                     * 优化点，如果s中的字符已经全部匹配成功，则不需要继续迭代t中的字符
                     */
                    if (si == sLen) {
                        return true;
                    }
                }
                /**
                 * 无论是否匹配，t上的指针都会前进
                 */
                ti++;
            }
            /**
             * while循环结束说明其中一个指针已经到达len+1。
             * 如果是s到达len+1，说明匹配成功
             * 如果是t到达len+1，还要看s是否到达。如果s未到达，则匹配不成功；s到达了，就是true
             */
            if (si < sLen) {
                return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}




































