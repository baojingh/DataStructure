//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 说明：不允许修改给定的链表。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：tail connects to node index 1
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：tail connects to node index 0
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：no cycle
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//你是否可以不用额外空间解决此题？ 
// Related Topics 链表 双指针


package leetcode.editor.cn;

//Java：环形链表 II
public class P142LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new P142LinkedListCycleIi().new Solution();
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
         * 1 链表如果没有环，就返回null
         * 2 如果链表有环，肯定有一个环的入口点，即交点
         * <p>
         * 设计算法
         * 1 快慢指针fast，slow从链表头部开始
         * 2 fast每次走两步；slow每次走一步
         * 3 如果fast==slow说明有环
         * 4 循环结束条件fast或者fast.next为空
         * 5 循环结束，需要判断一下是否有环
         *      如果没有环(条件是fast或者fast.next是null)就返回null
         *      如果有环，就将fast指针指向链表头节点，slow与fast迭代向前走一步
         *      循环结束条件是fast==slow
         * 6. 两个指针相遇处，就是链表的入口
         * <p>
         * 测试用例
         *
         * @param head
         * @return
         */
        public ListNode detectCycle_1(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    // 链表有环，fast不是null，fast.next也不是null
                    break;
                }
            }
            if (fast == null || fast.next == null) {
                // 没有环
                return null;
            }
            // 链表有环
            fast = head;
            while (fast != slow) {
                // fast与slow一定不是null
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }








        /**
         * https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
         * <p>
         * 快慢指针法
         * <p>
         * 解释题意
         * 1 链表有环，返回快慢指针的相交节点
         * 2 没有环就返回null
         * 3 链表的节点全部在环中
         * <p>
         * 数学分析
         * 为什么会相遇？前面已经分析过了。
         * 假设：链表的非环部分长度a，环的长度是b
         * 节点相遇时：
         * <p>
         * slow指针走过的长度是s
         * fast指针走过的长度是f
         * fast指针走过的长度是slow的两倍（这个容易推算）
         * f = 2s
         * fast比slow多走了n的环
         * f = nb + s
         * 得出：s = nb, f = 2nb
         * slow走了n个环，fast走了2n个环
         * <p>
         * 如何计算入口节点？
         * 1 fast从链表头部走，slow从第一次相遇位置向前走
         * 2 如果在入口相遇，fast走到入口走过的距离是a+nb, slow走过的距离是nb(快节点比慢节点多走nb)
         * 3 slow只要再走a步就可以和fast相遇，到达入口，如何让slow走a步，
         * 从链表头部即可！！
         * <p>
         * 2020-05-19 为什么多走a，就可以相遇到入口节点，再想想～
         * <p>
         * 设计算法
         * 1 快慢指针同时指向链表头节点
         * 2 快指针以及后续指针不为空
         * 3 快指针走两步，慢指针走一步
         * 3 快慢指针对应的节点是否相等，如果相等就说明有环，进一步验证环的入口（有环就一定有入口）
         * 快节点从头开始走，慢节点继续前进，步长均为1，当slow==fast，说明入口到了
         * 4 如果没有找到或者快节点为空，就说明没有环，返回null
         * 5 回到2
         * <p>
         * 测试用例
         * 1 空链表
         * 1 单节点
         * 2 2-3
         * 3
         * 2=2
         * <p>
         * 4
         * 1
         * / \
         * 2 - 3
         * <p>
         * 5
         * 1
         * / \
         * 5- 2 - 3
         * <p>
         * <p>
         * 6
         * 1
         * / \
         * 2 - 3
         * <p>
         * <p>
         * <p>
         * 复杂度分析
         * 时间复杂度:
         * 空间复杂度O(1)
         *
         * @param head
         * @return
         */
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast) {
                    // 有环，退出循环
                    // fast从链表节点开始，单步走；slow按照原有的规则继续前进
                    fast = head;
                    while (fast != null) {
                        // 先判断是否相等
                        if (slow == fast) {
                            return slow;
                        }
                        //快慢指针值向前走一步
                        slow = slow.next;
                        fast = fast.next;
                    }
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}