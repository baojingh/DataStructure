//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

//Java：前 K 个高频元素
public class P347TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new P347TopKFrequentElements().new Solution();
        int[] nums = new int[]{};
        int[] ints = solution.topKFrequent(nums, 3);
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解释题意
         * 1 数组中，每个数字会出现多次，按照从高到低排序，取前k个
         * <p>
         * 设计算法
         * 1 hashmap存储每个数字对应的出现次数
         * 2 创建最大堆，存放频率是前k的数字，存放标准是比较这个数字出现的次数。
         * 3 所有数字添加完成，最大堆也就创建完成
         * 4 输出
         * <p>
         * 测试用例
         * 0 1，2，3，2，4，3
         * 1 1，1 2
         * 2 1，2 2
         * 3 1，2，1 1
         *
         * @param nums
         * @param k
         * @return
         */
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            // 统计每个数字出现的次数
            for (int num : nums) {
                if (map.get(num) == null) {
                    // 数字不存在于map中
                    map.put(num, 1);
                } else {
                    // 数字存在map中，取出次数并且加1
                    int tmp = map.get(num);
                    map.put(num, tmp + 1);
                }
            }
            // 创建大顶堆
            // 底层基于链表，只能设置初始长度，不能设置固定大小的堆。
            PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    int tmp = map.get(o2) - map.get(o1);
                    return tmp;
                }
            });
            // 添加到堆中，完成堆化
            // 数组中有几个不同的key，堆中就有多少个元素，这些元素是按照其在map中的出现次数排序
            for (int num : map.keySet()) {
                heap.add(num);
            }
            // 转换成数组
            // 此处最好返回列表
            if (k > heap.size()) {
                return null;
            }
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = heap.poll();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}



























