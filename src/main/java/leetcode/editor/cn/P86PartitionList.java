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

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode partition = solution.partition(n1, 3);
        System.out.println(partition.val);
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
         * 1 链表无序
         * 2 给定一个数字，将链表分区，前半部分分区小于给定值，后半部分大于等于给定值
         * 3 前后两部分中， 节点的相对位置保持不变。
         * 4 例如1-4-3-7-8-4-2，3。 排序完成的是：1-2-3-4-4-7-8
         * <p>
         * 设计算法
         * 1 需要创建两个链表，minSolder/minCur，maxSolder/maxCur
         * 2 迭代原链表，与给定值比较，插入到相关的链表
         * 3 迭代条件是原链表到达尾部
         * 4 min链表于max链表的尾部要指向null
         * 4 minCur指向maxSolder.next
         * 5 返回minSolder.next
         * <p>
         * 测试用例
         * 1 1-3-7-4-3-6-2，3
         * 2 null， 2
         * 3 3， 4
         * 4 3， 2
         * 5 2-2-2，1
         * 6 2-2-2，3
         * 7 2-2-2-5-5-5， 3
         * 8 5-5-5-3-3-3， 4
         * <p>
         * <p>
         * 时间复杂度
         * 空间复杂度
         *
         * @param head
         * @param x
         * @return
         */
        public ListNode partition(ListNode head, int x) {
            ListNode minSolder = new ListNode(-1);
            ListNode maxSolder = new ListNode(-1);
            ListNode minCur = minSolder;
            ListNode maxCur = maxSolder;
            while (head != null) {
                if (head.val < x) {
                    // 拼接小节点上的数值
                    minCur.next = head;
                    // 指针前进
                    minCur = minCur.next;
                } else {
                    maxCur.next = head;
                    maxCur = maxCur.next;
                }
                // 原链表指针向前移动
                head = head.next;
            }
            // 原链表的倒数第一个与倒数第二个，他们一个大于给定值一个小于给定值，就需要将min以及max链表的尾部指向null，否则出现环
            // 例如 1-4-7-2-3-6，4
            // 例如 1-4-7-2-8-5，4


            // 优化：min链表一定要拼接max链表，因此只需要考虑max链表尾部即可
            // 即这种情况：1-4-7-2-8-5，4
            maxCur.next = null;
            // 此时minCur/maxCur都在所在链表的最后一个节点上
            minCur.next = maxSolder.next;
            return minSolder.next;
        }



















        /**
         * 解释题意
         *
         *
         * <p>
         * 设计算法
         * 1 创建小指针min，大指针max
         * 2 小指针连接小于目标值的节点，大指针连接大于等于目标值的节点
         * 3 ⚠️大指针的next要赋值为null，例如1-4-3-2-5-2
         * 4 小指针的next指向大指针链表的头部
         * 5 返回小指针头部
         *
         *
         * 测试用例
         *
         * @param head
         * @param x
         * @return
         */
        public ListNode partition_1(ListNode head, int x) {
            ListNode minDummy = new ListNode(-1);
            ListNode minCur = minDummy;
            ListNode maxDummy = new ListNode(-1);
            ListNode maxCur = maxDummy;
            ListNode cur = head;
            while (cur != null) {
                if (cur.val >= x) {
                    maxCur.next = cur;
                    maxCur = maxCur.next;
                } else {
                    minCur.next = cur;
                    minCur = minCur.next;
                }
                cur = cur.next;
            }
            maxCur.next = null;
            minCur.next = maxDummy.next;
            return minDummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}