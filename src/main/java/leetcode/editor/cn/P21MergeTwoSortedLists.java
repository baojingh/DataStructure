//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表


package leetcode.editor.cn;

//Java：合并两个有序链表
public class P21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
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
         * 1 链表1，链表2是单调递增的
         * 2 创建一个新的节点当作新链表的的头部
         * 3 新链表也是有序的
         * <p>
         * <p>
         * 设计算法
         * 0 创建新的头节点solder，以及cur，移动cur，
         * 0 给两个链表分配移动指针，分别是cur1,cur2
         * 1 迭代两个链表
         * 2 如果cur1链表节点值较小，加入新的链表尾部，迭代cur1，循环2
         * 3 如果cur1链表节点值较大，cur2加入新的链表尾部，迭代cur2，循环3
         * 4 返回solder.next
         *
         *
         * <p>
         * 测试用例
         * 0 两个均为空
         * 1 一个节点，空链表
         * 2 两个节点，空链表
         * 3 1-2-3，4-5-6
         * 4 1-3-5，2-4-6
         * 5 1-3-5，2-3-5
         * 5 1-3-5，2-3-5-6-7-8
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode solder = new ListNode(-1);
            ListNode cur = solder;
            ListNode cur1 = l1;
            ListNode cur2 = l2;
            while (cur1 != null && cur2 != null) {
                if (cur1.val <= cur2.val) {
                    cur.next = cur1;
                    cur1 = cur1.next;
                } else {
                    cur.next = cur2;
                    cur2 = cur2.next;

                }
                cur = cur.next;
            }
            if (cur1 != null) {
                cur.next = cur1;
            }
            if (cur2 != null) {
                cur.next = cur2;
            }
            return solder.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}