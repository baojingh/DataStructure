//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表


package leetcode.editor.cn;

//Java：合并两个有序链表
public class P21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
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
         * 1 两个原链表是升序的，合并后也要升序
         * 2 合并后的链表是新的链表
         * 3 节点值相同就按照正常程序拼接
         * <p>
         * 设计算法
         * 1 创建新节点solder作为新链表的头节点，cur作为新链表的移动指针
         * 2 迭代链表l1，l2，比较两个节点的值大小，cur连接指向较小的节点，小节点的指针向前移动，cur向前移动
         * 3 继续比较节点值，循环退出条件是到达其中一个链表的尾部
         * 4 循环结束，说明两个链表全部到达尾部，或者是其中一条链表已经到达尾部另一链表还未到说明剩余节点比另一条链表数值大，
         * 继续将cur连接到这个链表剩余的节点
         * 5 返回solder.next
         * <p>
         * 测试用例
         * 1 1-4-9, 2-3-7
         * 2 1-2-4，3-7-8-9
         * 3 null,null
         * 4 null, 1
         * 5 1，2
         * 时间复杂度
         * 空间复杂度
         * @param l1
         * @param l2
         * @return
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode solder = new ListNode(-1);
            ListNode cur = solder;
            int val = 0;
            while (l1 != null && l2 != null) {
                int v1 = l1.val;
                int v2 = l2.val;
                if (v1 > v2) {
                    val = v2;
                    l2 = l2.next;
                } else {
                    val = v1;
                    l1 = l1.next;
                }
                ListNode tmp = new ListNode(val);
                cur.next = tmp;
                cur = cur.next;
            }
            // 程序执行到这里，肯定是：
            // 两个链表全部到尾部；一个链表到尾部以及一个链表未到尾部
            if (l1 != null) {
                cur.next = l1;
            }

            if (l2 != null) {
                cur.next = l2;
            }
            return solder.next;
        }















        /**
         * 解释题意
         * 1 链表1，链表2是单调递增的
         * 2 创建一个新的节点当作新链表的的头部
         * 3 新链表也是有序的
         * <p>
         * <p>
         * 设计算法
         * 0 创建新的头节点solder，以及cur，移动cur，
         * 0 给两个链表分配移动指针，分别是cur1,cur2
         * 1 迭代两个链表
         * 2 如果cur1链表节点值较小，加入新的链表尾部，迭代cur1，循环2
         * 3 如果cur1链表节点值较大，cur2加入新的链表尾部，迭代cur2，循环3
         * 4 返回solder.next
         *
         *
         * <p>
         * 测试用例
         * 0 两个均为空
         * 1 一个节点，空链表
         * 2 两个节点，空链表
         * 3 1-2-3，4-5-6
         * 4 1-3-5，2-4-6
         * 5 1-3-5，2-3-5
         * 5 1-3-5，2-3-5-6-7-8
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
            ListNode solder = new ListNode(-1);
            ListNode cur = solder;
            ListNode cur1 = l1;
            ListNode cur2 = l2;
            // 两个链表的头节点对齐
            while (cur1 != null && cur2 != null) {
                // 链表1的这个节点对比链表2的这个节点，添加到新的链表，并且更新相应链表的指针
                if (cur1.val <= cur2.val) {
                    cur.next = cur1;
                    cur1 = cur1.next;
                } else {
                    cur.next = cur2;
                    cur2 = cur2.next;

                }
                // 更新新链表的指针
                cur = cur.next;
            }
            // 如果一个链表很长，一个链表很短，那就需要将长链表剩余的部分再添加到新链表
            if (cur1 != null) {
                cur.next = cur1;
            }
            if (cur2 != null) {
                cur.next = cur2;
            }
            // 新链表的头节点是solder的下一个节点
            return solder.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}