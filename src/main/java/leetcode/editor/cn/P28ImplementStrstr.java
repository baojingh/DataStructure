//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 708 👎 0


package leetcode.editor.cn;

//Java：实现 strStr()
public class P28ImplementStrstr {
    //public class JianZhiImplementStrstr{
    public static void main(String[] args) {
        Solution solution = new P28ImplementStrstr().new Solution();
        int i = solution.strStr("hello", "ll");
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 问题描述：
         * 1. 字符串A，字符串B。如果A包含B，则找到B在A中首次出现的位置；如果A不包含B，则返回-1
         * 2. 如果B是null，则返回0？？
         * 设计算法
         * https://leetcode-cn.com/problems/implement-strstr/solution/zhe-ke-neng-shi-quan-wang-zui-xi-de-kmp-8zl57/
         * 1. 迭代字符串A，判断当前字符是否与字符串B的第一个相同。
         * 如果相同，两个字符串就向后移动。
         * 如果不相等字符串A的指针向后移动，同时字符串B从头部开始。
         * <p>
         * <p>
         * <p>
         * 测试用例
         *
         * @param haystack
         * @param needle
         * @return
         */
        public int strStr(String haystack, String needle) {
            if (haystack == null || needle == null) {
                return 0;
            }
            int i = 0;
            int j = 0;

            for (i = 0; i < haystack.length(); i++) {
                char base = haystack.charAt(i);
                for (j = 0; j < needle.length();j++ ) {
                    char sub = needle.charAt(j);
                    if (base != sub) {
                        break;
                    }
                }
                /**
                 * 模式串已经遍历到最后
                 */
                if (j == needle.length() - 1) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}