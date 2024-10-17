//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 示例 1:
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 提示： 
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
        int[] nums = new int[]{1, 0, 3, 0, 3, 4, 3};
        int[] ints = solution.topKFrequent(nums, 2);
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 设计算法
         * 1 使用map存储元素以及其出现的次数
         * 2 使用长度是k的小顶堆存储每个元素，按照其出现次数排序，降序排列
         * 3 迭代完map中的元素，堆中就是目标元素
         * <p>
         * 测试用例
         * 1 1,2,3,4,5,2,3,1 2
         * 1 1,2,3 1
         * 1 1,2,3 2
         * 1 1,2,3 3
         * 1 1,2,3 4
         * 2 1 1
         * 2 1 2
         * 2 1,1 2
         * 2 1,1 1
         * 3 null
         *
         * @param nums
         * @param k
         * @return
         */
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return map.get(o1) - map.get(o2);
                }
            });
            if (nums == null || k < 0) {
                return new int[0];
            }
            for (int ele : nums) {
                Integer orDefault = map.getOrDefault(ele, 0);
                map.put(ele, orDefault + 1);
            }
            for (int key : map.keySet()) {
                // 堆的长度是k，也是一个优化点，不需要把所有的元素都存入堆中
                // 现添加，后移除就可以确保堆中元素是k个
                heap.offer(key);
                // 确保堆中有k个元素
                if (heap.size() > k) {
                    // 堆中正好有k + 1个元素，就移除最小的堆顶，为后续的元素添加作准备
                    heap.poll();
                }
            }
            if (k >= heap.size()) {
                // 如果实际元素个数没有k个，那就按照实际个数输出
                k = heap.size();
            }
            int[] kArr = new int[k];
            for (int i = 0; i < k; i++) {
                // 直接获取heap中的元素，如果使用k未限制条件，有可能k大于堆元素个数，导致poll空指针
                // 此处的k已经在上文做过限制
                kArr[i] = heap.poll();
            }
            return kArr;
        }


        /**
         * 解释题意
         * 1 数组中，每个数字会出现多次，按照从高到低排序，取前k个
         * <p>
         * 设计算法
         * 1 hashmap存储每个数字对应的出现次数
         * 2 创建小顶堆，小顶堆的长度是k，存放的顺序是比较这个数字出现的次数。
         * 3 先添加元素【add】，如果堆长度大于k，就移除堆头部元素即出现次数最小的元素【remove/poll】；长度小于k，就继续循环。
         * 4 所有数字添加完成，小顶堆也就创建完成
         * 5 输出
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
        public int[] topKFrequent_1(int[] nums, int k) {
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
            // 创建小顶堆
            // 底层基于链表，只能设置初始长度，不能设置固定大小的堆。
            // 优先队列的作用是能保证每次取出的元素都是队列中权值最小的，Java的优先队列每次取最小元素
            PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    int tmp = map.get(o1) - map.get(o2);
                    return tmp;
                }
            });
            // 添加到堆中，完成堆化
            // 数组中有几个不同的key，堆中就有多少个元素，这些元素是按照其在map中的出现次数排序
            for (int num : map.keySet()) {
                // 先添加，保证了堆的顺序，然后在做删除
                // 堆中存放k个元素
                heap.add(num);
                if (heap.size() > k) {
                    // 移除队列头部元素
                    heap.poll();
                }
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



























