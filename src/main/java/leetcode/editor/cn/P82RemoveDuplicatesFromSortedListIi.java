//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表


package leetcode.editor.cn;

//Java：删除排序链表中的重复元素 II
public class P82RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new P82RemoveDuplicatesFromSortedListIi().new Solution();
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
         * 1 链表有序，升序
         * 2 链表中如果包含重复元素，就将重复元素全部删除，链表顺序不变。例如1-2-2-3，变成1-3
         *
         * 设计算法
         * 1 创建solder节点，便于处理头节点重复的情况
         * 2 cur指针从solder开始，
         * 3 cur的next节点与next.next节点的值对比
         *      如果不相等，就迭代cur=cur.next
         *      如果相等，此时cur在相等节点之前，tmp指针作为重复节点的第一个元素迭代
         *      tmp节点与tmp.next节点是否相等
         *             如果相等，就继续移动tmp
         *             如果不想等，cur指向tmp的下一个节点【这个节点就是重复节点链后的第一个节点】
         *      循环条件是tmp的值是否与tmp.next的值相等
         * 4 循环结束条件是cur的next节点与next.next节点不为空
         *
         * 测试用例
         * 1 null
         * 2 1
         * 2 1-1
         * 3 1-1-1-1
         * 4 1-1-2
         * 5 1-2-2
         * 6 1-2-3-4-5-6
         * 7 1-1-1-2-2-3-4-4-4-5-5-6-7-8-8
         *
         * 时间复杂度
         * 空间复杂度
         *
         * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/java-ya-jie-dian-fei-di-gui-rong-yi-li-jie-yong-sh/
         *
         * @param head
         * @return
         */
        public ListNode deleteDuplicates(ListNode head) {
            ListNode solder = new ListNode(-1);
            solder.next = head;
            ListNode cur = solder;
            // 比较cur后一个节点以及后后一个节点，确保他们不为null
            while (cur.next != null && cur.next.next != null) {
                if (cur.next.val == cur.next.next.val) {
                    // 处理相等情况
                    // 重复节点的第一个元素
                    ListNode tmp = cur.next;
                    // tmp.next != null处理链表尾部重复情况，例如1-2-2-2
                    while (tmp.next != null && tmp.val == tmp.next.val) {
                        tmp = tmp.next;
                    }
                    // cur指向重复元素后的第一个节点
                    // 但是cur指针没有前进，防止这个第一个节点也是重复的情况
                    // 继续比较cur的next与next.next
                    cur.next = tmp.next;
                } else {
                    // 不相等，就可以cur继续前进
                    cur = cur.next;
                }
            }
            return solder.next;
        }












































            /**
             * 解释题意
             * <p>
             * <p>
             * 设计算法
             * <p>
             * <p>
             * 测试用例
             * 0 -1-1-2-3-3-3-4-5
             * 1 -1-null
             * 2 -1-1
             * 3 -1-1-1
             * 4 -1-1-1-2
             * 5 -1-1-2-2-2-3-3-4-5
             *
             * @param head
             * @return
             */
        public ListNode deleteDuplicates_1(ListNode head) {
            ListNode solder = new ListNode(-1);
            solder.next = head;
            ListNode fast = solder.next;
            ListNode slow = solder;
            while (fast != null && fast.next != null) {
                if (slow.next.val != fast.next.val) {
                    fast = fast.next;
                    slow = slow.next;
                } else {
                    while (fast != null && fast.next != null && slow.next.val == fast.next.val) {
                        fast = fast.next;
                    }
                    slow.next = fast.next;
                    fast = fast.next;
                }
            }
            return solder.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    /**
     if head == None or head.next == None:
     return head
     dummy = ListNode(-1000)
     dummy.next = head
     slow = dummy
     fast = dummy.next
     while fast:
     if  fast.next and fast.next.val == fast.val:
     tmp = fast.val
     while fast and tmp == fast.val:
     fast = fast.next
     else:
     slow.next = fast
     slow = fast
     fast = fast.next
     slow.next = fast
     return dummy.next

     作者：powcai
     链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/kuai-man-zhi-zhen-by-powcai-2/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     */
}