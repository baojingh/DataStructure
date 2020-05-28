//请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。 
//
// 现有一个链表 -- head = [4,5,1,9]，它可以表示为: 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: head = [4,5,1,9], node = 5
//输出: [4,1,9]
//解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
// 
//
// 示例 2: 
//
// 输入: head = [4,5,1,9], node = 1
//输出: [4,5,9]
//解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
// 
//
// 
//
// 说明: 
//
// 
// 链表至少包含两个节点。 
// 链表中所有节点的值都是唯一的。 
// 给定的节点为非末尾节点并且一定是链表中的一个有效节点。 
// 不要从你的函数中返回任何结果。 
// 
// Related Topics 链表


package leetcode.editor.cn;

//Java：删除链表中的节点
public class P237DeleteNodeInALinkedList {
    public static void main(String[] args) {
        Solution solution = new P237DeleteNodeInALinkedList().new Solution();
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
         * 1 没有头节点，只给了链表中的某个节点，此节点需要被删除
         *
         * @param node
         */
        public void deleteNode(ListNode node) {
            if (node == null) {
                return;
            }
            if (node.next == null) {
                // 如果删除最后一个节点，即当前节点是最后一个节点，就null
                node = null;
                return;
            }
            // 0 1 2
            // 1-2-3,x=2
            // 索引2的位置被置为next节点的值
            // 这个节点的下下一个节点置为这个节点的下一个节点
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}