//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
// 例如，一个链表有6个节点，从头节点开始，
//它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。 
//
// 
//

// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 
// 👍 70 👎 0


package leetcode.editor.cn;

import entity.ListNode;

//Java：链表中倒数第k个节点
//public class P剑指 Offer 22LianBiaoZhongDaoShuDiKgeJieDianLcof{
public class JianZhiLianBiaoZhongDaoShuDiKgeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new JianZhiLianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
        System.out.println();
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
         * 1 题目没有说明k是否有效，要判断其有效性
         *
         *
         * 测试用例
         * 1 1-2-3-4-5，2
         * 2 null，1
         * 3 1， 1
         * 3 1， 2
         * 4 1-2，1
         * 4 1-2，2
         * 4 1-2，3
         *
         * @param head
         * @param k
         * @return
         */
        public ListNode getKthFromEnd(ListNode head, int k) {
            if (k < 1) {
                return head;
            }
            // 防止head为null的情况，不用额外判断
            ListNode solder = new ListNode(-1);
            solder.next = head;
            ListNode fast = solder;
            ListNode slow = solder;
            int i = 0;
            while (fast != null) {
                if (i == k) {
                    break;
                }
                // 如果fast不是null，就向前进
                // 两种可能性：
                // 1 fast指针前进k步，顺利达到k位置
                // 2 fast指针达到null
                fast = fast.next;
                i = i + 1;
            }
            if (fast == null) {
                // fast是null，说明k是无效的，立即退出
                return head;
            }
            // fast与slow指针同时前进
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            // 断开链表
            ListNode tmp = slow.next;
            slow.next = null;
            return tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}