//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表


package leetcode.editor.cn;

//Java：两两交换链表中的节点
public class P24SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new P24SwapNodesInPairs().new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode solder = new ListNode(-1);
        solder.next = head;
        ListNode listNode = solution.swapPairs(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

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
         * 1 链表的两个相邻节点，俩俩交换
         * 2 偶数节点俩俩交换；奇数个节点时最后一个节点不交换
         * <p>
         * 设计算法
         * 1 如果不使用solder，如何处理头节点与第二个节点？因此使用solder节点
         * 2 cur指针后面的两个节点交换，交换完毕，cur移动两步，继续交换其后面的两个
         * 3 循环结束条件是后面两个节点其中一个是null
         * 4 返回solder.next
         *
         * 测试用例
         * 1 null
         * 2 1
         * 3 1-2
         * 4 1-2-3
         *
         *
         * @param head
         * @return
         */
        public ListNode swapPairs(ListNode head) {
            ListNode solder = new ListNode(-1);
            solder.next = head;
            ListNode cur = solder;
            while (cur.next != null && cur.next.next != null) {
                ListNode tmp1 = cur.next;
                ListNode tmp2 = cur.next.next;
                ListNode n = tmp2.next;
                // 交换tmp1,tmp2
                tmp1.next = n;
                tmp2.next = tmp1;
                cur.next = tmp2;
                // 移动两步
                cur = cur.next.next;
            }
            return solder.next;
        }























        /**
         * 解释题意
         * 1 两两交换的意思是相邻两个元素交换，但是如果这个元素已经交换过，就不参与交换
         * 2
         * <p>
         * 设计算法
         * 测试用例
         * 1 空链表，-1-null
         * 2 -1-1-null
         * 3 -1-1-2-null
         * 4 -1-1-2-3-null
         * 5 -1-1-2-3-4-null
         *
         * @param head
         * @return
         */
        public ListNode swapPairs_1(ListNode head) {
            ListNode solder = new ListNode(-1);
            solder.next = head;
            ListNode cur = solder;
            while (cur.next != null && cur.next.next != null) {
                // 当前节点是cur，找到下一个节点以及下下一个节点
                ListNode tmp1 = cur.next;
                ListNode tmp2 = cur.next.next;
                // 最右边的节点设置next
                tmp1.next = tmp2.next;
                tmp2.next = tmp1;
                cur.next = tmp2;
                // 要交换的两个节点的前一个节点
                cur = cur.next.next;
            }
            return solder.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}