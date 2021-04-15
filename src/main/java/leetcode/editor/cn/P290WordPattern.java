//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 
// 👍 321 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

//Java：单词规律
public class P290WordPattern {
    //public class JianZhiWordPattern{
    public static void main(String[] args) {
        Solution solution = new P290WordPattern().new Solution();
        boolean b = solution.wordPattern("abba", "dog cat dd dog");
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 双向映射问题，使用map
         * 1. map1，map2分别存放自己与对方的映射
         * 2.
         *
         * @param pattern
         * @param s
         * @return
         */
        public boolean wordPattern(String pattern, String s) {
            HashMap<String, Character> map1 = new HashMap<>();
            HashMap<Character, String> map2 = new HashMap<>();
            if (pattern == null || s == null) {
                return false;
            }
            String[] s1 = s.split(" ");
            if (s1.length != pattern.length()) {
                return false;
            }
            for (int i = 0; i < pattern.length(); i++) {
                Character c = pattern.charAt(i);
                String str = s1[i];
                if (map1.get(str) != null && !map1.get(str).equals(c)) {
                    return false;
                }
                if (map2.get(c) != null && !map2.get(c).equals(str)) {
                    return false;
                }
                map1.put(s1[i], c);
                map2.put(c, s1[i]);

            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}