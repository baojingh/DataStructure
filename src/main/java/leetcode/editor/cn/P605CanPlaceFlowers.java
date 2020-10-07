//假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。 
//
// 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？
// 能则返回True
//，不能则返回False。 
// 示例 1:
//输入: flowerbed = [1,0,0,0,1], n = 1
//输出: True
// 示例 2:
//输入: flowerbed = [1,0,0,0,1], n = 2
//输出: False
// 注意:
// 数组内已种好的花不会违反种植规则。
// 输入的数组长度范围为 [1, 20000]。 
// n 是非负整数，且不会超过输入数组的大小。 
// 
// Related Topics 数组


package leetcode.editor.cn;

//Java：种花问题
public class P605CanPlaceFlowers {
    public static void main(String[] args) {
        int[] nums = new int[]{0};
        Solution solution = new P605CanPlaceFlowers().new Solution();
        boolean placeFlowers = solution.canPlaceFlowers(nums, 1);
        System.out.println(placeFlowers);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         *
         * 设计算法
         * 0 索引0，1，以及最后两个位置，要特殊判断
         * 1 迭代数组
         * 2 前一个位置以及后一个位置均是0，代表可以种花
         * 3 如果已种植，就继续前进
         * 4 到达len-1位置就停止，判断count是否等于0，不等于0就说明没有种完
         *
         *
         * 测试用例
         * 1 1,1,1,1
         * 2 0,0,0
         * 3 0,0
         * 4 0
         * 5 0,0,1,0,0,1,0,0,0,0,0,1,0,0
         *
         *
         *
         * @param flowerbed
         * @param n
         * @return
         */
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            return false;
        }

























        public boolean canPlaceFlowers1(int[] flowerbed, int n) {
            int count = 0;
            for (int i = 0; i < flowerbed.length; i++) {
                if (
                        (i == 0 || flowerbed[i - 1] == 0) &&
                                flowerbed[i] == 0 &&
                                ((i == flowerbed.length - 1) || flowerbed[i + 1] == 0)
                ) {
                    /**
                     *  前一个位置是0，当前位置是0，后一个位置也是0，即满足条件
                     *  1 如果找到了这个位置，指针向前移动两个位置；如果没找到这个位置，指针向前移动一个位置
                     *  2 特殊情况：数组第一个是0，可以使用i==0代替；最后一个位置使用i==nums.length-1代替
                     *
                     */
                    flowerbed[i] = 1;
                    i = i + 1;
                    count = count + 1;
                }
                if (count >= n) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}