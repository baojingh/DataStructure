//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划


package leetcode.editor.cn;

//Java：解码方法
public class P91DecodeWays {
    public static void main(String[] args) {
        Solution solution = new P91DecodeWays().new Solution();
        int decodings = solution.numDecodings("226");
        System.out.println(decodings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 状态方程
         * <p>
         * <p>
         * 初始化
         *
         * @param s
         * @return
         */
        public int numDecodings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int count = 0;
            boolean flag = true;

            for (int i = 0; i < s.length() - 1; i++) {
                for (int j = i + 1; j < i + 3; j++) {
                    String substring = s.substring(i, j);
                    int anInt = Integer.parseInt(substring);
                    if (anInt < 1 || anInt > 26) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {

                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}