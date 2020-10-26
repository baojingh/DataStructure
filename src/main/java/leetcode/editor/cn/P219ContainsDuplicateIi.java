//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，
// 并且 i 和 j 的差的 绝对值
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

import com.sun.tools.internal.ws.processor.generator.ServiceGenerator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//Java：存在重复元素 II
public class P219ContainsDuplicateIi {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 1};
        Solution solution = new P219ContainsDuplicateIi().new Solution();
        boolean b = solution.containsNearbyDuplicate_1(nums, 1);
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         *
         * 设计算法
         * 1 使用map存储元素对应的索引
         * 2 判断元素是否在map中，如果不存在就添加，存在就将两个索引比较。
         * 3 差值<=k，就返回true
         * 4 迭代完所有元素，没有发现目标，也返回false
         *
         * 测试用例
         *
         * @param nums
         * @param k
         * @return
         */
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Integer integer = map.get(nums[i]);
                if (integer == null) {
                    map.put(nums[i], i);
                } else {
                    if (Math.abs(i - integer) > k) {
                        return false;
                    } else {

                    }
                }
            }
            return false;
        }































        /**
         * 设计算法
         * 1 使用hash表存储数组元素以及相应的索引
         * 2 如果不存在，舅加入map
         * 2 如果元素已存在，比较两个索引是否满足条件，满足就返回，不满足需要更新元素在map中的值，处理(1,0,1,1 1)的情况
         * 3 迭代结束条件是元素是否已迭代完成
         * <p>
         * 测试用例
         * 1 1,2,3 2
         * 2 1,1,1 1
         * 3 1,1 2
         * 4 1 2
         * 5 1,2,4,2 2
         *
         * @param nums
         * @param k
         * @return
         */
        public boolean containsNearbyDuplicate1(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Integer integer = map.get(nums[i]);
                if (integer != null) {
                    int gap = Math.abs(integer - i);
                    if (gap <= k) {
                        return true;
                    }
                }
                // 更新重复元素在map中的kv
                map.put(nums[i], i);
            }
            return false;
        }


        /**
         * 设计算法
         * 1 迭代数组，存入map，key是元素值，value是其索引值
         * 2 判断元素是否在map中，如果不在就加入map
         * 3 如果存在
         * 判断其索引值差值<=k，return true
         * 判断其索引值差值>k，将现在的index索引值保存，继续迭代
         * 4 迭代结束条件是遍历完数组元素
         * <p>
         * 测试用例
         * 1 1,2,3,4,5,6 1
         * 2 1,2,1,4,5,6 1
         * 3 1,2,1,4,5,6 2
         * 4 1,2,1,4,5,6 3
         * 5 1,2,1,1,5,6 3
         * 6 1,1,1,1,1,1 1
         * 6 1,1,1,1,1,1 0
         * 6 1 0
         *
         * @param nums
         * @param k
         * @return
         */
        public boolean containsNearbyDuplicate2(int[] nums, int k) {
            if (nums == null || k < 1) {
                return false;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Integer integer = map.get(nums[i]);
                if (integer == null) {
                    map.put(nums[i], i);
                } else {
                    if (Math.abs(i - integer) <= k) {
                        // 只要存在即可
                        return true;
                    }
                    map.put(nums[i], i);
                }
            }
            return false;
        }


        /**
         * 题目意思：长度是k的数组中，是否存在相同的元素
         * 1 判断集合中是否存在此元素，不存在就添加此元素
         * 2 如果集合元素个数超过k，将最前面元素删除，始终保持集合元素个数是k
         * 3 如果集合中包含此元素，就是满足题目条件
         * <p>
         * 优化点：
         * 可将集合换成长度是k的队列
         * <p>
         * 窗口长度是k，
         *
         * @param nums
         * @param k
         * @return
         */
        public boolean containsNearbyDuplicate_1(int[] nums, int k) {
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