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