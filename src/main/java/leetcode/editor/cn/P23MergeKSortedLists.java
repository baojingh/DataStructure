//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法


package leetcode.editor.cn;

//Java：合并K个排序链表
public class P23MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new P23MergeKSortedLists().new Solution();
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
         * 1 多条链表，每条链表都是有序的
         * 2 创建新的链表节点，将按照顺序添加到新链表
         * <p>
         * 设计算法
         *
         *
         * <p>
         * 测试用例
         * 1 [],[],1-2-3
         * 2 1-2-3,2-3-4,3-4-5
         * 3 [],[],[]
         * 4 1-1-1,2-2-2,3-3-3
         *
         * 复杂度分析
         * 时间复杂度
         * 空间复杂度
         *
         * @param lists
         * @return
         */
        public ListNode mergeKLists(ListNode[] lists) {

        }

        /**
         * 解释题意
         * 1 多条链表，每条链表都是有序的
         * 2 创建新的链表节点，将按照顺序添加到新链表
         * <p>
         * 设计算法
         * 1 逐个链表，两两合并
         *
         * <p>
         * 测试用例
         * 1 [],[],1-2-3
         * 2 1-2-3,2-3-4,3-4-5
         * 3 [],[],[]
         * 4 1-1-1,2-2-2,3-3-3
         *
         * 复杂度分析
         * 时间复杂度
         * 空间复杂度
         *
         * @param lists
         * @return
         */
        public ListNode mergeKLists_mergeStepByStep(ListNode[] lists) {
            ListNode prev = null;
            for (ListNode node : lists) {
                prev = mergeTwoLinkedlist(prev, node);
            }
            return prev;
        }

        /**
         * 合并两条链表
         *
         * @param l1
         * @param l2
         * @return
         */
        private ListNode mergeTwoLinkedlist(ListNode l1, ListNode l2) {
            ListNode solder = new ListNode(-1);
            ListNode cur = solder;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            if (l1 != null) {
                cur.next = l1;
            }
            if (l2 != null) {
                cur.next = l2;
            }
            return solder.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}