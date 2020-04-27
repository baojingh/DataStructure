//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window


package leetcode.editor.cn;

import java.util.HashMap;

//Java：无重复字符的最长子串
public class P3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        int substring = solution.lengthOfLongestSubstring("pwwkew");
        System.out.println(substring);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * https://leetcode-cn.com/problems/
         * longest-substring-without-repeating-characters/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/
         * 2020-04-27没搞定
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int start = 0;
            int end = 0;
            int maxLen = 0;
            int len = s.length();
            for (; end < len; end++) {
                char c = s.charAt(end);
                if (map.get(c) != null) {
                    start = Math.max(start, map.get(c));
                }
                maxLen = Math.max(end - start + 1, maxLen);
                map.put(c, end + 1);
            }
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}