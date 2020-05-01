//我们正在玩一个猜数字游戏。 游戏规则如下： 
//我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。 
//每次你猜错了，我会告诉你这个数字是大了还是小了。 
//你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）： 
//
// -1 : 我的数字比较小
// 1 : 我的数字比较大
// 0 : 恭喜！你猜对了！
// 
//
// 
//
// 示例 : 
//
// 输入: n = 10, pick = 6
//输出: 6 
// Related Topics 二分查找


package leetcode.editor.cn;

//Java：猜数字大小
public class P374GuessNumberHigherOrLower {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        Solution solution = new P374GuessNumberHigherOrLower().new Solution();

        System.out.println();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is lower than the guess number
     * 1 if num is higher than the guess number
     * otherwise return 0
     * int guess(int num);
     */

//    static class GuessGame {
//        public int guess(int num) {
//            return 1;
//        }
//    }

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int low = 1;
            int high = n;
            int mid = 0;
            int val = 0;
            while (low <= high) {
                mid = low + (high - low) / 2;
                val = guess(mid);
                if (val == -1) {
                    high = mid - 1;
                } else if (val == 1) {
                    low = mid + 1;
                } else if (val == 0){
                    return mid;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}