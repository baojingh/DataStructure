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
        int[] nums = new int[]{1};
        Solution solution = new P643MaximumAverageSubarrayI().new Solution();
        double average = solution.findMaxAverage(nums, 1);
        System.out.println(average);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 设计算法
         * 1 创建索引index，[0~n-k+1)，记录k个数的平均值，与max比较
         * 2 index继续前进，与max比较
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
            double max = 0d;
            // 初始化max
            for (int i = 0; i < k; i++) {
                max = max + nums[i];
            }

            for (int i = 1; i < nums.length - k + 1; i++) {
                double avg = 0d;
                for (int j = 0; j < k; j++) {
                    avg = avg + nums[i + j];
                }
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