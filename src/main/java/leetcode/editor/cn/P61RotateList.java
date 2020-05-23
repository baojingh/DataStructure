//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针


package leetcode.editor.cn;

//Java：旋转链表
public class P61RotateList {
    public static void main(String[] args) {
        Solution solution = new P61RotateList().new Solution();
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
         * 1 循环右移尾节点，并且添加到头节点，移动次数是k
         * 2 如果移动次数是链表长度整数倍，那就不需要移动
         * <p>
         * 设计算法
         * solder+ 快慢指针 + 节点增加/删除
         * 1 先找出倒数第k个节点的前一个节点slow【快慢指针+sodler+滑动窗口】，将链表截断，再将两段按照题意合并
         * 【第一段的头节点是head，尾节点是slow；第二段的头节点是slow.next，尾节点是fast】
         * 2 保存slow.next节点
         * 3 slow当尾节点
         * 4 fast节点指向头节点
         * 5 slow.nexta当作头节点
         * 测试用例
         * 1 -1-null,k=0,k=1
         * 2 -1-1,k=0,k=1,k=2
         * 4 -1-1-2-3,k=0,k=1,k=2,k=3,k=6
         *
         * @param head
         * @param k
         * @return
         */
        public ListNode rotateRight(ListNode head, int k) {
            int len = 0;
            ListNode solder = new ListNode(-1);
            solder.next = head;
            ListNode cur = solder;
            while (cur.next != null) {
                // 计算链表长度
                len = len + 1;
                cur = cur.next;
            }
            ListNode fast = solder;
            ListNode slow = solder;
            // k的有效性检查: 负数；如果链表长度4，旋转3次与7次效果一样，可以使用取余，如果k大于链表长度可将旋转次数降低
            if (len == 0) {
                return solder.next;
            }
            k = k % len;
            if ((k <= 0) || (k == len)) {
                // k == 0，代表不旋转，也为后面fast向前走k步过滤异常情况
                return solder.next;
            }

            int count = 0;
            while (count != k) {
                // fast指针先走k步
                // 经过k%len的过滤，k一定在链表范围内
                fast = fast.next;
                count = count + 1;
            }
            while (fast.next != null) {
                // 同时前进一步，直到fast到达链表尾部
                fast = fast.next;
                slow = slow.next;
            }
            // 第二段链表的头节点
            ListNode tmp = slow.next;
            // 第一段链表尾部，收尾
            slow.next = null;
            // 第二段链表尾部连接第一段头部
            fast.next = head;
            // 第二段链表的头节点当作整个链表的头节点
            solder.next = tmp;
            return solder.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}