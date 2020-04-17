//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
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
        public int majorityElement(int[] nums) {
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