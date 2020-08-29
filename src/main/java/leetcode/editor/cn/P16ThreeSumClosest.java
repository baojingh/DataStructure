//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
// 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
// 
// Related Topics 数组 双指针


package leetcode.editor.cn;

import java.util.Arrays;

//Java：最接近的三数之和
public class P16ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new P16ThreeSumClosest().new Solution();
        int[] nums = new int[]{1,2,3,4,5,6};
        int i = solution.threeSumClosest(nums, 12);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 设计算法
         * 1 控制变量法，迭代数组中的元素
         * 1.1 选择第一个元素，设置left，right指针分别指向i+1,len-1
         * 1.2 分别计算他们三数之和
         * 1.3 如果偏大，right左移；如果偏小，left右移；如果相等，就返回，记录这次的三数之和，和下一次做比较。结束条件是left==right
         * 1.4 结束条件是迭代完成数组元素
         *
         * @param nums
         * @param target
         * @return
         */
        public int threeSumClosest(int[] nums, int target) {
            if (nums == null || nums.length < 3) {
                return Integer.MAX_VALUE;
            }
            Arrays.sort(nums);
            int len = nums.length;
            int sumResult = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < len - 2; i++) {
                int base = nums[i];
                int left = i + 1;
                int right = len - 1;
                while (left < right) {
                    int tmp = base + nums[right] + nums[left];
                    if (tmp == target) {
                        return tmp;
                    } else if (tmp > target) {
                        right = right - 1;
                    } else if (tmp < target) {
                        left = left + 1;
                    }
                    if (Math.abs(tmp - target) <= Math.abs(sumResult - target)) {
                        sumResult = tmp;
                    }
                }
            }
            return sumResult;
        }
















        /**
         * 三指针法：
         * 类似求解三数之和
         * 1 对数组排序
         * 2 找到base，然后再找到前后指针
         * 3 三个数字相加，判断与target的距离，取绝对值，还需要选一个基准值作为三数之和
         * 4 基准值与三数之和比较，选较小的值保存下来，如果后续没更小的，则返回这个值。
         * 5 如果三数之和大于target，则右指针左移；反之右移；如果相等则直接返回
         *
         * @param nums
         * @param target
         * @return
         */
        public int threeSumClosest_1(int[] nums, int target) {
            Arrays.sort(nums);
            int len = nums.length;
            // 选基准值
            int ans = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < len - 1; i++) {
                int base = nums[i];
                int left = i + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = base + nums[left] + nums[right];
                    // 保存距离最小的值；如果不满足条件，表示当前的ans就是最小的
                    if (Math.abs(target - sum) < Math.abs(target - ans)) {
                        ans = sum;
                    }
                    if (sum > target) {
                        right = right - 1;
                    } else if (sum < target) {
                        left = left + 1;
                    } else {
                        // 距离是0，可以直接返回
                        return ans;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}