//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表


package leetcode.editor.cn;

//Java：移除链表元素
public class P203RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new P203RemoveLinkedListElements().new Solution();
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
         * 1 删除指定元素
         * 2 元素有多个也要删除
         *
         * <p>
         * 设计算法
         * 单指针
         * 1 迭代链表，当前元素的next是否是null，为空就结束循环，不为空就向下执行
         * 2 当前指针cur的下一个元素值是否是目标值
         * 3 如果不是目标值，继续迭代
         * 4 如果是目标值，cur.next=cur.next.next
         * 5 继续1
         *
         *
         * <p>
         * 测试用例
         * 1 -1-null，1
         * 2 -1-1-1，1，2
         * 3 -1-1-1-2-3，1
         * 4 -1-1-2-2，2
         * 4 -1-1-2-2-3-2-2-4，2
         * 5 -1-1-2-3-4，2
         *
         * @param head
         * @param val
         * @return
         */
        public ListNode removeElements(ListNode head, int val) {
            ListNode solder = new ListNode(-1);
            solder.next = head;
            ListNode cur = solder;
            while (cur.next != null) {
                if (cur.next.val != val) {
                    // 不是目标值就继续迭代
                    cur = cur.next;
                } else {
                    // 是目标值，就将目标值的下一个元素加到当前元素后面。
                    // 即使-1-1-2-2-3-2-2-4，2这种情况也能处理。
                    // 迭代一次，就删除一个，下一次循环，可以继续删除
                    cur.next = cur.next.next;
                }
            }
            return solder.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}