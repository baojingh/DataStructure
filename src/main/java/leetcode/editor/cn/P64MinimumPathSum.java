//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划


package leetcode.editor.cn;

//Java：最小路径和
public class P64MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new P64MinimumPathSum().new Solution();
        int[][] arr = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int sum = solution.minPathSum(arr);
        System.out.println(sum);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 第一行是特殊情况，只有左右有值，上面没有值
         * 第一列是特殊情况，只有上下有值，左面没有值
         * 其他就可以按照正常情况处理
         *
         * @param grid
         * @return
         */
        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            int rowLen = grid.length;
            int columnLen = grid[0].length;
            int[][] dp = new int[rowLen][columnLen];
            // 初始化
            dp[0][0] = grid[0][0];
            // 最上面的一行
            for (int i = 1; i < columnLen; i++) {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }
            // 最左边一列
            for (int i = 1; i < rowLen; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
            for (int i = 1; i < rowLen; i++) {
                for (int j = 1; j < columnLen; j++) {
                    // 左上均不是边界的情况，当前点(i,j)的左边或者上边，哪个路径小就选择哪个，然后加上当前点的值
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
//            for (int i = 0; i < dp.length; i++) {
//                for (int j = 0; j < dp[0].length; j++) {
//                    System.out.print(dp[i][j] + " ");
//                }
//                System.out.println();
//            }
            return dp[rowLen - 1][columnLen - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}