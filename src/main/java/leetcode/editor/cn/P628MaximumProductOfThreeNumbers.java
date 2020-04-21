//给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。 
// 示例 1:
//输入: [1,2,3]
//输出: 6
// 示例 2:
//输入: [1,2,3,4]
//输出: 24
// 注意:
// 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
// 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。 
// Related Topics 数组 数学


package leetcode.editor.cn;

//Java：三个数的最大乘积
public class P628MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 3, 4, -5, 2, 1};
        Solution solution = new P628MaximumProductOfThreeNumbers().new Solution();
        int maximumProduct = solution.maximumProduct(nums);
        System.out.println(maximumProduct);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 考虑正负数的问题
         * 如果对数组排序
         * 1 全部正数情况，三个数字的最大乘积就是最后的三个数
         * 2 有负数情况
         * 如果只有一个负数，最大值是最后三个数乘积
         * 如果两个负数，最大值是(最后三个数乘积，前两个负数*最后的一个正数)
         * <p>
         * <p>
         * 如果不排序，还是计算max(两个最小值*一个最大值, 三个最大值乘积)
         *
         * @param nums
         * @return
         */
        public int maximumProduct(int[] nums) {
            int len = nums.length;
            if (len < 3) {
                return 0;
            }
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            int max3 = Integer.MIN_VALUE;
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            for (int num : nums) {
                if (min1 > num) {
                    min2 = min1;
                    min1 = num;
                } else if (num < min2) {
                    min2 = num;
                }
                if (num > max3) {
                    max1 = max2;
                    max2 = max3;
                    max3 = num;
                } else if (num > max2) {
                    max1 = max2;
                    max2 = num;
                } else if (num > max1) {
                    max1 = num;
                }
            }
            int a = min1 * min2 * max3;
            int b = max1 * max2 * max3;
            return Math.max(a, b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}