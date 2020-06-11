//给定两个数组，编写一个函数来计算它们的交集。 
//
// 示例 1: 
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2,2]
// 
//
// 示例 2: 
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [4,9] 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶: 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

//Java：两个数组的交集 II
public class P350IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new P350IntersectionOfTwoArraysIi().new Solution();
        int[] nums1 = new int[]{1, 1, 2, 2};
        int[] nums2 = new int[]{2, 2};
        int[] intersect = solution.intersect(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解释题意
         * 1 两个数组中，每个数组中可能包含重复元素
         * 2 两个数组的相交元素，相交元素可能是重复的
         * <p>
         * 设计算法
         * 1 选择一个数组，计算每个元素出现的次数
         * 2 遍历另一个数组，这个元素是否在map中
         * 3 如果不存在，就迭代下一个元素
         * 4 如果存在，判断这个数字对应的val是否是0
         * 5 如果val不是0，就将此元素加入列表
         * 6 如果val是0，说明公共元素已经找完了
         * 7 返回列表
         * <p>
         * 测试用例
         * 1 1-2-3-2-3-4，2-2-2-3-5-6
         * 2 1-2-3，4-5-6
         * 3 1，1
         * 4 1-2-3，1-2-3
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public int[] intersect(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> map = new HashMap<>();
            // 计算每个数字出现的次数，如果供哦你个元素是重复的，可以使用次数判断是否输出完成
            int val = 1;
            for (int num : nums1) {
                val = 1;
                if (map.get(num) != null) {
                    val = map.get(num) + 1;
                }
                map.put(num, val);
            }
            // 存储公共元素
            LinkedList<Integer> list = new LinkedList<>();
            for (int num : nums2) {
                // 是否交集
                Integer tmp = map.get(num);
                if (tmp != null) {
                    if (tmp > 0) {
                        map.put(num, tmp - 1);
                        // 存在交集，就将此元素添加
                        list.add(num);
                    }
                }
            }
            // 列表长度
            int len = list.size();
            int[] ints = new int[len];
            for (int i = 0; i < len; i++) {
                // 移除并返回末尾元素
                ints[i] = list.poll();
            }
            return ints;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}