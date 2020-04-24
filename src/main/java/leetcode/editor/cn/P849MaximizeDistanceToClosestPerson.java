//在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。 
// 至少有一个空座位，且至少有一人坐在座位上。
// 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
// 返回他到离他最近的人的最大距离。
// 示例 1：
// 输入：[1,0,0,0,1,0,1]
//输出：2
//解释：
//如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
//如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
//因此，他到离他最近的人的最大距离是 2 。 
// 示例 2：
// 输入：[1,0,0,0]
//输出：3
//解释： 
//如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
//这是可能的最大距离，所以答案是 3 。
// 提示：
// 1 <= seats.length <= 20000
// seats 中只含有 0 和 1，至少有一个 0，且至少有一个 1。 
// 
// Related Topics 数组


package leetcode.editor.cn;

//Java：到最近的人的最大距离
public class P849MaximizeDistanceToClosestPerson {
    public static void main(String[] args) {
        int[] nums = new int[]{ 0, 1};
        Solution solution = new P849MaximizeDistanceToClosestPerson().new Solution();
        int i = solution.maxDistToClosest(nums);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 动态规划
         *
         * @param seats
         * @return
         */
        public int maxDistToClosest(int[] seats) {
            int len = seats.length;
            int leftIndex = 0;
            int leftCount = 0;

            int rightCount = 0;
            int rightIndex = len - 1;
            int midCount = 0;
            int midMax = 0;
            for (; leftIndex < len; leftIndex++) {
                if (seats[leftIndex] == 0) {
                    leftCount = leftCount + 1;
                } else {
                    break;
                }
            }
            for (; rightIndex > -1; rightIndex--) {
                if (seats[rightIndex] == 0) {
                    rightCount = rightCount + 1;
                } else {
                    break;
                }
            }
            for (int i = leftIndex + 1; i < rightIndex; i++) {
                if (seats[i] == 0) {
                    midCount = midCount + 1;
                    midMax = Math.max(midCount, midMax);
                } else {
                    midCount = 0;
                }
            }
            int tmp = Math.max(leftCount, rightCount);
            tmp = Math.max(tmp, (midMax + 1) / 2);
            return tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}