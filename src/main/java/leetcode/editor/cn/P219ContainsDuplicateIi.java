//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值
// 至多为 k。 
// 示例 1:
// 输入: nums = [1,2,3,1], k = 3
//输出: true 
// 示例 2:
// 输入: nums = [1,0,1,1], k = 1
//输出: true 
// 示例 3:
// 输入: nums = [1,2,3,1,2,3], k = 2
//输出: false 
// Related Topics 数组 哈希表
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：存在重复元素 II
public class P219ContainsDuplicateIi {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 1};
        Solution solution = new P219ContainsDuplicateIi().new Solution();
        boolean b = solution.containsNearbyDuplicate(nums, 2);
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 题目意思：长度是k的数组中，是否存在相同的元素
         * 1 判断集合中是否存在此元素，不存在就添加此元素
         * 2 如果集合元素个数超过k，将最前面元素删除，始终保持集合元素个数是k
         * 3 如果集合中包含此元素，就是满足题目条件
         * <p>
         * 优化点：
         * 可将集合换成长度是k的队列
         *
         * @param nums
         * @param k
         * @return
         */
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Set<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    return true;
                }
                set.add(nums[i]);
                if (set.size() > k) {
                    set.remove(nums[i - k]);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}