//给定一个Excel表格中的列名称，返回其相应的列序号。 
//
// 例如， 
//
//     A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//    ...
// 
//
// 示例 1: 
//
// 输入: "A"
//输出: 1
// 
//
// 示例 2: 
//
// 输入: "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 输入: "ZY"
//输出: 701 
//
// 致谢： 
//特别感谢 @ts 添加此问题并创建所有测试用例。 
// Related Topics 数学 
// 👍 158 👎 0


package leetcode.editor.cn;

//Java：Excel表列序号
public class P171ExcelSheetColumnNumber {
    public static void main(String[] args) {
        Solution solution = new P171ExcelSheetColumnNumber().new Solution();
        int title = solution.titleToNumber("AA");
        System.out.println(title);
        System.out.println((int) Math.pow(26, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 二进制转换成十进制，算法
         * @param s
         * @return
         */
        public int titleToNumber(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int sum = 0;
            int tmp = 0;
            for (char c : s.toCharArray()) {
                tmp = c - 64;
                sum = sum * 26 + tmp;
            }
            return sum;
        }


        public int titleToNumber_1(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int sum = 0;
            int index = 0;
            int len = s.length();
            int tmp = 0;
            char c = 'A';
            for (int i = 0; i < len; i++) {
                // 获取低位
                index = len - i - 1;
                c = s.charAt(index);
                // 只有一位，就是26^0；两位就是26^1
                tmp = (c - 64) * ((int) Math.pow(26, i));
                sum = sum + tmp;
            }
            return sum;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}