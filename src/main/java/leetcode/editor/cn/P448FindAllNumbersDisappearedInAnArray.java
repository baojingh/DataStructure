//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。 
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：找到所有数组中消失的数字
public class P448FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        Solution solution = new P448FindAllNumbersDisappearedInAnArray().new Solution();
        List<Integer> list = solution.findDisappearedNumbers(nums);
        for (Integer b : list) {
            System.out.print(b + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 初始方案
         * 排序后，找规律，第二个重复的数字，其索引值+1就是缺失的元素
         * <p>
         * <p>
         * 设计算法
         * <p>
         * 缺点：
         * 排序的时间复杂度是O(nlogn)
         * <p>
         * 测试用例
         * 1 1,2,2,4,5,6,6,8,8,10
         *
         * @param nums
         * @return
         */
        public List<Integer> findDisappearedNumbers1(int[] nums) {
            LinkedList<Integer> list = new LinkedList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    list.add(i + 2);
                }
            }
            return list;
        }

        public List<Integer> findDisappearedNumbers(int[] nums) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                // 数组元素取值范围是1~n,转换成0~n-1，方便根据这个索引取值做标记。
                // 这个标记肯定会缺少那些缺失的数字，例如1,4,2,5,2转换成0，3，1，4，1肯定会缺少2，即3
                // 注意此时nums[i]的正负
                int index = Math.abs(nums[i]) - 1;
                if (nums[index] > 0) {
                    nums[index] = nums[index] * (-1);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    list.add(i + 1);
                }
            }
            return list;
        }



















        public List<Integer> findDisappearedNumbers2(int[] nums) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int index = Math.abs(nums[i]) - 1;
                if (nums[index] > 0) {
                    nums[index] = nums[index] * (-1);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    list.add(i + 1);
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}