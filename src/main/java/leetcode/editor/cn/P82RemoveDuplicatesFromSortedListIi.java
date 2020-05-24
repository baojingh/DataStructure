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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode solder = new ListNode(-1);
            solder.next = head;
            ListNode fast = solder.next;
            ListNode slow = solder;
            while (fast != null) {
                if (fast.val != fast.next.val) {
                    slow = slow.next;
                    fast = fast.next;
                } else {
                    // 相邻元素相等
                    while (fast.val == fast.next.val) {
                        fast = fast.next;
                    }
                    slow.next = fast.next;
                    slow = slow.next;
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