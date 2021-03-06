//给定两个字符串 s 和 t，它们只包含小写字母。 
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 
//
// 请找出在 t 中被添加的字母。 
//
// 示例: 
//
// 输入：
//s = "abcd"
//t = "abcde"
//
//输出：
//e
//
//解释：
//'e' 是那个被添加的字母。
// 
// Related Topics 位运算 哈希表


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：找不同
public class P389FindTheDifference {
    public static void main(String[] args) {
        Solution solution = new P389FindTheDifference().new Solution();
        solution.findTheDifference("a", "aa");
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 设计算法
         * 注意一个字符串可能包含重复字符，新添加的字符可能也是与原来的重复
         * 1 使用map存储新字符串的字符以及出现次数
         * 2 迭代原字符串，元素在map中出现，就减一。
         * 3 迭代map，如果某个字符不是0，就说明它是新增加的。
         * 测试用例
         *
         * 不足之处
         *
         * @param s
         * @param t
         * @return
         */
        public char findTheDifference1(String s, String t) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (char c : t.toCharArray()) {
                Integer integer = map.getOrDefault(c, 0);
                map.put(c, integer + 1);
            }
            for (char c : s.toCharArray()) {
                Integer integer = map.getOrDefault(c, 0);
                map.put(c, integer - 1);
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() < 1) {
                    return entry.getKey();
                }
            }
            return ' ';
        }












        /**
         * 解释题意
         * <p>
         * <p>
         * <p>
         * 设计算法
         * 1 使用哈希表存储小字符串各个字符的次数
         * 2 迭代大字符串
         * 3 如果这个字符在map中是null，说明此字符是新增加的。
         * 4 如果这个字符在map中是0，说明这个字符与之前的重复，也应该考虑，如s="a", t="aa"
         * <p>
         * 测试用例
         *
         * @param s
         * @param t
         * @return
         */
        public char findTheDifference(String s, String t) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                Character c = s.charAt(i);
                int count = map.getOrDefault(c, 0);
                map.put(c, count + 1);
            }
            for (int i = 0; i < t.length(); i++) {
                Character c = t.charAt(i);
                Integer integer = map.get(c);
                if (integer == null || integer == 0) {
                    // s="a", t="aa"，这种情况需要考虑integer=0的情况
                    return c;
                } else {
                    map.put(c, integer - 1);
                }
            }
            return ' ';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}