//给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。 
//
// 你可以返回满足此条件的任何数组作为答案。 
// 示例：
//
// 输入：[3,1,2,4]
//输出：[2,4,3,1]
//输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
// 提示：
// 1 <= A.length <= 5000
// 0 <= A[i] <= 5000 
// 
// Related Topics 数组


package leetcode.editor.cn;

import java.util.Arrays;

//Java：按奇偶排序数组
public class P905SortArrayByParity {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 2, 4};
        Solution solution = new P905SortArrayByParity().new Solution();
        int[] array = solution.sortArrayByParity(nums);
        System.out.println(Arrays.toString(array));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArrayByParity(int[] A) {
            int len = A.length;
            int i = 0;
            int j = len - 1;
            while (i < j) {
                while ((A[j] & 1) == 1 && i < j) {
                    // 奇数
                    j = j - 1;
                }
                while ((A[i] & 1) == 0 && i < j) {
                    // 偶数
                    i = i + 1;
                }
                // 交换数组两个元素
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                // 交换元素后，i，j指针继续向前推进
                i = i + 1;
                j = j - 1;
            }
            return A;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}