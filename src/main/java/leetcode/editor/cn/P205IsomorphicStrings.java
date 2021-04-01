//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
//
// 
//
// 示例 1: 
//
// 
//输入：s = "egg", t = "add"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "foo", t = "bar"
//输出：false 
//
// 示例 3： 
//
// 
//输入：s = "paper", t = "title"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 可以假设 s 和 t 长度相同。 
// 
// Related Topics 哈希表 
// 👍 343 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

//Java：同构字符串
public class P205IsomorphicStrings {
    //public class JianZhiIsomorphicStrings{
    public static void main(String[] args) {
        Solution solution = new P205IsomorphicStrings().new Solution();
        boolean isomorphic = solution.isIsomorphic("paper", "titl");
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * https://leetcode-cn.com/problems/isomorphic-strings/solution/tong-gou-zi-fu-chuan-by-leetcode-solutio-s6fd/
         * <p>
         * 设计算法
         * 1. 使用两个map分别存储当前字符串对应的另一个字符串中的字符
         * 2. 迭代字符串，如果当前的字符不在map中，则存储，如果当前字符在map中但是得到的value不能与另一个map中的key对应，则是false
         *
         * 测试用例
         *
         * @param s
         * @param t
         * @return
         */
        public boolean isIsomorphic(String s, String t) {
            if (s == null || t == null || s.length() != t.length()) {
                return false;
            }
            HashMap<Character, Character> sMap = new HashMap<>();
            HashMap<Character, Character> tMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char sChar = s.charAt(i);
                char tChar = t.charAt(i);
                Character character1 = sMap.get(sChar);
                Character character2 = tMap.get(tChar);
                if (character1 != null && character1 != tChar) {
                    return false;
                }
                if (character2 != null && character2 != sChar) {
                    return false;
                }
                sMap.put(sChar, tChar);
                tMap.put(tChar, sChar);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}