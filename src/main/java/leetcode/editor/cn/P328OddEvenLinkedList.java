//给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。 
//
// 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 1->3->5->2->4->NULL
// 
//
// 示例 2: 
//
// 输入: 2->1->3->5->6->4->7->NULL 
//输出: 2->3->6->7->1->5->4->NULL 
//
// 说明: 
//
// 
// 应当保持奇数节点和偶数节点的相对顺序。 
// 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。 
// 
// Related Topics 链表


package leetcode.editor.cn;

//Java：奇偶链表
public class P328OddEvenLinkedList {
    public static void main(String[] args) {
        Solution solution = new P328OddEvenLinkedList().new Solution();
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
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        /**
         *
         * 设计算法
         * 1 两个指针分别指向奇偶链表的首节点
         * 2 偶指针比奇指针向前走一步，一次循环结束条件是偶指针even以及even.next不为空。确保奇指针不为null，否则不能连接偶指针。偶指针可以指向链表
         * 3 奇指针指向当前偶指针的下一个节点，奇指针前进；偶指针指向当前奇指针的下一个节点，偶指针前进一步【此处可以看到偶指针排在前面】
         * 4 奇指针（不是null，）连接偶链表的头节点
         *
         *
         * 测试用例
         * 1 2-1-3-5-6-4-7
         * 2 2-1-3-5-6-4
         * 3 1-2-3
         * 4 1-2
         * 5 1
         * 6 null
         *
         * @param head
         * @return
         */
        public ListNode oddEvenList1(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode odd = head;
            ListNode even = head.next;
            ListNode even_head = even;
            while (even != null && even.next != null) {
                // 连接奇数链表
                odd.next = even.next;
                odd = odd.next;
                // 连接偶数链表
                even.next = odd.next;
                even = even.next;
            }
            // 奇偶链表拼接
            odd.next = even_head;
            return head;
        }
























        /**
         * 解释题意
         * 1 按照奇偶位置对链表分割
         * 2 奇数位置在前，偶数位置在后
         * 3 保持奇偶位置相对顺序不变
         * <p>
         * 设计算法
         * 1 初始化奇偶位置头指针【迭代期间不动】以及奇偶位置移动指针【负责迭代】
         * 2 奇指针指向偶指针的next节点
         * 3 奇指针向后迭代【偶指针之后的节点】
         * 4 偶指针指向奇指针之后的节点
         * 5 偶指针向后迭代【奇指针之后的节点】
         * 6 判断偶指针以及偶指针的next是否是null【注意】
         * 7 奇数个节点的链表，最后的状态是even_cur链表尾部的null；odd_cur指向最后一个节点
         * 7 偶数个节点的链表，最后的状态是even_cur链表最后一个节点；odd_cur指向链表倒数第二个节点
         * 8 奇链表尾部的next【odd_cur】指向偶链表的头部
         * 9 返回奇链表的头部
         * <p>
         * 测试用例
         * 1 null
         * 2 1
         * 3 1-2
         * 4 1-2-3
         * 5 1-2-3-4
         * 6 1-2-3-4-5
         *
         * @param head
         * @return
         */
        public ListNode oddEvenList(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode odd_head = head;
            ListNode odd_cur = head;
            ListNode even_head = head.next;
            ListNode even_cur = head.next;
            // 奇指针会首先拿到偶指针后面的节点，因此先判断偶指针是否为空【偶数个节点，需要使用even_cur.next != null；
            // 奇数个节点，需要使用even_cur != null】
            while (even_cur != null && even_cur.next != null) {
                // 奇数指针指向偶数指针之后的节点
                odd_cur.next = even_cur.next;
                // 奇数指针向后迭代
                odd_cur = odd_cur.next;
                // 偶数指针指向现在奇数指针之后的节点
                even_cur.next = odd_cur.next;
                // 偶数指针向后迭代
                even_cur = even_cur.next;
            }
            // 奇数指针拼接偶指针的头部
            odd_cur.next = even_head;
            return odd_head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}