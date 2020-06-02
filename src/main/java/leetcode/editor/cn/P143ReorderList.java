//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表


package leetcode.editor.cn;

//Java：重排链表
public class P143ReorderList {
    public static void main(String[] args) {
        Solution solution = new P143ReorderList().new Solution();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        solution.reorderList(n1);


        System.out.println(n1.val);
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
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        /**
         * @param head
         */
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            ListNode cur = head;
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            // 链表长度是奇偶
            // 链表长度是奇数，slow是链表中间节点
            // 链表长度是偶数，slow是链表中间位置偏右侧的节点
            ListNode mid_next = slow.next;
            slow.next = null;
            mid_next = reverseLinkedlist(mid_next);
            merge(cur, mid_next);
        }

        /**
         * left是拼接后的链表头
         *
         * @param left
         * @param right
         */
        private void merge(ListNode left, ListNode right) {
            ListNode cur = left;
            while (right != null) {
                ListNode left_back = cur.next;
                ListNode right_back = right.next;
                right.next = left_back;
                cur.next = right;
                right = right_back;
                cur = left_back;
            }
        }

        /**
         * 链表反转
         *
         * @param head
         * @return
         */
        private ListNode reverseLinkedlist(ListNode head) {
            ListNode cur = head;
            ListNode prev = null;
            ListNode next = null;
            while (cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}