//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表 
// 👍 293 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：最长回文串
public class P409LongestPalindrome {
    //public class JianZhiLongestPalindrome{
    public static void main(String[] args) {
        Solution solution = new P409LongestPalindrome().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 回文字符串：对称的字符串。aba, abba
         * 构造算法
         * 1. 如果一个字符有偶数个，肯定可以被当做回文数的一部分；
         * 2. 如果奇数个，如果只有1个，不能作为回文数一部分；如果多于一个即3,5,7 可以减一即(2，4，6)作为回文数一部分
         *
         * @param s
         * @return
         */
        public int longestPalindrome(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (Character c : s.toCharArray()) {
                Integer orDefault = map.getOrDefault(c, 0);
                map.put(c, orDefault + 1);
            }
            int res = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                Integer value = entry.getValue();
                if ((value & 1) == 1) {
                    /**
                     * 奇数
                     */
                    res = res + value - 1;
                } else {
                    /**
                     * 偶数
                     */
                    res = res + value;
                }
            }
            if (res < s.length()) {
                res = res + 1;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}