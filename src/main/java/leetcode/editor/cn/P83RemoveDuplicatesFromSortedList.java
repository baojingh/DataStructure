//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表


package leetcode.editor.cn;

//Java：删除排序链表中的重复元素
public class P83RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new P83RemoveDuplicatesFromSortedList().new Solution();
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
         * 2 如果包含重复元素，去掉重复元素，只保留一个。即1-2-2-3-4，变成1-2-3-4
         * <p>
         * 设计算法
         * 0 参考去除重复节点，不保留重复节点
         * 1 创建solder节点
         * 2 cur节点从solder节点开始，cur.next与cur.next.next节点是否相等
         * 3 如果不相等，cur指针继续前进
         * 4 如果相等，tmp指针指向重复节点第一个节点，向前移动。判断tmp节点是否与tmp.next
         * 如果相等，tmp指针向前移动
         * 如果不相等，cur指向tmp节点，cur指针也要前进。实际操作是保留的重复节点的最后一个节点
         * 循环结束条件是tmp.next不是null
         * 5 循环结束条件是cur.next以及cur.next.next不是null
         * <p>
         * <p>
         * 测试用例
         * 0 1-2-3-3-4-5-5-6
         * 1 null
         * 2 1
         * 3 1-1
         * 4 1-1-2
         * 5 1-2-3-3-3
         * 6 1-1-2-2-3-3
         * 7 1-1-1-2-3-4-4-4-5-5-6-7-8-8-8
         * <p>
         * 时间复杂度
         * 空间复杂度
         *
         * @param head
         * @return
         */
        public ListNode deleteDuplicates(ListNode head) {
            ListNode solder = new ListNode(-1);
            solder.next = head;
            ListNode cur = solder;
            while (cur.next != null && cur.next.next != null) {
                if (cur.next.val == cur.next.next.val) {
                    ListNode tmp = cur.next;
                    while (tmp.next != null && tmp.val == tmp.next.val) {
                        // tmp.next != null防止出现链表尾部元素重复情况，即1-2-2-2
                        tmp = tmp.next;
                    }
                    // cur指向重复元素最后一个节点
                    cur.next = tmp;
                }
                // 无论是否有重复元素，cur指针都会前进
                cur = cur.next;
            }
            return solder.next;
        }




























        /**
         * 解释题意
         * 1 链表已经排序，升序
         * 2 有重复元素
         * 3 删除重复元素，仅出现一次
         * 设计算法
         * 快慢指针
         * 1 从solder开始遍历其后面的两个节点
         * 2 fast不为空
         * 3 如果fast与slow相等，共同向前走一步
         * 4 如果不相等，fast向前走一步，slow指向fast
         * 5 fast为空，返回solder.next
         * 测试用例
         * 1 -1-null
         * 2 -1-1
         * 3 -1-1-1
         * 4 -1-1-2
         * 5 -1-1-1-1-2-2-3-4-4-5
         *
         * @param head
         * @return
         */
        public ListNode deleteDuplicates1(ListNode head) {
            // 链表为空或者只有一个节点，就返回，不需处理
            if (head == null || head.next == null) {
                return head;
            }

            ListNode sodler = new ListNode(-1);
            sodler.next = head;
            // 快慢指针，分别指向链表第一个/第二个节点
            ListNode fast = sodler.next.next;
            ListNode slow = sodler.next;
            while (fast != null) {
                // fast不为空就开始判断
                if (slow.val != fast.val) {
                    // 不相等就各自移动一步
                    fast = fast.next;
                    slow = slow.next;
                } else {
                    // 如果fast与slow相等，slow指向的是重复节点的第一个节点
                    // fast继续前进，每前进一次，slow就会指向这个fast
                    fast = fast.next;
                    slow.next = fast;
                }
            }
            return sodler.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}