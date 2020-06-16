//给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。 
//
// 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。 
//
// 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。 
//
// 返回词汇表 words 中你掌握的所有单词的 长度之和。 
//
// 
//
// 示例 1： 
//
// 输入：words = ["cat","bt","hat","tree"], chars = "atach"
//输出：6
//解释： 
//可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
// 
//
// 示例 2： 
//
// 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
//输出：10
//解释：
//可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length, chars.length <= 100 
// 所有字符串中都仅包含小写英文字母 
// 
// Related Topics 数组 哈希表


package leetcode.editor.cn;

import java.util.HashMap;

//Java：拼写单词
public class P1160FindWordsThatCanBeFormedByCharacters {
    public static void main(String[] args) {
        Solution solution = new P1160FindWordsThatCanBeFormedByCharacters().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解释题意
         * 1 给定一个字符串b，里面包含多个字母
         * 2 构建map，存储b中的字符以及出现次数
         * 3 给定一个字符串数组arr，每个字符串a由字母组成
         * 4 字符串数组arr中的字符串a，是否由给定的字符串b中的字符组成？
         * 5 迭代字符串b中的字符，在map每出现一次，map中的value减少一次【map需要保存原始信息】
         * 6 如果这个字符串符合条件，就累加单词的长度之和
         * <p>
         * 设计算法
         * <p>
         * 测试用例
         *
         * @param words
         * @param chars
         * @return
         */
        public int countCharacters(String[] words, String chars) {
            if (words == null || words.length == 0 || chars == null || chars.length() == 0) {
                return 0;
            }
            HashMap<Character, Integer> map = new HashMap<>();
            for (Character c : chars.toCharArray()) {
                // 每个字符出现的次数
                int count = map.getOrDefault(c, 0);
                map.put(c, count + 1);
            }
            int sum = 0;
            boolean isIn;
            for (String word : words) {
                isIn = true;
                // 保存map最原始的字符次数数据
                HashMap<Character, Integer> tmpMap = (HashMap<Character, Integer>) map.clone();
                for (Character c : word.toCharArray()) {
                    Integer integer = tmpMap.get(c);
                    if (integer == null || integer == 0) {
                        // 这个单词中的字符不在字符列表或者这个字符在map中的value是0
                        isIn = false;
                        break;
                    } else {
                        // 字符对应的次数减1
                        tmpMap.put(c, integer - 1);
                    }
                }
                if (isIn) {
                    // 符合条件
                    sum = sum + word.length();
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}