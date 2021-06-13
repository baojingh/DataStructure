//给定一个单词，你需要判断单词的大写使用是否正确。 
//
// 我们定义，在以下情况时，单词的大写用法是正确的： 
//
// 
// 全部字母都是大写，比如"USA"。 
// 单词中所有字母都不是大写，比如"leetcode"。 
// 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。 
// 
//
// 否则，我们定义这个单词没有正确使用大写字母。 
//
// 示例 1: 
//
// 
//输入: "USA"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "FlaG"
//输出: False
// 
//
// 注意: 输入是由大写和小写拉丁字母组成的非空单词。 
// Related Topics 字符串 
// 👍 133 👎 0


package leetcode.editor.cn;

//Java：检测大写字母
public class P520DetectCapital {
    //public class JianZhiDetectCapital{
    public static void main(String[] args) {
        Solution solution = new P520DetectCapital().new Solution();
        boolean uaa = solution.detectCapitalUse("Uaa");
        System.out.println(uaa);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 判断大小写
         *
         * @param word
         * @return
         */
        public boolean detectCapitalUse(String word) {

            /**
             * 是否与前一个一致
             */
            char[] chars = word.toCharArray();
            char first = word.charAt(0);
            int capitalCount = 0;
            for (char aChar : chars) {
                boolean capital = isCapital(aChar);
                if (capital) {
                    capitalCount++;
                }
            }
            if (word.length() == capitalCount) {
                return true;
            }
            if ((1 == capitalCount) && isCapital(first)) {
                return true;
            }
            if (capitalCount == 0) {
                return true;
            }
            return false;
        }

        private boolean isCapital(Character character) {
            if (character >= 'A' && character <= 'Z') {
                return true;
            } else if (character >= 'a' && character <= 'z') {
                return false;
            }
            return false;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}








































