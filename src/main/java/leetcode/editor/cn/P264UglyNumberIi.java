//编写一个程序，找出第 n 个丑数。 
//
// 丑数就是质因数只包含 2, 3, 5 的正整数。 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
// Related Topics 堆 数学 动态规划 
// 👍 329 👎 0


package leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Queue;

//Java：丑数 II
public class P264UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new P264UglyNumberIi().new Solution();
        int number = solution.nthUglyNumber(10);
        System.out.println(number);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int nthUglyNumber(int n) {
            Queue<Long> queue = new PriorityQueue<Long>();
            int count = 0;
            long result = 1;
            queue.add(result);
            while (count < n) {
                result = queue.poll();
                // 删除重复的
                while (!queue.isEmpty() && result == queue.peek()) {
                    queue.poll();
                }
                count++;
                queue.offer(result * 2);
                queue.offer(result * 3);
                queue.offer(result * 5);
            }
            return (int) result;
        }

        /**
         * 超时
         *
         * @param n
         * @return
         */
        public int nthUglyNumber_1(int n) {
            if (n < 1) {
                return 0;
            }
            int[] number = new int[n];
            int base = 1;
            int index = 0;
            while (true) {
                boolean uglyNUmber = isUglyNUmber(base);
                if (uglyNUmber) {
                    number[index] = base;
                    index = index + 1;
                }
                base = base + 1;
                if (n == index) {
                    break;
                }
            }
            return number[n - 1];
        }

        private boolean isUglyNUmber(int num) {
            int[] baseArr = {2, 3, 5};
            int tmp = 0;
            for (int i = 0; i < baseArr.length; i++) {
                tmp = baseArr[i];
                while (num % tmp == 0) {
                    num = num / tmp;
                }
            }
            if (num == 1) {
                return true;
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}