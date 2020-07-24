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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode listNode = solution.rotateRight(head, 1);
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
         * 1 所谓的反转，其实就是逐个移动链表最后的节点到链表头
         * 2 移动的个数是整数或者是0
         * 3 如果移动的个数是0或者是链表长度的整数倍，则移动后与移动前一致，可以保持不变。
         * 4 移动的次数取余就可以得到实际移动的次数
         * 设计算法
         * 1 计算链表长度，移动位置取余获得实际移动的次数，如果余数是0。则不移动；不是0，就移动
         * 2 创建solder节点，以及快慢指针fast，slow，他们的初始位置是solder
         * 3 循环：fast先走k步，然后slow与fast再继续向前走
         * 4 循环结束条件是fast是null
         * 5 slow节点是需要移动的节点的前置节点，slow后面的一串节点直接与链表首节点拼接
         * 6 solder节点的next置成slow的next
         * <p>
         * 测试用例
         * 1 null
         * 2 1， 1 2
         * 3 1-2，0，1，2
         * 4 1-2-3，0，1，2，3，4
         * <p>
         * <p>
         * 时间复杂度
         * 空间复杂度
         *
         * @param head
         * @param k
         * @return
         */
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || k <= 0) {
                return head;
            }

            int len = 0;
            ListNode fast = head;
            while (fast != null) {
                // 计算链表长度
                len = len + 1;
                fast = fast.next;
            }

            // 实际需要移动的次数
            int realStep = k % len;
            if ( realStep == 0) {
                // 余数是0或者移动次数是0，不用移动链表
                return head;
            }

            ListNode solder = new ListNode(-1);
            solder.next = head;
            // 慢指针
            ListNode slow = solder;
            // 快指针
            fast = solder;
            // fast指针移动的次数
            int fastStep = 0;
            while (fast.next != null) {
                fast = fast.next;
                fastStep = fastStep + 1;
                if (fastStep == realStep) {
                    break;
                }
            }
            // fast指针已经走了realStep步，接下来slow与fast一起走
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            // fast到达链表尾部，slow就是要移动节点的前置节点
            fast.next = solder.next;
            solder.next = slow.next;
            // 否则出现环
            slow.next = null;
            return solder.next;
        }



















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
        public ListNode rotateRight_1(ListNode head, int k) {
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