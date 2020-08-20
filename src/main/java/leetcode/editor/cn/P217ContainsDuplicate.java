//给定一个整数数组，判断是否存在重复元素。 
//
// 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。 
// 示例 1:
// 输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// Related Topics 数组 哈希表


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

//Java：存在重复元素
public class P217ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 2};
        Solution solution = new P217ContainsDuplicate().new Solution();
        boolean containsDuplicate = solution.containsDuplicate(nums);
        System.out.println(containsDuplicate);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 设计算法
         * 1 创建哈希集合
         * 2 迭代数组元素
         * 3 集合中是否存在，已经存在则在重复元素；不存在就添加这个元素，继续迭代
         * 4 循环结束条件是遍历完数组元素
         *
         * @param nums
         * @return
         */
        public boolean containsDuplicate(int[] nums) {
            if (nums == null) {
                return false;
            }
            HashSet<Integer> set = new HashSet<>();
            for (int ele : nums) {
                if (set.contains(ele)) {
                    return true;
                }
                set.add(ele);
            }
            return false;
        }





























        public boolean containsDuplicate_1(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Integer val = map.get(nums[i]);
                // map中不存在此元素，则放入map
                if (val == null) {
                    map.put(nums[i], 1);
                } else {
                    // 如果map存在此元素，说明本次循环又拿到了这个值，即重复值
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}