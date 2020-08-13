//输入两个链表，找出它们的第一个公共节点。 
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
//输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
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
//输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
//
// 示例 3： 
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
//
// 注意： 
//
// 
// 如果两个链表没有交点，返回 null. 
// 在返回结果后，两个链表仍须保持原有的结构。 
// 可假定整个链表结构中没有循环。 
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 
// 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lis
//ts/ 
// 
// Related Topics 链表 
// 👍 83 👎 0


package leetcode.editor.cn;

import entity.ListNode;

//Java：两个链表的第一个公共节点
//public class P剑指 Offer 52LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof{
public class JianZhiLiangGeLianBiaoDeDiYiGeGongGongJieDianLcof{
    public static void main(String[] args) {
        Solution solution = new JianZhiLiangGeLianBiaoDeDiYiGeGongGongJieDianLcof().new Solution();
        System.out.println();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * 设计算法
     * 1 双指针分别指向两个链表的头节点
     * 2 判断两个节点是否相等，若不相等则两个指针向后迭代；
     *          如果两个链表长度相等，且没有交点，两指针同时到达null，此时null==null为true
     *          如果交点前的链表长度相等，且有交点，则一次遍历即可找到
     *          如果交点前的链表长度不相等，且有交点，则指针curA到达链表A的尾部，就指向链表B的头部，同理对指针curB适用，直到找到交点
     * 3 若相等就返回
     *
     *
     *
     * 测试用例
     * 1 1-2-3-4-8-9，6-5-4-8-9
     * 2 4-8-9
     * 3 1-2-3-4-5，6-7-3-4-5
     * 4 1-2-3，4-5-6
     * 5 null，null
     * 6 null, 1-2-3
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
        // null==null true
        while (curA != curB) {
            if (curA == null) {
                curA = headB;
            }
            if (curB == null) {
                curB = headA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        // 两个指针分别遍历了两个链表，没有交点
        return curA;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}