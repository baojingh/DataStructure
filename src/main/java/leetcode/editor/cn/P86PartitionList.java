//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针


package leetcode.editor.cn;

//Java：分隔链表
public class P86PartitionList {
    public static void main(String[] args) {
        Solution solution = new P86PartitionList().new Solution();
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
         * <p>
         * <p>
         * 设计算法
         * <p>
         * 测试用例
         *
         * @param head
         * @param x
         * @return
         */
        public ListNode partition(ListNode head, int x) {

            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}