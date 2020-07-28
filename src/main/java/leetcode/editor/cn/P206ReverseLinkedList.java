//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表


package leetcode.editor.cn;

//Java：反转链表
public class P206ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
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
         * <p>
         * <p>
         * 设计算法
         * 1 声明三个指针prev，cur以及next
         * 2 保存cur的下一个节点next，当前指针cur指向prev
         * 3 cur节点命名成prev
         * 4 next节点命名成cur
         * 5 3与4的顺序不能变
         *
         *
         * 测试用例
         * 1 null
         * 2 1
         * 3 1-2
         * 4 1-2-3
         * 5 1-2-3-4
         *
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;
            while (cur != null) {
                // 保存节点
                ListNode n = cur.next;
                cur.next = prev;
                // 以下顺序不能变
                prev = cur;
                cur = n;
            }
            return prev;
        }














        /**
         * 解释题意
         * 1 链表反转，
         * <p>
         * 设计算法
         * 1 三个指针，分别指向当前节点cur，前一个节点prev，下一个节点next
         * 2 当前节点不为空，就向下执行；为空，就结束循环，返回
         * 3 保存cur节点的下一个节点到next
         * 4 当前指针cur指向prev
         * 5 当前指针cur赋值给prev
         * 6 下一个节点next赋值给cur指针
         * 测试用例
         * 1 null
         * 2 1
         * 3 1-2
         * 4 1-2-3
         *
         * @param head
         * @return
         */
        public ListNode reverseList_1(ListNode head) {
            ListNode solder = new ListNode(-1);
            solder.next = head;

            ListNode p = null;
            // 第一次迭代，当作链表尾
            ListNode cur = solder.next;
            ListNode next = null;
            while (cur != null) {
                next = cur.next;
                cur.next = p;
                p = cur;
                cur = next;
            }
            solder.next = p;
            return solder.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}