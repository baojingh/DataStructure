//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。 
//
// 示例: 
//
// 输入: "Hello, my name is John"
//输出: 5
//解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
// 
// Related Topics 字符串 
// 👍 87 👎 0


package leetcode.editor.cn;

//Java：字符串中的单词数
public class P434NumberOfSegmentsInAString {
    //public class JianZhiNumberOfSegmentsInAString{
    public static void main(String[] args) {
        Solution solution = new P434NumberOfSegmentsInAString().new Solution();
        int i = solution.countSegments("abc e e");
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 方法一
         * 基于空格切分
         *
         * 方法二
         * 0. 统计每个单词的开始位置，如果每个单词的首位置是单词的字母，就认为这是一个单词
         * 1. 迭代字符串中的字母，如果当前不是' '，并且标记是true，并做累加
         * 2. 累加的同时对这个单词做标记
         * 3. 如果统计到当前位置是' '，并做标记
         *
         *
         * @param s
         * @return
         */
        public int countSegments(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int count = 0;
            boolean isBlank = false;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c != ' ' && !isBlank) {
                    count++;
                    isBlank = true;
                } else if (c == ' ') {
                    isBlank = false;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}