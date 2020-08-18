//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
// 也可能是 无限循环 但始终变不到 1。
//如果 可以变为 1，那么这个数就是快乐数。 
//
// 如果 n 是快乐数就返回 True ；不是，则返回 False 。 
//
// 
//
// 示例： 
//
// 输入：19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
// Related Topics 哈希表 数学


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//Java：快乐数
public class P202HappyNumber {
    public static void main(String[] args) {
        Solution solution = new P202HappyNumber().new Solution();
        boolean happy = solution.isHappy(19);
        System.out.println(happy);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 设计算法
         * 1 循环结束条件是什么？
         *      map是否出现过
         *
         * @param n
         * @return
         */
        public boolean isHappy(int n) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int sum = n;
            while (true) {
                // 把第一个数字也做处理
                if (map.containsKey(sum)) {
                    // 如果已经出现过这个数字，就说明已经死循环
                    return false;
                }
                if (sum == 1) {
                    // 没出现过，还要验证是否是满足需求的数字
                    return true;
                }
                // 添加到map
                map.put(sum, 1);
                // 计算下一轮数据
                sum = sum(sum);
            }
        }



        /**
         * 将整数拆分到列表中
         * @param n
         * @return
         */
        private List<Integer> decompose(int n) {
            ArrayList<Integer> list = new ArrayList<>();
            while (n > 0) {
                int low1 = n % 10;
                list.add(low1);
                n = n / 10;
            }
            return list;
        }

        /**
         * 计算拆分后的各位数字之和
         * 如果某个数字是Integer.MAX_VAL - 1,其各位数字平方之和一定会溢出
         *
         * @param n
         * @return
         */
        private int sum(int n) {
            int sum = 0;
            while (n > 0) {
                int low1 = n % 10;
                sum = sum + low1 * low1;
                n = n / 10;
            }
            return sum;
        }

        private int sum_1(int n) {
            List<Integer> list = decompose(n);
            int sum = 0;
            for (int ele : list) {
                sum = sum + ele * ele;
            }
            return sum;
        }










/*****************************************/

























        /***
         * 解释题意
         * 1 一个数字是不是快乐数，返回true/false
         * 2 将数字拆解，各个位分别平方和，是否是1
         * 3 如果是1就返回；如果不是1，最终会是一个死循环
         * 4 需要记录相加之和是否出现。
         *
         * 设计算法
         * 循环：true
         * 0 这个数字是否在集合中出现过，出现过就false，没出现过就加入集合，继续1
         * 1 拆解一个整数，分别将各位相加
         * 2 判断这个数的各位平方和是否是1
         * 3 是1，就返回true
         * 4 不是1，将平方之和作为新的数字
         * 5 继续循环
         *
         *
         *
         *
         * 测试用例
         * 1 0
         * 2 1
         * 3 10
         * 5 19
         * 6 14
         *
         * 复杂度分析
         * 时间复杂度: O()
         * 空间复杂度: O()
         *
         * @param n
         * @return
         */
        public boolean isHappy_1(int n) {
            HashSet<Integer> seenSet = new HashSet<>();
            int remainder = 0;
            int sum = 0;
            while (true) {
                // 结合中是否存在这个数
                if (seenSet.contains(n)) {
                    // 如果存在，说明已经走过了一圈，没有和是1的情况
                    return false;
                }
                // 将这个数字加入集合
                seenSet.add(n);
                sum = 0;
                while (n > 0) {
                    remainder = n % 10;
                    n = n / 10;
                    sum = sum + remainder * remainder;
                }
                if (sum == 1) {
                    return true;
                }
                // 将平方之和作为新的数字，继续拆解判断。
                n = sum;
            }
        }

        /**
         * https://leetcode-cn.com/problems/happy-number/solution/kuai-le-de-zhi-shi-dian-zeng-jia-liao-by-sweetiee/
         * <p>
         * 设计算法
         * <p>
         * <p>
         * <p>
         * 快慢指针
         *
         * @param n
         * @return
         */
        public boolean isHappy_2(int n) {
            return false;
        }

        /**
         * 求解一个数的各位数字平方和
         *
         * @param n
         * @return
         */
        private int sumOfnumber(int n) {
            int sum = 0;
            int remainder = 0;
            while (n > 0) {
                remainder = n % 10;
                n = n / 10;
                sum = sum + remainder * remainder;
            }
            return sum;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}