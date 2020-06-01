//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表


package leetcode.editor.cn;

//Java：反转链表 II
public class P92ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new P92ReverseLinkedListIi().new Solution();
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
         * 设计算法
         * 测试用例
         * m,n保证在链表长度范围内，且链表长度大于等于1
         * 1 1
         * 2 1-1
         * 3 1-2-3
         *
         * @param head
         * @param m
         * @param n
         * @return
         */
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (m < 1 || m > n) {
                return head;
            }
            ListNode solder = new ListNode(-1);
            solder.next = head;
            ListNode prev = solder;
            for (int i = 1; i < m; i++) {
                prev = prev.next;
            }
            ListNode cur = prev.next;
            ListNode p = null;
            ListNode next = null;
            for (int i = m; i < n + 1; i++) {
                next = cur.next;
                cur.next = p;
                p = cur;
                cur = next;
            }
            prev.next.next = cur;
            prev.next = p;
            return solder.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}