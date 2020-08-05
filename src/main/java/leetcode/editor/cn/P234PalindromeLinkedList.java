//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针


package leetcode.editor.cn;

import java.util.LinkedList;

//Java：回文链表
public class P234PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new P234PalindromeLinkedList().new Solution();
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
         * 设计算法
         * 1 快慢指针法，到达链表中间节点slow
         * 2 反转以slow未链表头的链表，得到新链表newLinkedlist
         * 3 对比新旧链表
         *
         * 测试用例
         * 1 1-2-3-4-4-3-2-1
         * 2 1-2-3-4-3-2-1
         * 3 1-1-1
         * 3 1-1 理论：true
         * 5 1 理论：true
         * 4 1-2-3，
         * 6 null，理论：true
         *
         *
         * @param head
         * @return
         */
        public boolean isPalindrome1(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                // 1-2-3, 如果fast指针到达2，再继续迭代就会空指针异常，因此加上fast!=null
                fast = fast.next.next;
                slow = slow.next;
            }
            // slow就是中间节点,slow的前一个节点prev，也会指向反转链表后的最后一个节点，但是不用考虑这个问题，下看
            // 1-2-3-4-4-3-2-1，slow在第二个4
            // 1-2-3-4-3-2-1，slow在4
            ListNode reverseCur = reverseLinkedlist(slow);
            slow = head;
            while (slow != null && reverseCur != null) {
                if (slow.val != reverseCur.val) {
                    return false;
                }
                slow = slow.next;
                reverseCur = reverseCur.next;
            }
            return true;
        }

        /**
         * 链表反转
         * @param head
         * @return
         */
        private ListNode reverseLinkedlist(ListNode head) {
            ListNode prev = null;
            ListNode next = null;
            ListNode cur = head;
            while (cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }





















        /**
         * 解释题意
         * 1 回文指的是两边的数据是对称的
         * <p>
         * 设计算法
         * 1 找到链表的中间节点
         * 链表长度是奇数，slow是链表中间节点，1-2-2-1
         * 链表长度是偶数，slow是链表中间位置偏右侧的节点，1-2-3-2-1
         * 2 反转链表的后半部分
         * 1-2 2-1
         * 1-2 ，1-2-3，最后一个元素是中间节点，不用比较
         * 3 两个链表逐个比较节点是否有相等
         *
         * <p>
         * <p>
         * 测试用例
         * 0 null
         * 1 1
         * 2 1-2
         * 3 1-2-3
         * 4 1-2-3-4
         * 5 1-2-3-4-3-2-1
         *
         * @param head
         * @return
         */
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            ListNode fast = head;
            ListNode slow = head;
            // 获取链表中间节点
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            // slow 是待反转的链表头部
            ListNode cur = reverseList(slow);
            // fast重新回到链表头部
            fast = head;
            // 逐个迭代两个链表的的节点。迭代到目标节点就终止
            // 如果是1-2-3-2-1，反转后变成1-2，1-2-3，直接比较前两个，3就不用比较，因为3是中间节点
            // 注意：1-2-2-1，以及1-2-3-2-1，slow节点分别指向2，3。
            while (fast != null && cur != null) {
                if (fast.val != cur.val) {
                    return false;
                }
                fast = fast.next;
                cur = cur.next;
            }
            return true;
        }

        private ListNode reverseList(ListNode head) {
            ListNode solder = new ListNode(-1);
            solder.next = head;
            ListNode prev = solder;
            ListNode p = null;
            // 第一次迭代，当作链表尾
            ListNode cur = prev.next;
            ListNode next = null;
            while (cur != null) {
                next = cur.next;
                cur.next = p;
                p = cur;
                cur = next;
            }
            prev.next = p;
            return solder.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}