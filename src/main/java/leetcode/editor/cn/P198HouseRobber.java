//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
// 如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划


package leetcode.editor.cn;

//Java：打家劫舍
// https://leetcode.cn/problems/house-robber/solutions/12115/hua-jie-suan-fa-198-da-jia-jie-she-by-guanpengchn/
public class P198HouseRobber {
    public static void main(String[] args) {
        Solution solution = new P198HouseRobber().new Solution();
        int[] nums = new int[]{3, 1, 2, 4};
        int rob = solution.rob(nums);
        System.out.println(rob);
    }


    /*
    *  使用归纳演绎的办法： 3 1 2 4
     *  打劫第0家房子，收益dp[0]=0
     *  打劫第1家房子，收益dp[1]=num[0]=3
     *
    * 标签：动态规划
        动态规划方程：dp[n] = MAX( dp[n-1], dp[n-2] + num )
        由于不可以在相邻的房屋闯入，所以在当前位置 n 房屋可盗窃的最大值，要么就是 n-1 房屋可盗窃的最大值，要么就是 n-2 房屋可盗窃的最大值加上当前房屋的值，二者之间取最大值
        举例来说：1 号房间可盗窃最大值为 3 即为 dp[1]=3，2 号房间可盗窃最大值为 4 即为 dp[2]=4，3 号房间自身的值为 2 即为 num=2，那么 dp[3] = MAX( dp[2], dp[1] + num ) = MAX(4, 3+2) = 5，3 号房间可盗窃最大值为 5
        时间复杂度：O(n)，n 为数组长度
    *
    *
    * */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int len = nums.length;
            if (len == 0)
                return 0;
            int[] dp = new int[len + 1];
            dp[0] = 0;
            dp[1] = nums[0];
            for (int i = 2; i <= len; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
            }
            return dp[len];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}