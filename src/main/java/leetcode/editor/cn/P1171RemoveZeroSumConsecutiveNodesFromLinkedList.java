//给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。 
//
// 删除完毕后，请你返回最终结果链表的头节点。 
//
// 
//
// 你可以返回任何满足题目要求的答案。 
//
// （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。） 
//
// 示例 1： 
//
// 输入：head = [1,2,-3,3,1]
//输出：[3,1]
//提示：答案 [1,2,1] 也是正确的。
// 
//
// 示例 2： 
//
// 输入：head = [1,2,3,-3,4]
//输出：[1,2,4]
// 
//
// 示例 3： 
//
// 输入：head = [1,2,3,-3,-2]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 给你的链表中可能有 1 到 1000 个节点。 
// 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000. 
// 
// Related Topics 链表


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：从链表中删去总和值为零的连续节点
public class P1171RemoveZeroSumConsecutiveNodesFromLinkedList {
    public static void main(String[] args) {
        Solution solution = new P1171RemoveZeroSumConsecutiveNodesFromLinkedList().new Solution();
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
         * @param head
         * @return
         */
        public ListNode removeZeroSumSublists(ListNode head) {
            ListNode solder = new ListNode(0);
            solder.next = head;
            ListNode cur = solder;
            HashMap<Integer, ListNode> map = new HashMap<>();
            int sum = 0;
            while (cur != null) {
                sum = sum + cur.val;
                // 覆盖前面的，保留后面的
                map.put(sum, cur);
                cur = cur.next;
            }
            // 重新从头节点开始
            cur = solder;
            sum = 0;
            while (cur != null) {
                sum = sum + cur.val;
                ListNode node = map.get(sum);
                if (node != null) {
                    // 删除符合条件的节点
                    // 从外侧处理，不用处理嵌套情况，嵌套的都已经在外侧处理了
                    cur.next = node.next;
                }
                // 处理下一个，不处理器嵌套
                cur = cur.next;
            }
            return solder.next;
        }
















































        /**
         * 解释题意
         * <p>
         * 设计算法：
         * solder方便处理1-2--3
         * 1 使用map，key是当前节点以及之前节点的累加和，value是当前节点对象
         * 2 迭代节点，cur对应的节点和存在多次，说明这中间是有连续元素和为0的节点，即1-2-3-4,<0,0><1,1><3,2><6,3><3,-3><7,4>
         * 3 找到这个节点cur1，将cur.next=cur1.next
         * 4 如果没有连续节点和是0，在map中也能找到一次累加和，执行cur.next=cur1.next，也是一样的，因为cur=cur1
         *
         * <p>
         * 测试用例
         * 1 null
         * 2 1
         * 3 1-2
         * 4 1-2-3--6
         * 4 1-2--2-3
         * 5 1-2-3--3--2
         *
         * @param head
         * @return
         */
        public ListNode removeZeroSumSublists_1(ListNode head) {
            HashMap<Integer, ListNode> map = new HashMap<>();
            // 0不会对累加和造成影响
            ListNode solder = new ListNode(0);
            solder.next = head;
            ListNode cur = solder;
            int sum = 0;
            while (cur != null) {
                // 构建map
                sum = sum + cur.val;
                map.put(sum, cur);
                cur = cur.next;
            }
            sum = 0;
            // 从头迭代
            cur = solder;
            while (cur != null) {
                sum = sum + cur.val;
                // map中是否包含存在的值，如果包含且大于一个就是将这中间的元素全部删除
                if (map.containsKey(sum)) {
                    cur.next = map.get(sum).next;
                }
                cur = cur.next;
            }
            return solder.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}