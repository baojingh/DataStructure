//给定一个链表，判断链表中是否有环。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
// Related Topics 链表 双指针


package leetcode.editor.cn;

import entity.ListNode;

//Java：环形链表
public class P141LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new P141LinkedListCycle().new Solution();
        System.out.println();
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */

    public class Solution {


        /**
         * 解释题意
         * 1 链表有环，指的是一个节点肯定是两进一出
         * 2 一旦一个指针进入环内，他就会一直在环里
         * 3 本题中的环是指链表尾部的节点与链表中的某个节点连接，即环在链表尾部
         * <p>
         * 设计算法
         * 1 创建快慢指针，从同一起点开始前进
         * 2 慢指针每次前进一步，快指针前进两步
         * 3 循环结束条件是fast与slow相等
         * <p>
         * <p>
         * 测试用例
         * 1
         *       6
         *     /   \
         * 1-2-3-4-5
         *
         * 2
         *
         *    4
         *  /  \
         * 1-2-3
         *
         * 3
         * 1-2-3
         *
         * 4
         * 1-2
         *
         * 5
         * 1
         *
         * 6 null
         *
         *
         *
         * @param head
         * @return
         */
        public boolean hasCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (fast == slow) {
                    return true;
                }
            }
            return false;
        }








































        /**
         * 解释题意：
         * 1 链表
         * 2 有环：两个节点的next都会指向一个节点，环中至少有三个节点才能成为环，两个节点不能组成环。
         * 但是本题如果将环设想成只有两个节点，本题解仍然可以解决这个问题
         *
         * <p>
         * <p>
         * 算法：
         * 快慢指针法
         * 1 快慢指针初始指向头节点
         * 2 快指针&&快指针的next不为空
         * 2 快指针一次走两步，慢指针一次走一步
         * 3 判断是否相等，如果相等代表有环，快慢指针相遇，返回结果，退出程序；否则没有环
         * 4 循环结束，没有找到相等的节点，就代表没有相交点，返回false
         * <p>
         * 测试用例：
         * 1 链表为空
         * 2 一个节点：1
         * 3 两个节点：1->2
         * 4
         * 4
         * / \
         * 1-2-3
         * <p>
         * 5 这种情况是属于环
         * 4
         * /\
         * 2 -3
         * 6 链表只有两个节点，但是相互指向对方
         * 1=2
         * <p>
         * 复杂度分析：
         * 空间复杂度：只用了快慢指针两个变量，O(1)
         * 时间复杂度：
         * 1）没有环：快指针走到链表尾部，就退出循环，慢指针访问了链表一半的数据，快指针访问了所有的数据，
         * O(n/2) + O(n)，时间复杂度是O(n)
         * 2）有环：慢指针进入环之前，走过的长度是M，快指针在环中迭代的次数是M，即非环长度是M
         * 慢指针进入环之后，快慢指针经过多长时间会相遇（经过多少次迭代）：快慢指针的距离(最大是环的长度N)/快慢指针差即1
         * 遍历迭代次数O(M + N), 即最大是O(链表长度)
         *
         * @param head
         * @return
         */
        public boolean hasCycle_1(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                // 头节点为空，也可处理
                // 确保fast.next不为空，否则fast.next.next报错空指针异常
                fast = fast.next.next;
                slow = slow.next;
                // 此处的equal注意，如果链表只有两个节点：2，1，快指针可能已经是null，而slow一定不为null，。
                // fast.equals(slow)可能会空指针异常
                // 可以使用slow.equals(fast)
                // 或者==，都是同一个对象，可以使用==
                if (slow == fast) {
                    // 找到相交节点
                    return true;
                }
            }
            // 链表没环，且快指针已经到达链表尾部
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}