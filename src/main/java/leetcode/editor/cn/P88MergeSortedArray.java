//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
// 说明:
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 示例:
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针


package leetcode.editor.cn;

//Java：合并两个有序数组
public class P88MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0, 0, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3;
        int n = 3;
        Solution solution = new P88MergeSortedArray().new Solution();
        solution.merge(nums1, m, nums2, n);
        for (int i = 0; i < m + n; i++) {
            System.out.print(nums1[i] + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1 指针1指向num1的有效值最后len1，指针2指向num2的有效值最后len2，指针3指向num1的合并后长度最后一位len（len1+len2+1）
         * 2 从右向左比较两个数组，大的数字放在num1的最右侧即len位置，len左移，同时对应的那个数组的指针也要左移。
         * 3 当数组指针左移，小于0时，代表这个数组元素已经写入新的数组了
         * 4 如果num2还有元素，则将num2的剩余元素循环写入；如果num1还有元素，则保持不变，不要移动，因为数组有序
         *
         * 向左移动指针
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int len1 = m - 1;
            int len2 = n - 1;
            int len = len1 + len2 + 1;
            while (len1 >= 0 && len2 >= 0) {
                if (nums1[len1] > nums2[len2]) {
                    nums1[len] = nums1[len1];
                    len1 = len1 - 1;
                } else {
                    nums1[len] = nums2[len2];
                    len2 = len2 - 1;
                }
                len = len - 1;
            }
            while (len2 >= 0) {
                nums1[len] = nums2[len2];
                len2 = len2 - 1;
                len = len - 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}