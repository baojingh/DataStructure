//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 45 👎 0


package leetcode.editor.cn;

import entity.ListNode;

//Java：从尾到头打印链表
//public class P剑指 Offer 06CongWeiDaoTouDaYinLianBiaoLcof{
public class JianZhiCongWeiDaoTouDaYinLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new JianZhiCongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        int[] arr = new int[0];

        System.out.println(arr.length);
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
         * 设计算法
         * 1 返还链表，并统计链表长度
         * 2 迭代链表，放入数组
         *
         * @param head
         * @return
         */
        public int[] reversePrint(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;
            int count = 0;
            while (cur != null) {
                ListNode n = cur.next;
                cur.next = prev;
                prev = cur;
                cur = n;
                count = count + 1;
            }
            int[] arr = new int[count];
            for (int i = 0; prev != null; i++) {
                arr[i] = prev.val;
                prev = prev.next;
            }
            return arr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}