//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？ 
//
// 
//
// 示例 1: 
//
// 输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 2: 
//
// 输入: m = 7, n = 3
//输出: 28 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10 ^ 9 
// 
// Related Topics 数组 动态规划


package leetcode.editor.cn;

//Java：不同路径
public class P62UniquePaths {
    public static void main(String[] args) {
        Solution solution = new P62UniquePaths().new Solution();
        int uniquePaths = solution.uniquePaths(4, 3);
        System.out.println(uniquePaths);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int uniquePaths_3(int m, int n) {
            if (m < 1 || n < 1) {
                return 0;
            }

            int row = Math.min(m, n);
            int column = Math.max(m, n);

            int[] dp = new int[column];
            // 此处为什么是1，解释为一个格子，到达本格子只有一个办法
            dp[0] = 1;
            for (int i = 1; i < column; i++) {
                dp[i] = 1;
            }
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < column; j++) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
            return dp[column - 1];
        }


        /**
         * 推理一下：三行三列的框，走到右下角的方案是6，因为最上面以及最左的，路线方案均是1，
         * 1 1 1
         * 1 2 3
         * 1 3 6
         * <p>
         * 状态方程：
         * dp[0] = 1
         * i > 0, j >0
         * dp[i][j] = dp[i][j - 1] + dp[i -1][j]
         * i = 0
         * dp[0][j] = dp[0][j-1]
         * <p>
         * j = 0
         * dp[i][0] = dp[i-1][0]
         *
         * @param m 行数
         * @param n 列数
         * @return
         */
        public int uniquePaths(int m, int n) {
            if (m < 1 || n < 1) {
                return 0;
            }
            int[][] ints = new int[m][n];

            // 只有一个格子，找到的路径个数是1

            // 初始化左
            for (int i = 0; i < m; i++) {
                ints[i][0] = 1;
            }
            // 初始化上
            for (int i = 0; i < n; i++) {
                ints[0][i] = 1;
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    ints[i][j] = ints[i - 1][j] + ints[i][j - 1];
                }
            }
            return ints[m - 1][n - 1];
        }

        public int uniquePaths_1(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}