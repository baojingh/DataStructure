//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串


package leetcode.editor.cn;

import java.util.HashMap;

//Java：字符串中的第一个唯一字符
public class P387FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new P387FirstUniqueCharacterInAString().new Solution();
        int leetcode = solution.firstUniqChar("leetcode");
        System.out.println(leetcode);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 解释题意
         * <p>
         * 设计算法
         * 1 使用哈希表存储每个字符在字符串中的出现次数
         * 2 遍历每个k-v，如果v是1，就取出相应的字符
         * 3 判断其在字符串中的位置
         * <p>
         * 测试用例
         * 1 null
         * 2 ""
         * 3 a
         * 4 abca
         * 5 abc
         * 6 aaa
         * <p>
         * 复杂度分析
         * 时间复杂度：O(n) + O(n) = O(n)
         * 空间复杂度：O(n)
         *
         * @param s
         * @return
         */
        public int firstUniqChar(String s) {
            if (s == null) {
                return -1;
            }
            HashMap<Character, Integer> map = new HashMap<>();
            int count = 0;
            for (Character c : s.toCharArray()) {
                // 每个字符出现的次数
                // null 就返回0
                count = map.getOrDefault(c, 0);
                map.put(c, count + 1);
            }
            for (int i = 0; i < s.length(); i++) {
                // 根据索引位置，迭代字符串中的每个字符，获取其在map中出现的次数
                Character c = s.charAt(i);
                Integer integer = map.get(c);
                if (integer == 1) {
                    return i;
                }

            }
            return -1;
        }

        /**
         * 设计算法
         * 1 迭代字符串中的每个字符
         * 2 使用长度是26的数组，记录每个字符出现的次数，转移将字符转换成数组下标
         * 3 字符串转换成字符数组，迭代这个数组，取出这个字符出现的次数
         *
         * @param s
         * @return
         */
        public int firstUniqChar_array(String s) {
            if (s == null) {
                return -1;
            }
            // 26个字母，每个字母出现的次数
            int[] charArray = new int[26];
            // 字符串转换成字符数组
            char[] originCharArray = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                // 题目说只包含小写字母，如果大小写都包括，是否可以考虑哈希表
                charArray[c - 'a'] = charArray[c - 'a'] + 1;
            }
            for (int i = 0; i < s.length(); i++) {
                // originCharArray[i]是字符串中具体的字符
                // i是字符在字符串中的位置
                if (charArray[originCharArray[i] - 'a'] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}