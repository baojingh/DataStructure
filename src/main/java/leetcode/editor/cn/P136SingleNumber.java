//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：只出现一次的数字
public class P136SingleNumber {
    public static void main(String[] args) {
        Solution solution = new P136SingleNumber().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Integer integer = map.get(nums[i]);
                if (integer == null) {
                    map.put(nums[i], 1);
                } else {
                    map.put(nums[i], integer + 1);
                }
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }
            }
            return Integer.MIN_VALUE;
        }






















        /**
         * 解释题意
         * 1 整型数组
         * 2 只有一个元素出现了一次，其他元素出现两次
         * 3 找到那个唯一的元素
         * 4 空间复杂度要求O(1)，时间复杂度是O(n)
         * <p>
         * 设计算法
         * 原始方案：
         * 1 迭代数组，如果map中不存在此元素，就添加到map，<key,0>，如果存在就将key对应的value置为<key,1>
         * 2 再次迭代数组，如果key对应的value是1，就返回相应的key
         * <p>
         * 异或方案
         * 异或性质：
         * 1）一个数字和0异或【xor，^】，结果是其本身
         * 2）一个数字和其本身异或，结果是0
         * 3）异或满足交换律和结合律:a^b^b^c^a = (a^a)^(b^b)^c=0^0^c=0^c=c
         * 0逐个与数组中的每个数字异或操作，剩余的就是只出现一次的那个数字
         *
         * <p>
         * 1
         * 测试用例
         * 1 []
         * 2 null
         * 3 1
         * 4 1-2-3
         * 5 1-2-3-1
         *
         * @param nums
         * @return
         */
        public int singleNumber_1(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int res = 0;
            for (int num : nums) {
                res = res ^ num;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}