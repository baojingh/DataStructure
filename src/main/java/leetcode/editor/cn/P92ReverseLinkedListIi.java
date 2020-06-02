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
         * 1 反转指定位置
         * 2 指定的位置是有效的，无需程序判断
         *
         *
         * 设计算法
         * 0 solder节点
         * 1 根据指定的位置，将指针prev移动到目标节点的前一个节点
         * 2 按照链表反转的流程进行反转，注意从第m个位置到第n个位置
         * 3 https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/ji-bai-liao-100de-javayong-hu-by-reedfan-6/
         * 4 目标链表反转完毕，开始做拼接：cur是目标链表之后的第一个节点，应将cur赋值给目标链表的第一个节点的next；
         * 5 prev的下一个节点是目标链表的最后一个节点
         *
         *
         *
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
            // 创建solder节点
            ListNode solder = new ListNode(-1);
            solder.next = head;
            ListNode prev = solder;
            for (int i = 1; i < m; i++) {
                prev = prev.next;
            }
            // prev是目标节点的前一个节点
            ListNode cur = prev.next;
            // 待反转的链表的前置节点
            ListNode p = null;
            // 待反转的链表的后续节点
            ListNode next = null;
            // 要反转的有几个节点就迭代多少次
            for (int i = m; i < n + 1; i++) {
                // 现获取当前节点的后续节点
                next = cur.next;
                // 当前节点的后续节点指向p
                cur.next = p;
                // 移动两个变量位置成为新的p，cur
                p = cur;
                cur = next;
            }
            // 待反转的链表头指向待反转链表的后面节点
            prev.next.next = cur;
            // 前置节点prev指向待反转链表最后一个节点
            prev.next = p;
            return solder.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}