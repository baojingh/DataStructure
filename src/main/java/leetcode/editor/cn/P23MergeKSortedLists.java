//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法


package leetcode.editor.cn;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

//Java：合并K个排序链表
public class P23MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new P23MergeKSortedLists().new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);

        ListNode l2 = new ListNode(11);
        l2.next = new ListNode(12);

        ListNode l3 = new ListNode(21);
        l3.next = new ListNode(22);

        ListNode l4 = new ListNode(3);

        ListNode[] list = new ListNode[4];
        list[0] = l1;
        list[1] = l2;
        list[2] = l3;
        list[3] = null;
//        solution.mergeKLists(list);


        Integer[] integers = new Integer[10];
        System.out.println(integers[0] = null);

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
         * 1 每个链表都是升序的
         * 2 多个链表合并成一个链表，合并后链表也是升序的
         * <p>
         * 设计算法【两两合并法】
         * 1 设计合并两个链表的算法
         * 2 循环整个链表，两两合并
         * 3 缺点是时间复杂度高，大部分链表的节点会被访问k-1次，时间复杂度O(l1+l2+...)
         * 4 时间复杂度分析：https://blog.csdn.net/weixin_40633275/article/details/106675636
         * 5 K条链表总的节点数是N，平均每个链表节点数是N/K，
         * 第1次合并两条链表,节点数： N/K + N/K
         * 第2次合并两条链表，节点数： 2*N/K + N/K
         * ...
         * 第K-1次合并两条链表，节点数： (k-1)*N/K + N/K
         * 总的访问节点数是累加，得到K*K * (N/K)
         * 时间复杂度是O(N*K)
         * <p>
         * 设计算法【堆】
         * 0 创建solder以及移动指针cur
         * 1 每个链表的首节点加入小顶堆，堆顶自动是最小元素
         * 2 cur指向最小元素；最小元素在所在链表向前移动；节点加入小顶堆；cur向前移动
         * 3 循环结束条件是小顶堆中的元素个数是0
         *
         * 测试用例
         * 1 null,null,null
         * 2 null,1
         * 3 1,2,3
         * 4 1
         * 5 1-3-4, 2-3-4-5, 2-3-7
         *
         *
         * @param lists
         * @return
         */
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            // 小顶堆
            PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });
            ListNode solder = new ListNode(-1);
            ListNode cur = solder;
            for (ListNode list : lists) {
                if (list != null) {
                    // 链表头加入小顶堆
                    // 防止数组出现null
                    queue.offer(list);
                }
            }
            while (queue.size() > 0) {
                // 取出最小值的元素
                ListNode node = queue.poll();
                // 添加到链表中
                cur.next = node;
                ListNode tmp = node.next;
                if (tmp != null) {
                    // 链表中节点不为空
                    // 此处是判断是否到达链表尾部
                    queue.offer(tmp);
                }
                cur = cur.next;
            }
            return solder.next;
        }































        /**
         * 解释题意
         * 1 多条链表，每条链表都是有序的
         * 2 创建新的链表节点，将按照顺序添加到新链表
         * <p>
         * 设计算法
         * 1 每个链表都是有序的，每次从链表第一个节点取元素比较即可
         * 2 构建元素个数是K的最小堆
         * 3 将各链表的头节点加入堆中
         * 4 取出堆顶元素，加入链表中
         * 5 被取出的节点的next节点加入堆
         * 6 堆为空，就退出循环
         *
         * <p>
         * 测试用例
         * 1 [],[],1-2-3
         * 2 1-2-3,2-3-4,3-4-5
         * 3 [],[],[]
         * 4 1-1-1,2-2-2,3-3-3
         * <p>
         * 复杂度分析
         * 时间复杂度
         * 空间复杂度
         *
         * @param lists
         * @return
         */
        public ListNode mergeKLists_1(ListNode[] lists) {
            ListNode solder = new ListNode(-1);
            ListNode cur = solder;
            PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    // 队列从小到大
                    return o1.val - o2.val;
                }
            });
            for (ListNode node : lists) {
                // 只把链表头放入最小堆
                // 如果某个链表的头节点是null，此处会空指针异常
                if (node != null) {
                    queue.offer(node);
                }
            }
            while (queue.size() > 0) {
                // 队头出队列，这也是一个最小堆，堆顶元素出队
                ListNode node = queue.poll();
                // 连接到新链表
                cur.next = node;
                cur = cur.next;
                if (node.next != null) {
                    // 这个链表的头节点后的节点不为空，才可以加入链表尾部
                    queue.offer(node.next);
                }
            }
            // cur.next当前已经是null
            return solder.next;
        }

        /**
         * 解释题意
         * 1 多条链表，每条链表都是有序的
         * 2 创建新的链表节点，将按照顺序添加到新链表
         * <p>
         * 设计算法
         * 1 逐个链表，两两合并
         *
         * <p>
         * 测试用例
         * 1 [],[],1-2-3
         * 2 1-2-3,2-3-4,3-4-5
         * 3 [],[],[]
         * 4 1-1-1,2-2-2,3-3-3
         * <p>
         * 复杂度分析
         * 时间复杂度 O(K*N),K是链表个数，N是所有链表的总节点数，可以优化成O(N*logk)
         * 参照：https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/
         * 4-chong-fang-fa-xiang-jie-bi-xu-miao-dong-by-sweet/
         * 空间复杂度
         *
         * @param lists
         * @return
         */
        public ListNode mergeKLists_mergeStepByStep(ListNode[] lists) {
            ListNode prev = null;
            for (ListNode node : lists) {
                prev = mergeTwoLinkedlist(prev, node);
            }
            return prev;
        }

        /**
         * 合并两条链表
         *
         * @param l1
         * @param l2
         * @return
         */
        private ListNode mergeTwoLinkedlist(ListNode l1, ListNode l2) {
            ListNode solder = new ListNode(-1);
            ListNode cur = solder;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            if (l1 != null) {
                cur.next = l1;
            }
            if (l2 != null) {
                cur.next = l2;
            }
            return solder.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}