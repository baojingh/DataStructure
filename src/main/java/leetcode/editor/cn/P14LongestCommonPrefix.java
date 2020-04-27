//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串


package leetcode.editor.cn;

//Java：最长公共前缀
public class P14LongestCommonPrefix {
    public static void main(String[] args) {
//        String[] nums = new String[]{"flower", "flow", "flight"};
        String[] nums = new String[]{};
        Solution solution = new P14LongestCommonPrefix().new Solution();
        String prefix = solution.longestCommonPrefix(nums);
        System.out.println(prefix);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length <= 0) {
                return "";
            }
            String ans = strs[0];
            for (int i = 1; i < strs.length; i++) {
                int j = 0;
                for (; j < strs[i].length() && j < ans.length(); j++) {
                    if (strs[i].charAt(j) != ans.charAt(j)) {
                        break;
                    }
                }
                ans = ans.substring(0, j);
                if (ans.isEmpty()) {
                    return "";
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}