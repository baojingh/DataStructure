//编写一个程序，找到两个单链表相交的起始节点。 
//
// 如下面的两个链表： 
//
// 
//
// 在节点 c1 开始相交。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 
//
// 示例 2： 
//
// 
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 
//
// 示例 3： 
//
// 
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
// 
//
// 
//
// 注意： 
//
// 
// 如果两个链表没有交点，返回 null. 
// 在返回结果后，两个链表仍须保持原有的结构。 
// 可假定整个链表结构中没有循环。 
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 
// 
// Related Topics 链表


package leetcode.editor.cn;

//Java：相交链表
public class P160IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new P160IntersectionOfTwoLinkedLists().new Solution();
        if (null == null) {
            System.out.println("******");
        }

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
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        /**
         * 设计算法
         * 1 两个指针A，B分别指向两个链表头部
         * 2 A走过自己的链表，长度是l1+l2
         * 3 B走过自己的链表，长度是l3+l2
         * 4 A走完自己的之后再走B（相交节点之前的部分）；B走完自己的再走A（相交节点之前的部分），即l1+l2+l3 = l3+l2+l1
         * 5 迭代结束条件是指针A与指针B相等
         *
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode curA = headA;
            ListNode curB = headB;

            // null!= null
            while (curA != curB ) {
                if (curA != null) {
                    curA = curA.next;
                } else {
                    curA = headB;
                }

                if (curB != null) {
                    curB = curB.next;
                } else {
                    curB = headA;
                }
            }
            return curA;
        }











        /**
         * 设计算法
         * 1 双指针分别指向两个链表的头节点
         * 2 判断两个节点是否相等，若不相等则两个指针向后迭代；
         * 如果两个链表长度相等，且没有交点，两指针同时到达null，此时null==null为true
         * 如果交点前的链表长度相等，且有交点，则一次遍历即可找到
         * 如果交点前的链表长度不相等，且有交点，则指针curA到达链表A的尾部，就指向链表B的头部，同理对指针curB适用，直到找到交点
         * 3 若相等就返回
         *
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
            ListNode curA = headA;
            ListNode curB = headB;
            /**
             *
             * null == null 是成立的，是true
             *
             */
            while (curA != curB) {
                // 如果curA与curB没有交点，迭代完A和B后，还是会同时到达null，
                // 满足while条件的null==null，退出while循环，返回的是null
                if (curA != null) {
                    curA = curA.next;
                } else {
                    curA = headB;
                }
                if (curB != null) {
                    curB = curB.next;
                } else {
                    curB = headA;
                }
            }
            return curA;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}