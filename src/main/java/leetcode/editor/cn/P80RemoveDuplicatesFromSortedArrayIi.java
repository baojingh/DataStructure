//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。 
//
// 示例 1: 
//
// 给定 nums = [1,1,1,2,2,3],
//
//函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
//
//你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 2: 
//
// 给定 nums = [0,0,1,1,1,1,2,3,3],
//
//函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//} 
// Related Topics 数组 双指针


package leetcode.editor.cn;

//Java：删除排序数组中的重复项 II
public class P80RemoveDuplicatesFromSortedArrayIi {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        Solution solution = new P80RemoveDuplicatesFromSortedArrayIi().new Solution();
        int len = solution.removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
         * solution/zhi-jie-bian-li-yi-ci-ji-ke-by-luo-ben-zhu-xiao-ma/
         * 没看懂【原地删除肯定是双指针，一个指向遍历的元素，一个指向可以写入的位置，后者的大小是小于等于前者的，关键在于题目条件的转化，如何实现限制最多两次的重复出现。
         * 我们先不考虑边界情况，只考虑中间的情况，假设当前遍历位置为i，写指针的可写入位置为current+1，对于i处的值，其写入的条件是重复小于等于2次，我们考虑已经写入的最后两位current和current-1，这两个位置的情况有两个，相等和不相等，首先考虑相等的情况，此时若i处的值和current-1或者说current处的值相同，那么，i处的值肯定不能加入；然后考虑不相等的情况，即current-1和current处值不相等，那么i处的值无论为什么，都满足题意的，即可以加入，综上所述，当i处的值与current-1处的值不相等时，i处的值可以加入，其他情况均不能加入。
         * 接着考虑边界情况，我们只需要考虑开始即可，开始时，前两个值无论等还是不等，都要原封不动的挪到新数组里，由于新数组就是在原数组上进行修改的，因此前两位直接不动即可，只需要修改遍历指针和写入指针就行。
         * 以上算法只需要进行一次遍历即可，时间复杂度O(n)，空间复杂度O(1)。
         * <p>
         * 作者：luo-ben-zhu-xiao-man-tou
         * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/solution/zhi-jie-bian-li-yi-ci-ji-ke-by-luo-ben-zhu-xiao-ma/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。】
         * <p>
         * <p>
         * 用一个标识curPos记录当前结尾的位置。
         * 如果遍历到的数nums[i]和nums[curPos-1]相等。说明nums[i]==nums[curPos]==nums[curPos-1]。
         * 因此已经连续三个数相等了。nums[i]直接忽略即可。
         * 如果nums[i]和nums[curPos-1]不相等。则应将其赋值到curPos+1的位置。
         * 遍历结束以后。curPos+1就是需要求的新长度。
         * <p>
         * 作者：reedfan
         * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/solution/ji-bai-liao-98de-javayong-hu-by-reedfan-8/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param nums
         * @return
         */
        public int removeDuplicates(int[] nums) {
            if (nums.length < 3) {
                return nums.length;
            }
            //新数组中有效位置的最后一位，新加入的数据应当写到current+1
            int cur = 1;
            //从第三位开始循环，前两位无论如何都是要加入新数组的
            for (int i = 2; i < nums.length; i++) {
                if (nums[i] != nums[cur - 1]) {
                    //符合条件，加入新数组
                    cur = cur + 1;
                    nums[cur] = nums[i];
                }
            }
            int len = cur + 1;
            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}