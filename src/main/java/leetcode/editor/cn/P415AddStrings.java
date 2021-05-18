//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 373 👎 0


package leetcode.editor.cn;


//Java：字符串相加
public class P415AddStrings {
    //public class JianZhiAddStrings{
    public static void main(String[] args) {
        Solution solution = new P415AddStrings().new Solution();
        String s = solution.addStrings("123", "11");
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            int index1 = num1.length() - 1;
            int index2 = num2.length() - 1;
            char[] char1 = num1.toCharArray();
            char[] char2 = num2.toCharArray();
            int flag = 0;
            StringBuilder sb = new StringBuilder();
            while (index1 > -1 || index2 > -1) {
                int n1 = 0;
                int n2 = 0;
                if (index1 > -1) {
                    n1 = char1[index1--] - '0';
                }
                if (index2 > -1) {
                    n2 = char2[index2--] - '0';
                }
                flag = (n1 + n2 + flag) / 10;
                int tmp = (n1 + n2 + flag) % 10;
                sb.append(tmp);
            }
            if (flag == 1) {
                sb.append(flag);
            }
            StringBuilder reverse = sb.reverse();
            return reverse.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}