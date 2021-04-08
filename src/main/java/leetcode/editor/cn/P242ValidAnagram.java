//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。(单词相同，只是字母顺序不同)
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 366 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

//Java：有效的字母异位词
public class P242ValidAnagram {
    //public class JianZhiValidAnagram{
    public static void main(String[] args) {
        Solution solution = new P242ValidAnagram().new Solution();
        boolean anagram = solution.isAnagram("nagaram", "angaram");
        System.out.println(anagram);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 异位词：字母相同，顺序不同
         * 设计算法
         * 1. s是主，t是辅
         *
         * @param s
         * @param t
         * @return
         */
        public boolean isAnagram(String s, String t) {
            if (s == null || t == null || s.length() != t.length()) {
                return false;
            }
            HashMap<Character, Integer> sMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            }

            /**
             * 使用此方法的前提是两个字符串等长
             */
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                int i1 = sMap.getOrDefault(c, 0) - 1;
                sMap.put(c, i1);
                if (i1 < 0) {
                    return false;
                }
            }

            /**
             * 遍历t期间就可以顺便迭代
             */
//            for (Map.Entry<Character, Integer> sm : sMap.entrySet()) {
//                Character key = sm.getKey();
//                Integer value = sm.getValue();
//                Integer tVal = tMap.get(key);
//                /**
//                 * value一定不为空
//                 * tVal有可能为空
//                 */
//                if (!value.equals(tVal)) {
//                    return false;
//                }
//            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}