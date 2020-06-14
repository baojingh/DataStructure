//给定两个字符串 s 和 t，它们只包含小写字母。 
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 
//
// 请找出在 t 中被添加的字母。 
//
// 
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
         * 解释题意
         *
         *
         *
         * 设计算法
         * 1 使用哈希表存储小字符串各个字符的次数
         * 2 迭代大字符串
         * 3 如果这个字符在map中是null，说明此字符是新增加的。
         * 4 如果这个字符在map中是0，说明这个字符与之前的重复，也应该考虑，如s="a", t="aa"
         *
         * 测试用例
         *
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