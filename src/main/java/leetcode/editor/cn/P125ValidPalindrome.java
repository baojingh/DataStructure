//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 353 👎 0


package leetcode.editor.cn;

//Java：验证回文串
public class P125ValidPalindrome {
    //public class JianZhiValidPalindrome{
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
        boolean ab = solution.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(ab);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 回文字符串使用双指针
         * 1. 设置前后指针first，last索引分别向前向后，步长是1
         * 2. 循环结束条件是first，last相等
         * 3. 如果不相等，就返回false
         * 4. 注意考虑大小写情况，注意只考虑字符以及数字
         * <p>
         * <p>
         * 测试用例
         * 1.aa
         * 2. ab
         * 3 aba
         * 4. a&&&a#a
         *
         * @param s
         * @return
         */
        public boolean isPalindrome(String s) {
            if (s == null || s.length() < 2) {
                /**
                 * 如果字符串是null,""或者是只有一个字符，认为是回文
                 */
                return true;
            }
            int first = 0;
            int last = s.length() - 1;
            while (first < last) {
                /**
                 * 处理非数字，字符的情况
                 */
                while (first < last && !Character.isLetterOrDigit(s.charAt(first))) {
                    first = first + 1;
                }
                while (first < last && !Character.isLetterOrDigit(s.charAt(last))) {
                    last = last - 1;
                }
                /**
                 * 统一成小写进行比较
                 */
                if (Character.toLowerCase(s.charAt(first)) == Character.toLowerCase(s.charAt(last))) {
                    /**
                     * 指针移动
                     */
                    first = first + 1;
                    last = last - 1;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}