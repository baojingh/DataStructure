//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
// 示例 1:
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法


package leetcode.editor.cn;

import java.util.Arrays;

//Java：多数元素
public class P169MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 3, 3, 4, 4, 3};
        Solution solution = new P169MajorityElement().new Solution();
        int majorityElement = solution.majorityElement(nums);
        System.out.println(majorityElement);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 设计算法
         * 0 使用map存储每个元素出现的次数，遍历val，判断哪个元素的出现次数超过半数。
         * 0 排序数组，使用双指针统计每个元素出现的次数以及对应的元素
         * 0 将数组排序，一个元素出现次数大于一半，说明这个数组中间位置的数字一定是目标元素
         * <p>
         * <p>
         * 1 题目要求一定存在这样一个元素；只会有一个元素是多数元素
         * 2 摩尔投票法https://leetcode-cn.com/problems/majority-element/solution/tu-jie-mo-er-tou-piao-fa-python-go-by-jalan/
         * 3 设定第一个元素num出现次数count是1
         * 4 如果上一个元素不同于当前元素,count--
         * 5 如果count=0，当前元素作为基准元素，count=1
         * 6 迭代结束，基准元素就是多数元素
         *
         * 测试用例
         * 1 1,1,1,2,3
         * 2 1,2,2
         * 3 1,2,3
         * 4 1,1
         * 5 1
         *
         * <p>
         * <p>
         * 测试用例
         *
         * @param nums
         * @return
         */
        public int majorityElement(int[] nums) {
            int base = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (base != nums[i]) {
                    count = count - 1;
                }else {
                    count = count + 1;
                }
                if (count == 0) {
                    base = nums[i];
                    count = 1;
                }
            }
            return base;
        }




        public int majorityElement2(int[] nums) {
            Arrays.sort(nums);
            return nums[(nums.length >> 1)];
        }
























        /**
         * 摩尔投票法：寻找数组中超过半数的数字，此数字出现的次数一定大于其余数字出现的次数之和，两部分相加之和大于0。
         * candidate数字与之前的数字比较：
         * 如果与之前数字相等，count++
         * 如果不等，count--
         * 如果count==0，则将candidate设置成当前值，继续循环
         * 直到循环结束，获取candicate就是目标值
         *
         * @param nums
         * @return
         */
        public int majorityElement1(int[] nums) {
            int cadidate = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (cadidate == nums[i]) {
                    count = count + 1;
                } else {
                    count = count - 1;
                }
                if (count == 0) {
                    cadidate = nums[i];
                    count = 1;
                }
            }
            return cadidate;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}