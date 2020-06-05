//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 进阶： 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
// 
// Related Topics 链表


package leetcode.editor.cn;

import java.util.Stack;

//Java：两数相加 II
public class P445AddTwoNumbersIi {
    public static void main(String[] args) {
        Solution solution = new P445AddTwoNumbersIi().new Solution();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;

        n4.next = n5;
        n5.next = n6;

        ListNode listNode = solution.addTwoNumbers(n1, n4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
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
         * 解释题意
         * 1 链表从头到尾 代表 数字的高位到低位
         * 2 两个链表相加，需要从低位到高位累加
         * 3 需要想办法找到链表的尾部，从尾部到头部迭代
         * <p>
         * 设计算法
         * 1 两个链表分别入栈，入栈完毕
         * 2 取出栈顶元素，相加，获取相加之和【一位数字】以及进位
         * 3 循环：根据创建节点tmp，solder指向tmp，下一个节点要添加到solder之后
         * 4 考虑最高位有进位的情况。例如9，9
         *
         * <p>
         * 测试用例
         * 1 null，1-2-3
         * 2 null，null
         * 3 1-2，null
         * 3 1，1
         * 4 1-2-3，4-9-9
         * 5 7-8-9，4-5-6
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            ListNode solder = new ListNode(-1);
            ListNode cur = solder;
            ListNode next = null;
            int carry = 0;
            int sum = 0;
            // 两个链表创建出两个栈
            while (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            while (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
            while (stack1.size() > 0 || stack2.size() > 0) {
                // num1,num2每次相加前都要初始化为0。防1-2-3，1-2的情况
                Integer num1 = 0;
                Integer num2 = 0;
                if (stack1.size() > 0) {
                    num1 = stack1.pop();
                }
                if (stack2.size() > 0) {
                    num2 = stack2.pop();
                }
                // 如果一个节点有值就获取到这个值，另一个节点没有值则可以使用0代替
                sum = num1 + num2 + carry;
                carry = sum / 10;
                // 组装新的链表，这里可以不使用栈或者队列，只需要记录前一个节点即可
                ListNode tmp = new ListNode(sum % 10);
                tmp.next = next;
                cur.next = tmp;
                next = tmp;
            }
            if (carry == 1) {
                // 是否还有进位
                // 注意重复代码的提取
                ListNode tmp = new ListNode(carry);
                tmp.next = next;
                cur.next = tmp;
                next = tmp;
            }
            return solder.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}