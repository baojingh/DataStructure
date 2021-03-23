//有一堆石头，每块石头的重量都是正整数。 
//
// 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下： 
//
// 
// 如果 x == y，那么两块石头都会被完全粉碎； 
// 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。 
// 
//
// 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。 
//
// 
//
// 示例： 
//
// 
//输入：[2,7,4,1,8,1]
//输出：1
//解释：
//先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
//再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
//接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
//最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 30 
// 1 <= stones[i] <= 1000 
// 
// Related Topics 堆 贪心算法 
// 👍 154 👎 0


package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

//Java：最后一块石头的重量
public class P1046LastStoneWeight {
    //public class JianZhiLastStoneWeight{
    public static void main(String[] args) {
        Solution solution = new P1046LastStoneWeight().new Solution();
        int[] arr = {1};
        int i = solution.lastStoneWeight(arr);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 1. 使用大顶堆，存放数组所有数据
         * 2. 迭代堆中元素，
         * 2. 弹出前两个数字，如果等于0，则不添加，继续从堆中弹出前两个比较
         * 3. 如果不等于0，差值放入堆中继续迭代
         * 4. 如果堆中只有一个元素，就返回这个元素；如果堆中没有元素，就返回0
         * <p>
         * 测试用例
         * 1. 2, 7, 4, 1, 8, 1
         * 2. 1,2,3
         *
         * @param stones
         * @return
         */
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            for (int ele : stones) {
                heap.add(ele);
            }
            while (heap.size() > 1) {
                /**
                 * 出队列的两个值肯定是"大-小"顺序
                 */
                Integer max = heap.poll();
                Integer min = heap.poll();
                if (max == min) {
                    continue;
                }
                heap.offer(max - min);
            }
            if (heap.size() == 1) {
                return heap.poll();
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}