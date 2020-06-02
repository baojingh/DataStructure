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
         * 解释题意
         * 1 回文指的是两边的数据是对称的
         * 2 奇数个数字肯定不是回文
         * <p>
         * 设计算法
         * 1 找到链表的中间节点
         * 2 从中间节点的下一个节点开始反转链表，得到新的链表
         * 3 从原链表头部重新迭代节点，和反转后的链表逐个对比，不相等就返回false；相等就返回true
         * <p>
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