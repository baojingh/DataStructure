//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划


package leetcode.editor.cn;

//Java：爬楼梯
public class P70ClimbingStairs {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        Solution solution = new P70ClimbingStairs().new Solution();
        int stairs = solution.climbStairs(5);
        System.out.println(stairs);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 看了很多题解，很多人说这个是动态规划，或者直接列出转移方程，也不做具体的解释，要么是解释的并不详细，后来看到标题为“爬楼梯？no，斐波那契数列？yes”的题解，才有点明白。
         * 假设爬n阶楼梯的方法数为f(n)，因为每一步都有两种选择，如果第一步爬1阶，那么爬剩下的(n-1)阶台阶的方法数为f(n-1)，如果第一步爬2阶，那么爬剩下的(n-2)阶台阶的方法数为f(n-2)。因为这是两种不同的选择，所以f(n)=f(n-1)+f(n-2)。
         * ---------------------我的误区----------------------------------------
         * 我之前的误区在于，割裂了第一步与后面步骤的关系，以为第一步爬1阶后还剩下(n-1)阶，也就是f(n)=f(n-1)+1,以为第一步爬2阶后还剩下(n-2)阶，也就是f(n)=f(n-2)+2，但事实是第一步和后面步骤是一个整体，假设我们每次爬台阶只能爬1阶，现在有n阶台阶，那f(n)=f(n-1)，因为你第一步爬完了之后并不是方法数+1，第一步爬完了之后方法数是取决于后面爬(n-1)阶所用的方法数。
         *
         * @param n
         * @return
         */
        public int climbStairs(int n) {
            if (n <= 0) {
                return 0;
            }
            int[] dp = new int[n + 2];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}