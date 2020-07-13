//给定一个正整数，返回它在 Excel 表中相对应的列名称。 
//
// 例如， 
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
//    ...
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "A"
// 
//
// 示例 2: 
//
// 输入: 28
//输出: "AB"
// 
//
// 示例 3: 
//
// 输入: 701
//输出: "ZY"
// 
// Related Topics 数学 
// 👍 238 👎 0


package leetcode.editor.cn;

//Java：Excel表列名称
public class P168ExcelSheetColumnTitle {
    public static void main(String[] args) {
        Solution solution = new P168ExcelSheetColumnTitle().new Solution();
        String convert = solution.convertToTitle(701);
        System.out.println(convert);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 设计算法
         * 1
         * 二十六进制
         *
         * @param n
         * @return
         */
        public String convertToTitle(int n) {
            if (n < 1) {
                return "";
            }
            // A: 65
            int base = 64;
            char A = 'A';
            StringBuilder builder = new StringBuilder();
            while (n != 0) {
                int tmp = n % 26;
                char c = (char) (base + tmp);
                // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 ... 26 27 28 ... 51 52 53
                // A B                                              Z  AA AB     ZY ZZ ZZA
                if (tmp == 0) {
                    c = 'Z';
                    n = n - 1;
                }
                builder.insert(0, c);
                n = n / 26;
            }
            return builder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}