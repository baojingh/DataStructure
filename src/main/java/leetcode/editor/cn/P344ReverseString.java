//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。 
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
// 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
// 示例 1：
// 输入：["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
// 示例 2：
// 输入：["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"] 
// Related Topics 双指针 字符串


package leetcode.editor.cn;

import java.util.Arrays;

//Java：反转字符串
public class P344ReverseString {
    public static void main(String[] args) {
//        char[] str = {'h', 'e', 'l', 'l', 'o'};
        char[] str = {'h'};
        Solution solution = new P344ReverseString().new Solution();
        solution.reverseString(str);
        System.out.println(Arrays.toString(str));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            int start = 0;
            int end = s.length - 1;
            while (start < end) {
                char tmp = s[start];
                s[start] = s[end];
                s[end] = tmp;
                start = start + 1;
                end = end - 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}