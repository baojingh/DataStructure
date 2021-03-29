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
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 设计算法
         * 1. 迭代字符串s，计算当前字符与t对应的差值 <c, gap>
         * 2. 如果当前字符不在map中，则添加，如果存在，判断当前的差值与map中的差值是否相同
         * <p>
         * 测试用例
         * 1. null,null
         * 2. a a
         * 3. ab cf
         *
         * @param s
         * @param t
         * @return
         */
        public boolean isIsomorphic(String s, String t) {
            if (s == null || t == null) {
                return false;
            }
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char base = s.charAt(i);
                char vice = t.charAt(i);
                int gap = base - vice;

                Integer integer = map.get(base);
                if (integer == null) {
                    map.put(base, gap);
                } else {
                    if (gap != integer) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}