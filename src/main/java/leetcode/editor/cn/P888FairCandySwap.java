//爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。 
//
// 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。） 
//
// 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。 
//
// 如果有多个答案，你可以返回其中任何一个。保证答案存在。 
//
// 
//
// 示例 1： 
//
// 输入：A = [1,1], B = [2,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 输入：A = [1,2], B = [2,3]
//输出：[1,2]
// 
//
// 示例 3： 
//
// 输入：A = [2], B = [1,3]
//输出：[2,3]
// 
//
// 示例 4： 
//
// 输入：A = [1,2,5], B = [2,4]
//输出：[5,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 1 <= B.length <= 10000 
// 1 <= A[i] <= 100000 
// 1 <= B[i] <= 100000 
// 保证爱丽丝与鲍勃的糖果总量不同。 
// 答案肯定存在。 
// 
// Related Topics 数组


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;

//Java：公平的糖果交换
public class P888FairCandySwap {
    public static void main(String[] args) {
        int[] A = new int[]{2, 2};
        int[] B = new int[]{1, 1};
        Solution solution = new P888FairCandySwap().new Solution();
        int[] ints = solution.fairCandySwap(A, B);
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] fairCandySwap(int[] A, int[] B) {
            int sa = 0;
            int sb = 0;
            HashSet<Integer> set = new HashSet<>();
            for (int a : A) {
                sa = sa + a;
            }
            for (int a : B) {
                sb = sb + a;
                set.add(a);
            }
            for (int a : A) {
                int s = a + (sb - sa) / 2;
                if (set.contains(s)) {
                    return new int[]{a, s};
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}