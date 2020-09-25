//给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。 
//
// 示例 1: 
//
// 
//输入: [3, 2, 1]
//
//输出: 1
//
//解释: 第三大的数是 1.
// 
//
// 示例 2: 
//
// 
//输入: [1, 2]
//
//输出: 2
//
//解释: 第三大的数不存在, 所以返回最大的数 2 .
// 
//
// 示例 3: 
//
// 
//输入: [2, 2, 3, 1]
//
//输出: 1
//
//解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
//存在两个值为2的数，它们都排第二。
// 
// Related Topics 数组


package leetcode.editor.cn;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

//Java：第三大的数
public class P414ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{-2147483648, 2, 5};
        Solution solution = new P414ThirdMaximumNumber().new Solution();
        int thirdMax = solution.thirdMax(nums);
        System.out.println(thirdMax);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 使用大顶堆+集合
         * <p>
         * <p>
         * 设计算法
         * 1 时间复杂度要求是n，因此不能使用大顶堆
         * 2 三个变量存储min,mid,max，并初始化为首元素
         * 3 迭代数组，判断元素与
         * <p>
         * 测试用例
         *
         * @param nums
         * @return
         */
        public int thirdMax(int[] nums) {

            HashSet<Integer> set = new HashSet<>();
            for (int ele : nums) {
                set.add(ele);
            }

            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            for (int ele : set) {
                if (queue.size() > 3) {
                    queue.poll();
                }
                queue.offer(ele);
            }
            if (queue.size() > 2) {
                // 长度>=3
                // 获取第三大的数字
                queue.poll();
                queue.poll();
                return queue.poll();
            }
            if (queue.size() > 0 && queue.size() < 3) {
                // 长度大于0，小于3，获取最大数字
                return queue.poll();
            }
            return Integer.MAX_VALUE;
        }


        /**
         * 找三次
         * 不方法有bug
         * 如果数组中包含Long.MIN_VALUE，例如[1,2,Long.MIN_VALUE]
         * 此题还会有问题。
         *
         * @param nums
         * @return
         */
        public int thirdMax1(int[] nums) {
            long max1 = Long.MIN_VALUE;
            long max2 = Long.MIN_VALUE;
            long max3 = Long.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                max1 = Math.max(max1, nums[i]);
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == max1) {
                    continue;
                }
                max2 = Math.max(max2, nums[i]);
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == max1 || nums[i] == max2) {
                    continue;
                }
                max3 = Math.max(max3, nums[i]);
            }
            return (int) (max3 == Long.MIN_VALUE ? max1 : max3);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}