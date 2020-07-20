//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针


package leetcode.editor.cn;

//Java：删除链表的倒数第N个节点
public class P19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode listNode = solution.removeNthFromEnd(n1, 4);
        System.out.println(listNode.val);
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
         * 1 创建solder节点，连接原节点
         * 1 设置同侧快慢指针，fast，slow
         * 2 从solder节点开始，fast走n步后，slow开始走
         * 3 循环终止条件是fast指针到达链表尾部
         * 3 slow是目标节点的前一个节点
         * 4 执行删除操作
         * <p>
         * 测试用例
         * 1 null, 1
         * 2 1, 0,1,2
         * 3 1-2 1,2
         * 4 1-2-3 1,2,3
         * 5 1-2-3-4 1,2,3,4
         *
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 方便删除头节点
            ListNode solder = new ListNode(-1);
            solder.next = head;
            if (n < 1) {
                // 倒数的数字不可是0
                return solder.next;
            }
            ListNode fast = solder;
            ListNode slow = solder;
            // 快指针从solder开始走过的步数
            int fastCount = 0;
            while (fast != null) {
                // 先判断fast是否到达尾部
                // 防止出现n大于链表长度的情况
                fast = fast.next;
                fastCount = fastCount + 1;
                if (fastCount == n) {
                    // fast到达指定的节点
                    break;
                }
            }
            // while结束，分成两种情况：
            // 1 fast为空，这个是异常情况
            // 2 到达真实的节点，fast不为空
            if (fast == null) {
                return solder.next;
            }
            while (fast.next != null) {
                // 快慢指针同时向前走
                slow = slow.next;
                fast = fast.next;
            }
            // 删除操作
            slow.next = slow.next.next;
            return solder.next;
        }


        /**
         * 解释题意
         * 1 删除倒数的第K个节点，返回链表头部
         * 2 判断K是否存在
         * 3
         * <p>
         * 设计算法
         * <p>
         * 1. 快慢指针 + 滑动窗口长度是K + solder
         * 2. 快指针先从solder向前走K步(注意每走一步，判断是否为空，还没到K就遇到null，说明长度不够)
         * 3. 快慢指针同时向前走一步，判断fast是否到达尾部，
         * 5. fast不为空，fast与slow同时前进一步
         * 4. fast==null，此时slow就指向倒数K个节点的前一个节点
         * 6. 执行删除操作
         * 7. 链表头节点是solder.next
         * <p>
         * 测试用例
         * 1 空链表，n=0，n=1
         * 2 一个节点，n=1,n=2
         * 3. 两个节点，n=1,n=2,n=3
         * 4. 三个节点，n=1,n=2，n=3,n=4
         * <p>
         * <p>
         * <p>
         * 复杂度分析
         * 时间复杂度O(L),L是n大的长度
         *
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd_1(ListNode head, int n) {
            // 空链表以及无效索引
            if (head == null || n < 1) {
                return null;
            }
            ListNode solder = new ListNode(-1);
            solder.next = head;
            ListNode fast = solder;
            ListNode slow = solder;
            int count = 0;
            // fast移动n 步骤
            while (count != n) {
                fast = fast.next;
                count = count + 1;
            }
            // 如果n超出了链表范围，fast就会为空
            if (fast == null) {
                return null;
            }
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            // fast到达链表最后一个非空节点
            // slow就是目标节点的前一个节点
            slow.next = slow.next.next;
            return solder.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}