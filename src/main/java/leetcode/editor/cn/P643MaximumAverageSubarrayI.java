//给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。 
// 示例 1:
// 输入: [1,12,-5,-6,50,3], k = 4
//输出: 12.75
//解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
// 注意:
// 1 <= k <= n <= 30,000。
// 所给数据范围 [-10,000，10,000]。 
// Related Topics 数组


package leetcode.editor.cn;

//Java：子数组最大平均数 I
public class P643MaximumAverageSubarrayI {
    public static void main(String[] args) {
        int[] nums = new int[]{4,2,1,3,3};
        Solution solution = new P643MaximumAverageSubarrayI().new Solution();
        double average = solution.findMaxAverage(nums, 2);
        System.out.println(average);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 设计算法
         * 1 计算数组中k个连续数字的累加和最大
         * 2 向前移动一个位置，不可以将k个数字累加，此方案效率很低，可以将当前的和去头加尾，获取max
         * 3 注意：使用前k个数字初始化，迭代范围是[1,len - k + 1)
         *
         *
         *
         * <p>
         * <p>
         * 测试用例
         * 1 1 2
         * 2 2 1
         * 3 1,2,3,4 4
         * 4 1,2,3,4,5
         *
         * @param nums
         * @param k
         * @return
         */
        public double findMaxAverage(int[] nums, int k) {
            if (k < 1) {
                return 0.0d;
            }
            double max = 0d;
            // 初始化max
            for (int i = 0; i < k; i++) {
                max = max + nums[i];
            }
            double avg = max;
            for (int i = 1; i < nums.length - k + 1; i++) {
                // 不可for循环累加k个数字，否则超时
                avg = avg - nums[i - 1] + nums[i + k - 1];
                max = Math.max(max, avg);
            }
            return max / k;
        }





































        /**
         * 滑动窗口
         * 从i～i+k的和sum1，滑动到i+1～i+k-1的和是sum2，sum2=sum1 + num[i+k-1] - num[i]
         * 1 2 3 4 5 6 7
         * s     e
         * s     e
         *
         * @param nums
         * @param k
         * @return
         */
        public double findMaxAverage1(int[] nums, int k) {
            int len = nums.length;
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum = sum + nums[i];
            }
            // 数组只有一个元素，保留下来
            int temp = sum;
            for (int i = 1; i < len - k + 1; i++) {
                sum = sum + nums[i + k - 1] - nums[i - 1];
                temp = Math.max(sum, temp);
            }
            double average = (double) temp / k;
            return average;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}