//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 8839 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

//Java：两数之和
public class P1TwoSum{
    public static void main(String[] args) {
        Solution solution = new P1TwoSum().new Solution();
        System.out.println();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 解释题意
         * 遍历所有的数字，时间复杂度O(n*n)
         * <p>
         * <p>
         * 设计算法
         * 1 map的key存储目标值target-当前数字的差值，value存储当前位置
         * 2 遍历数组，当前数字是否在map中，
         * 如果不存在就将target-val作为key，index作为value存入map
         * 如果存在，就说明找到了这个数字。
         * 返回这两个数字的下标
         * <p>
         * <p>
         * 测试用例
         * 1 1-2-3-4-5，6
         * 2 1-2-3-4-5，10
         * 3 1-2，3
         * 4 1，2
         * 6 1，1
         * 7 1-1，2
         * 8 null
         * <p>
         * <p>
         * <p>
         * 时间复杂度: O(n)
         * 空间复杂度：O(1)
         *
         * @param nums
         * @param target
         * @return
         */
        public int[] twoSum(int[] nums, int target) {
            int[] arr = null;
            if (nums == null) {
                return new int[2];
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Integer integer = map.get(nums[i]);
                if (integer == null) {
                    map.put(target - nums[i], i);
                } else {
                    arr = new int[]{i, integer};
                }
            }
            return arr;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}