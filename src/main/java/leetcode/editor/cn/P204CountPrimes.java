//统计所有小于非负整数 n 的质数的数量。 
//
// 示例: 
//
// 输入: 10
//输出: 4
//解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
// Related Topics 哈希表 数学


package leetcode.editor.cn;

import java.util.Arrays;

//Java：计数质数
public class P204CountPrimes {
    public static void main(String[] args) {
        Solution solution = new P204CountPrimes().new Solution();
        int countPrimes = solution.countPrimes(10);
        System.out.println(countPrimes);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 统计的是<n
         * 1不计算在内
         * n=5,结果是2，3
         * n=4,结果是2，3
         * n=3,结果是2
         * n=2,结果是0个
         *
         *
         *
         * https://leetcode-cn.com/problems/count-primes/solution/ru-he-gao-xiao-pan-ding-shai-xuan-su-shu-by-labula/
         * @param n
         * @return
         */
        public int countPrimes(int n) {
            int count = 0;
            // 默认是false
            boolean[] flag = new boolean[n];
            for (int i = 2; i < Math.sqrt(n); i++) {
                if (!flag[i]) {
                    for (int j = i * i; j < n; j = j + i) {
                        flag[j] = true;
                    }
                }
            }
            for (int i = 2; i < n; i++) {
                if (!flag[i]) {
                    count = count + 1;
                }
            }
            return count;
        }

















        /**
         * 2020-06-11没搞定
         *
         * @param n
         * @return
         */
        public int countPrimes_1(int n) {
            boolean[] isPrim = new boolean[n];
            // 将数组都初始化为 true
            Arrays.fill(isPrim, true);

            for (int i = 2; i < n; i++)
                if (isPrim[i])
                    // i 的倍数不可能是素数了
                    for (int j = 2 * i; j < n; j += i)
                        isPrim[j] = false;

            int count = 0;
            for (int i = 2; i < n; i++)
                if (isPrim[i]) count++;

            return count;
        }

        /**
         * 解释题意
         * 1 质数：数字n，他可以整出1和他本身，其他数字不能整除
         * 2 质数个数
         * <p>
         * <p>
         * 设计算法
         * 1 得到数字n
         * 2 从2开始到n/2【7-2，3】【8-2，3，4】【15-2，3，4，6，7】，
         * 测试用例
         * 1 0
         * 2 1
         * 3 2
         * 4 3
         * 5 4
         * <p>
         * <p>
         * 时间复杂度：O(n/2) * O(n)
         *
         * @param n
         * @return
         */
        public int countPrimes_my(int n) {
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (isPrime(i)) {
                    count = count + 1;
                }
            }
            return count;
        }

        /**
         * 1 从2开始到n/2【7-2，3】【8-2，3，4】【15-2，3，4，6，7】
         * 2 使用n逐个除以这些数字
         * 3 如果除数是0，说明不是质数
         * 4 如果除数不是0，那就是质数
         *
         * @param n
         * @return
         */
        private boolean isPrime(int n) {
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}