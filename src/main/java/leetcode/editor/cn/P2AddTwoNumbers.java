//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学


package leetcode.editor.cn;

//Java：两数相加
public class P2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new P2AddTwoNumbers().new Solution();
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);

        ListNode d = new ListNode(5);
        ListNode e = new ListNode(6);
        ListNode f = new ListNode(9);

        a.next = b;
        b.next = c;

        d.next = e;
        e.next = f;

        ListNode node = solution.addTwoNumbers(a, d);
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }

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
         * 解题思路
         * 测试用例：
         * 1 1->2->3 + 3->4->5，直接相加，没有进位，没有空节点
         * 2 1->2->3 + 3->2，直接相加，没有进位
         * 3 1->2->3 + 9->2->1，直接相加，有进位
         * 3 1->2 + 9->9，直接相加，有进位，变成三位
         * 4 1->2 + ,一个空节点
         * 5  + ,两个空节点
         * 算法：
         * 1 链表首节点相加，保存进位，以及两数之和
         * 2 取出两个链表的下一位继续相加（注意加上之前的进位）
         * 3 如果节点为空，就跳过这个节点
         * 4 直到两个链表节点均为空
         * 5 跳出循环，判断进位是否是1，如果是1，还要继续添加到链表中
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            int sum = 0;
            ListNode solder = new ListNode(0);
            ListNode cur = solder;
            // 全为空的情况
            if (l1 == null && l2 == null) {
                return cur;
            }
            // 只要有一个链表不为空，就可以执行相加操作
            while (l1 != null || l2 != null) {
                int num1 = 0;
                int num2 = 0;
                if (l1 != null) {
                    // 获取当前节点值，指针指向下一个节点
                    num1 = l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    // 获取当前节点值，指针指向下一个节点
                    num2 = l2.val;
                    l2 = l2.next;
                }
                int s = num1 + num2 + carry;
                // 获取进位
                carry = s / 10;
                // 获取值
                sum = s % 10;
                cur.next = new ListNode(sum);
                cur = cur.next;
            }
            // 最后有进位，例如：
            // 3 1->2 + 9->9，直接相加，有进位，变成三位
            if (carry == 1) {
                cur.next = new ListNode(1);
            }
            return solder.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}