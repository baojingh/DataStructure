//给定一个二进制数组， 计算其中最大连续1的个数。 
//
// 示例 1: 
//
// 
//输入: [1,1,0,1,1,1]
//输出: 3
//解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
// 
//
// 注意： 
//
// 
// 输入的数组只包含 0 和1。 
// 输入数组的长度是正整数，且不超过 10,000。 
// 
// Related Topics 数组


package leetcode.editor.cn;

//Java：最大连续1的个数
public class P485MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 0, 1};
        Solution solution = new P485MaxConsecutiveOnes().new Solution();
        int solutionMaxConsecutiveOnes = solution.findMaxConsecutiveOnes(nums);
        System.out.println(solutionMaxConsecutiveOnes);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 设计算法
         * 1 初始化max=0，累加变量count=0，迭代数组元素
         * 2 如果元素是1，就count++
         * 3 如果元素是0，count=0
         * 4 取max与count的最大值赋值给max
         * 5 迭代结束，max就是最终结果
         *
         *
         * 测试用例
         * 1 0
         * 2 1
         * 3 1,1,1
         * 4 1,1,0,1,0,0
         * 5 0,0,0,1,1,1
         * 6 1,0,1,1,0,1
         * 7 0,1,1,0,1,1,1
         *
         * @param nums
         * @return
         */
        public int findMaxConsecutiveOnes1(int[] nums) {
            int count = 0;
            int max = 0;
            for (int ele : nums) {
                if (ele == 1) {
                    count = count + 1;
                } else {
                    count = 0;
                }
                max = Math.max(max, count);
            }
            return max;
        }























        public int findMaxConsecutiveOnes(int[] nums) {
            int count = 0;
            int maxCount = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    count = count + 1;
                    maxCount = Math.max(maxCount, count);
                } else {
                    count = 0;
                }
            }
            return maxCount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}