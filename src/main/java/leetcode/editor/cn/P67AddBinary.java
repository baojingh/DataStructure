//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
// 示例 1:
// 输入: a = "11", b = "1"
//输出: "100" 
// 示例 2:
// 输入: a = "1010", b = "1011"
//输出: "10101" 
// 提示：
// 每个字符串仅由字符 '0' 或 '1' 组成。
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串


package leetcode.editor.cn;

//Java：二进制求和
public class P67AddBinary {
    public static void main(String[] args) {
        String str1 = "1";
        String str2 = "0";
        Solution solution = new P67AddBinary().new Solution();
        String binary = solution.addBinary(str1, str2);
        System.out.println(binary);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            int sum = 0;
            int carry = 0;
            int aNum = 0;
            int bNum = 0;
            StringBuffer buffer = new StringBuffer();
            for (int i = a.length() - 1, j = b.length() - 1; i > -1 || j > -1; i--, j--) {
                if (i > -1) {
                    aNum = Character.getNumericValue(a.charAt(i));
                } else {
                    aNum = 0;
                }
                if (j > -1) {
                    bNum = Character.getNumericValue(b.charAt(j));
                } else {
                    bNum = 0;
                }
                sum = aNum + bNum + carry;
                carry = sum / 2;
                buffer.append(sum % 2);
            }
            if (carry == 1) {
                buffer.append(1);
            }
            return buffer.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}