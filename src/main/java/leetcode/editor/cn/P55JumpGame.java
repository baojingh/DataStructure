//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组


package leetcode.editor.cn;

//Java：跳跃游戏
public class P55JumpGame {
    public static void main(String[] args) {
        int[] nums = new int[]{2,0,0};
        Solution solution = new P55JumpGame().new Solution();
        boolean b = solution.canJump(nums);
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 从当前位置能够到达某一个位置，那么从当前位置都可以到达某一位置左侧的所有位置
         * 思路：尽可能到达最远位置（贪心）。
         * 方法：初始化最远位置为0，然后遍历数组，如果当前位置能到达，并且当前位置+跳数>最远位置，就更新最远位置。最后比较最远位置和数组长度。
         * 复杂度：时间复杂度O(n)，空间复杂度O(1)。
         * 链接：https://leetcode-cn.com/problems/jump-game/solution/pythonji-bai-97kan-bu-dong-ni-chui-wo-by-mo-lan-4/
         * 来源：力扣（LeetCode）
         *
         * @param nums
         * @return
         */
        public boolean canJump(int[] nums) {
            int max = 0;
            int end = nums.length - 1;
            for (int i = 0; i < nums.length; i++) {
                int tmp = i + nums[i];
                if (max >= i && tmp >= max) {
                    max = tmp;
                    if (max >= end) {
                        return true;
                    }
                }

            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}