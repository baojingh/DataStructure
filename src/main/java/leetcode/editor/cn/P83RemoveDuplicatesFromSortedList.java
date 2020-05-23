//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表


package leetcode.editor.cn;

//Java：删除排序链表中的重复元素
public class P83RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new P83RemoveDuplicatesFromSortedList().new Solution();
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        /**
         * 解释题意
         * 1 链表已经排序，升序
         * 2 有重复元素
         * 3 删除重复元素，仅出现一次
         * 设计算法
         * 单指针
         * 1 从solder开始遍历其后面的两个节点
         *
         *
         *
         *
         * 快慢指针
         * 1 指针fast在前，slow在后，相差1
         * 2 如果slow与fast相等，slow暂停，fast继续前进，判断fast与slow是否相等
         * 3 如果相等，fast继续前进；如果不相等，将其赋值给slow，fast向前一步
         * 4 继续执行2
         * 5 如果fast到达链表尾部，就返回链表；未到达就继续执行1
         * 测试用例
         * 1 -1-null
         *
         * @param head
         * @return
         */
        public ListNode deleteDuplicates(ListNode head) {

            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}