//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 149 👎 0


package leetcode.editor.cn;

import java.util.HashSet;

//Java：反转字符串中的元音字母
public class P345ReverseVowelsOfAString {
    //public class JianZhiReverseVowelsOfAString{
    public static void main(String[] args) {
        Solution solution = new P345ReverseVowelsOfAString().new Solution();
        String hello = solution.reverseVowels("leetcode");
        System.out.println(hello);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            HashSet<Character> set = new HashSet<>();
            set.add('a');
            set.add('e');
            set.add('i');
            set.add('o');
            set.add('u');

            set.add('A');
            set.add('E');
            set.add('I');
            set.add('O');
            set.add('U');

            int low = 0;
            int high = s.length() - 1;
            char[] chars = s.toCharArray();
            while (low <= high) {
                while (low < high && !set.contains(chars[low])) {
                    low++;
                }
                while (low < high && !set.contains(chars[high])) {
                    high--;
                }
                char tmp = chars[low];
                chars[low] = chars[high];
                chars[high] = tmp;
                low++;
                high--;
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}