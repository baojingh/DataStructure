package linkedlist;

import lombok.*;

/**
 * @Author: hebj
 * @Date: 2020/3/20 09:04
 * @Description:
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SingleLinkedlist {

    private SingleNode head = null;

    /**
     * 链表尾部插入元素
     *
     * @param node
     * @return
     */
    public SingleNode insertToTail(@NonNull SingleNode node) {
        if (head == null) {
            head = node;
            return head;
        }
        SingleNode currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(node);
        return null;
    }

    /**
     * 链表头部插入元素
     *
     * @param newNode
     */
    private boolean insertToHead(@NonNull SingleNode newNode) {
        if (head == null) {
            head = newNode;
            return true;
        }
        newNode.setNext(head);
        head = newNode;
        return true;
    }


    /**
     * 对链表中奇偶位置的节点进行排列。即奇数位置的节点放在一起；偶数位置的节点放在一起。都要放在同一链表中。
     * 奇偶位置，链表分别排列https://leetcode-cn.com/problems/odd-even-linked-list/
     * 输入: 1->2->3->4->5->NULL
     * 输出: 1->3->5->2->4->NULL
     * <p>
     * 输入: 2->1->3->5->6->4->7->NULL
     * 输出: 2->3->6->7->1->5->4->NULL
     *
     * @return
     */
    public SingleNode oddEvenIndexListClassify() {
        if (head == null) {
            return null;
        }
        // 先排列奇数
        SingleNode oddTail = head;
        // 再排列偶数
        SingleNode evenTail = head.getNext();
        SingleNode evenHead = evenTail;
        while (evenTail != null && evenTail.getNext() != null) {
            SingleNode n = evenTail.getNext();
            oddTail.setNext(n);
            oddTail = oddTail.getNext();

            SingleNode n2 = oddTail.getNext();
            evenTail.setNext(n2);
            evenTail = evenTail.getNext();
        }
        oddTail.setNext(evenHead);
        return head;
    }


    /**
     * 奇偶值，排列
     * 输入: 1->2->3->4->5->NULL
     * 输出: 1->3->5->2->4->NULL
     * <p>
     * 输入: 2->1->3->5->6->4->7->NULL
     * 输出: 2->6->4->1->-3->5->NULL
     * <p>
     * 2020-03-21 此算法时间复杂度 O(N), 空间复杂度O(N)，空间复杂度高，这部分待优化
     *
     * @return
     */
    public SingleNode oddEvenValueListClassify() {
        if (head == null) {
            return null;
        }
        SingleNode solder = new SingleNode(null, 0);
        solder.setNext(head);
        // 链表首元素是偶数，就先排列偶数；反之亦然
        SingleNode oddHead = null;
        SingleNode oddTail = null;
        SingleNode evenHead = null;
        SingleNode evenTail = null;
        SingleNode p = solder.getNext();
        while (p != null) {
            int val = p.getData();
            SingleNode n = new SingleNode(null, val);
            if ((val & 1) == 0) {
                // 偶数
                if (evenHead == null) {
                    evenHead = n;
                    evenTail = evenHead;
                } else {
                    evenTail.setNext(n);
                    evenTail = evenTail.getNext();
                }
            } else {
                // 奇数
                if (oddHead == null) {
                    oddHead = n;
                    oddTail = oddHead;
                } else {
                    oddTail.setNext(n);
                    oddTail = oddTail.getNext();
                }
            }
            p = p.getNext();
        }
        if (oddHead != null) {
            oddTail.setNext(evenHead);
            head = oddHead;
        } else {
            evenTail.setNext(oddHead);
            head = evenHead;
        }
        return null;
    }

    /**
     * 是否是奇数
     *
     * @param val
     * @return
     */
    private boolean isOdd(int val) {
        return (val & 1) == 1;
    }

    public void printAll() {
        System.out.println("linked list data:");
        SingleNode currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }
    }

    /**
     * 输出所有元素, 若存在环，应该有检测机制，否则无限循环
     */
    public void printWithHead(SingleNode node) {

        SingleNode currentNode = node;
        System.out.println("linked list data:");
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }
    }

    /**
     * 删除倒数第N个节点,基于哨兵原理
     * <p>
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     * 给定的 n 保证是有效的。
     * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
     * <p>
     * 1 判断位置是非负整数
     * 2 设置前后指针，之间的差值是N，前指针start先移动N个位置，还需要保证start节点不为空
     * 3 然后end指针开始移动，当start指针为空时，end指针就是所要删除元素的前一个元素
     * 4 基于end指针删除目标元素
     *
     * @return
     */
    public SingleNode deleteNodeByLastKth(int N) {
        // 不能为非负数
        if (N < 0) {
            return this.head;
        }
        SingleNode solder = new SingleNode(null, 0);
        solder.setNext(this.head);
        SingleNode start = solder;
        SingleNode end = solder;
        while (N > 0) {
            if (start == null) {
                return this.head;
            }
            N = N - 1;
            start = start.getNext();
        }
        while (start.getNext() != null) {
            start = start.getNext();
            end = end.getNext();
        }
        end.setNext(end.getNext().getNext());
        return solder.getNext();
    }

    /**
     * 交换链表相邻节点
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 示例:
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
     * 自己画流程图:
     * 1 移动指针指向end节点
     * 2 start指向end后面的节点
     * 3 end指向start节点
     * 4 移动指针移动到start节点
     *
     * @return
     */
    public SingleNode swapNode() {
        SingleNode solder = new SingleNode(null, 0);
        solder.setNext(this.head);
        SingleNode tmp = solder;
        while (tmp.getNext() != null && tmp.getNext().getNext() != null) {
            SingleNode start = tmp.getNext();
            SingleNode end = tmp.getNext().getNext();
            tmp.setNext(end);
            start.setNext(end.getNext());
            end.setNext(start);
            tmp = start;
        }
        return solder.getNext();
    }

    /**
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     * <p>
     * 输入: 1->2->3->4->5->NULL, k = 2
     * 输出: 4->5->1->2->3->NULL
     * 向右旋转 1 步: 5->1->2->3->4->NULL
     * 向右旋转 2 步: 4->5->1->2->3->NULL
     * 链接：https://leetcode-cn.com/problems/rotate-list
     * <p>
     * solder原理更适用于链表插入，删除等场景，本次术语移动元素，可以不用solder
     *
     * @return
     */
    public SingleNode rotateNode(int k) {
        if (k < 0 || head == null || head.getNext() == null) {
            return this.head;
        }
        SingleNode fast = this.head;
        // 计算节点个数，将链表制作成环
        int count = 1;
        while (fast.getNext() != null) {
            count = count + 1;
            fast = fast.getNext();
        }
        fast.setNext(this.head);
        // 注意考虑k大于count的情况，k是count的倍数，则不做任何操作。当k不是0，则正常做旋转即可
        k = k % count;
        if (k == 0) {
            return this.head;
        }
        // 定位到倒数k个节点的前面节点，，因此count-k-1步
        SingleNode slow = this.head;
        for (int i = 0; i < count - k - 1; i++) {
            slow = slow.getNext();
        }
        SingleNode newNode = slow.getNext();
        slow.setNext(null);
        return newNode;
    }


    /**
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现的数字。
     * 示例 1:
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * 示例 2:
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
     * 1 基于哨兵原理，可能会删除头节点
     * 2 当前节点的下一个节点与下下一个节点是否为空
     * 3 如果两个节点值不相等，就继续下一个节点
     * 4 如果两个节点值相等，就将当前节点的下一个节点设置为临时节点，向后判断其后面的节点值是否与临时节点值相等，如果相等就向后遍历，
     * 如果不相等就退出。
     * 5 重复节点的最后一个值会被加入到链表中
     *
     * @return
     */
    public SingleNode deleteRepeatNodeWithSorted() {
        SingleNode solder = new SingleNode(null, 0);
        solder.setNext(this.head);
        SingleNode cur = solder;
        while (cur.getNext() != null && cur.getNext().getNext() != null) {
            // 当前节点的下一个节点与下下一个节点比较值
            if (cur.getNext().getData() == cur.getNext().getNext().getData()) {
                SingleNode tmp = cur.getNext();
                while (tmp != null && tmp.getNext() != null && tmp.getData() == tmp.getNext().getData()) {
                    // 下一个重复节点
                    tmp = tmp.getNext();
                }
                // 重复元素最后一个节点加入链表
                cur.setNext(tmp);
            }
            cur = cur.getNext();
        }
        return solder.getNext();
    }

    /**
     * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
     * 你应当保留两个分区中每个节点的初始相对位置。
     * 示例:
     * 输入: head = 1->4->3->2->5->2, x = 3
     * 输出: 1->2->2->4->3->5
     * 链接：https://leetcode-cn.com/problems/partition-list
     * <p>
     * 三个链表都添加哨兵节点
     * 空间复杂度O(1)
     * 时间复杂度O(n)
     * <p>
     * <p>
     * 解法2：基于两指针，不过缺点是交换的节点值，并未交换节点，⚠注意！
     * https://leetcode-cn.com/problems/partition-list-lcci/solution/ti-yi-de-mu-de-by-kkzz/
     * 题目要求：使得所有小于 x 的节点排在大于或等于 x 的 节点之前
     * 也就是只要比x小的在x之前就行了，不需要关心比x大的数的位置
     * 因此
     * 双指针
     * 一个用来从第一位开始存放比x小的数，另一个指针遍历，如果遇到就交换两个指针的值
     * 这样无论如何 只要比x小的数一定会在x之前
     * class Solution {
     * public ListNode partition(ListNode head, int x) {
     * ListNode a1=head; ListNode a2=head;
     * while(a1!=null){
     * if(a1.val<x){
     * swap(a1,a2);
     * a2=a2.next;
     * }
     * a1=a1.next;
     * }
     * return head;
     * <p>
     * }
     * public void swap(ListNode a1,ListNode a2){
     * int temp=a1.val;a1.val=a2.val;a2.val=temp;
     * }
     * }
     * <p>
     * 链接：https://leetcode-cn.com/problems/partition-list-lcci/solution/ti-yi-de-mu-de-by-kkzz/
     * <p>
     * 解法3：
     * 使用头插法即可，其中开始循环的节点为head.next，因为head不用判断
     * class Solution {
     * public ListNode partition(ListNode head, int x) {
     * if(head==null) return null;
     * ListNode dummy=new ListNode(-1);
     * dummy.next=head;
     * ListNode prev=head;
     * head=head.next;
     * while(head!=null){
     * if(head.val<x){
     * prev.next=head.next;
     * head.next=dummy.next;
     * dummy.next=head;
     * head=prev.next;
     * }else{
     * prev=prev.next;
     * head=head.next;
     * }
     * }
     * return dummy.next;
     * }
     * }
     * <p>
     * 链接：https://leetcode-cn.com/problems/partition-list-lcci/solution/tou-cha-fa-java-by-panc-2/
     *
     * @param x
     * @return
     */
    public SingleNode splitLinkedList(int x) {
        if (head == null || x < 0) {
            return head;
        }
        SingleNode solder = new SingleNode(null, 0);
        solder.setNext(head);
        SingleNode cur = solder;

        SingleNode small_solder = new SingleNode(null, 0);
        small_solder.setNext(this.head);
        SingleNode small_cur = small_solder;

        SingleNode big_solder = new SingleNode(null, 0);
        big_solder.setNext(this.head);
        SingleNode big_cur = big_solder;

        while (cur.getNext() != null) {
            // 取出主链表的下一个节点
            SingleNode next = cur.getNext();
            int val = next.getData();
            if (val < x) {
                // 小于给定的值，此节点加入小链表
                small_cur.setNext(next);
                small_cur = small_cur.getNext();
            } else {
                // 此节点加入大链表
                big_cur.setNext(next);
                big_cur = big_cur.getNext();
            }
            // 从主链表取出下一个节点
            cur = cur.getNext();
        }
        // 当主链表最后一个节点小于指定值，
        // 当主链表元素取完，但是大链表中的big_cur还在指向主链表的倒数第二个节点，倒数第一个节点术语小链表。
        // 将大链表的最后置成null，否则会出现环。
        // 如果主链表最后一个节点大于给定值，即使没有 big_cur.setNext(null)，也不会出现环
        big_cur.setNext(null);
        // 小链表尾部链接大链表头部
        small_cur.setNext(big_solder.getNext());
        return small_solder.getNext();
    }

    public SingleNode partition(int x) {
        if (head == null) return null;
        SingleNode dummy = new SingleNode(null, -1);
        dummy.setNext(head);
        SingleNode prev = head;
        head = head.getNext();
        while (head != null) {
            if (head.getData() < x) {
                prev.setNext(head.getNext());
                head.setNext(dummy.getNext());
                dummy.setNext(head);
                head = prev.getNext();
            } else {
                prev = prev.getNext();
                head = head.getNext();
            }
        }
        return dummy.getNext();
    }

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     * 示例:
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
     *
     * @return
     */
    public SingleNode reverseLinkedListWithIndex(int start, int end) {
        if (head == null || start <= 0 || end <= 0 || end <= start) {
            return head;
        }
        SingleNode solder = new SingleNode(null, 0);
        solder.setNext(head);
        SingleNode cur = solder;
        int index = 0;
        // 到达被翻转节点的前一个节点
        for (int i = 0; i < start - 1; i++) {
            cur = cur.getNext();
        }
        // 翻转节点
        SingleNode preserve_node = null;
        SingleNode start_node = cur.getNext();
        SingleNode next_node = null;
        // start_node != null表示即使end参数大于链表长度，确保循环结束
        for (int i = start; i <= end && start_node != null; i++) {
            next_node = start_node.getNext();
            start_node.setNext(preserve_node);
            preserve_node = start_node;
            start_node = next_node;
        }
        // 需要翻转的前一个节点,其下一个节点还是翻转链表的头节点，其下一个节点当前是null，需要将其下一个节点指向stat_node
        SingleNode first_node_reserve = cur.getNext();
        first_node_reserve.setNext(start_node);
        // 需要翻转的前一个节点指向翻转链表的最后一个节点
        cur.setNext(preserve_node);
        return solder.getNext();
    }

    /**
     * 检测是否含有环
     * 空间复杂度：保存了两个快慢指针，O(1)
     * 时间复杂度：
     * 1 链表没有环：快指针到达终点就会结束，时间复杂度O(N)
     * 2 链表有环：
     * 2.1 慢指针达到环之前，快指针迭代次数=非环部分长度=N
     * 2.2 慢指针进入环，快慢指针相遇需要迭代的次数 = 环中快慢指针的距离 / 快慢指针速度差值(是1)，
     * 即迭代次数最大是换部分长度M
     * 2.3 也就是时间复杂度最差是O(M+N)
     *
     * @return
     */
    public boolean hasCycle() {
        if (head == null) {
            return false;
        }
        SingleNode fast = head;
        SingleNode slow = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    /**
     * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
     * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 示例 1:
     * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
     * 示例 2:
     * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
     * 链接：https://leetcode-cn.com/problems/reorder-list
     * 1 将链表拆成两部分，基于快慢指针拆分
     * 2 前半部分做成一个链表，后半部分做成一个链表并将其倒置
     * 3 从前半部分链表开始，交替连接两个链表
     *
     * @return
     */
    public SingleNode reorderLinkedList() {
        if (head == null) {
            return head;
        }
        SingleNode main_cur = this.head;
        SingleNode fast_cur = this.head;
        SingleNode slow_cur = this.head;
        // 获取链表中间节点
        while (fast_cur.getNext() != null && fast_cur.getNext().getNext() != null) {
            slow_cur = slow_cur.getNext();
            fast_cur = fast_cur.getNext().getNext();
        }
        // 翻转链表的头节点
        SingleNode reverse_node = slow_cur.getNext();
        // 得到的slow_cur就是分割链表之前的节点
        slow_cur.setNext(null);
        // 翻转链表，得到新的链表
        SingleNode second_node = reverseLinkedList(reverse_node);
        // main_cur就是前半部分链表的头节点，second_node就是翻转链表后的头节点，接下来两个链表交替连接
        SingleNode cur = main_cur;
        while (cur != null && second_node != null) {
            SingleNode second_tmp = second_node.getNext();
            second_node.setNext(cur.getNext());
            cur.setNext(second_node);
            cur = second_node.getNext();
            second_node = second_tmp;
        }
        return main_cur;
    }

    /**
     * 翻转链表
     *
     * @return
     */
    private SingleNode reverseLinkedList(SingleNode currentNode) {
        SingleNode pre = null;
        SingleNode next = null;
        while (currentNode != null) {
            next = currentNode.getNext();
            currentNode.setNext(pre);
            pre = currentNode;
            currentNode = next;
        }
        return pre;
    }


    /**
     * 请判断一个链表是否为回文链表。
     * 示例 1:
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     * 输入: 1->2->2->1
     * 输出: true
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题
     * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
     *
     * @return
     */
    public boolean isPalindrome() {
        if (this.head == null) {
            return false;
        }
        // 链表前半部分
        SingleNode start_cur = this.head;
        // 获取链表后半部分的头节点
        SingleNode tmp = this.head;

        // 快慢指针以便获取链表中间位置
        SingleNode fast = this.head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            tmp = tmp.getNext();
        }
        // 翻转链表后半部分
        // cur会迭代指向下一个节点，但是end_cur_reverse会一直指向头节点
        SingleNode end_cur_reverse = reverseLinkedList(tmp);
        SingleNode cur = end_cur_reverse;
        while (start_cur != null && cur != null) {
            int start = start_cur.getData();
            int end = cur.getData();
            if (start != end) {
                return false;
            }
            start_cur = start_cur.getNext();
            cur = cur.getNext();
        }
        return true;
    }

    /**
     * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
     * 删除完毕后，请你返回最终结果链表的头节点。
     * 你可以返回任何满足题目要求的答案。
     * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
     * 示例 1：
     * 输入：head = [1,2,-3,3,1]
     * 输出：[3,1]
     * 提示：答案 [1,2,1] 也是正确的。
     * 示例 2：
     * 输入：head = [1,2,3,-3,4]
     * 输出：[1,2,4]
     * 示例 3：
     * 输入：head = [1,2,3,-3,-2]
     * 输出：[1]
     * 提示：
     * 给你的链表中可能有 1 到 1000 个节点。
     * 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
     * 链接：https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list
     *
     * @return
     */
    public SingleNode removeZeroSumSublists() {
        SingleNode solder = new SingleNode(null, 0);
        solder.setNext(this.head);
        SingleNode cur = solder;
        while (cur.getNext() != null) {
            SingleNode cur_next = cur.getNext();
            SingleNode cur_sum = cur_next;
            int sum = cur_next.getData();
            // sum == 0代表即使链表最后几位之和为0，仍然可以进入while，并且将cur的下一个节点设置为null
            // break跳出本循环，不会跳出最外层循环
            while (cur_sum.getNext() != null || sum == 0) {
                if (sum == 0) {
                    cur.setNext(cur_sum.getNext());
                    break;
                }
                cur_sum = cur_sum.getNext();
                sum = sum + cur_sum.getData();
            }
            // [1,2,3,-3,-2,-1] 内层循环第一次执行完，sum=0，cur_sum就在-1位置，，cur指向null，如果此处不判断sum情况，就会
            // 导致cur=null情况，进入外层循环后，null.getNext()就会NullException
            if (sum != 0) {
                cur = cur.getNext();
            }
        }
        return solder.getNext();
    }


    /**
     * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
     * 请你返回该链表所表示数字的 十进制值 。
     * 链接：https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer
     * <p>
     * 链表头到链表尾依次是二进制的低位到高位
     * 1->0->0->1->0 -----> 10010
     * <p>
     * 输入：head = [1,0,1]
     * 输出：5
     * 解释：二进制数 (101) 转化为十进制数 (5)
     * https://www.cnblogs.com/shindo/p/5140049.html
     *
     * @return
     */
    public int binary2DecimalValue() {
        if (this.head == null) {
            return 0;
        }
        SingleNode cur = this.head;
        int sum = 0;
        while (cur != null) {
            int val = cur.getData();
            /**
             * 10010
             * 第一次：
             *      0 * 2 + 1 = 1
             *      获取第一个元素的值，后面还会循环4次，此处的1，会被幂乘2 * 2 * 2 * 2
             * 第二次
             *      (0*2+1) * 2 + 0 = 1*2 + 0 =  0*2*2 + 1*2 + 0
             * 第三次
             *      ((0*2+1) * 2 + 0)*2 + 0 = 2*2 + 0 = 0*2*2*2 + 1*2*2 + 0*2 + 0
             *
             * 第四次
             *      (((0*2+1) * 2 + 0)*2 + 0))* 2 + 1 = 0*2*2*2*2 + 1*2*2*2 + 0*2*2 + 0*2 + 1
             * 第五次
             *      0*2*2*2*2*2 + 1*2*2*2*2 + 0*2*2*2 + 0*2*2 + 1*2 + 0
             *
             */
            sum = sum * 2 + val;
            cur = cur.getNext();
        }
        return sum;
    }

    /**
     * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
     * 示例1:
     * 输入：[1, 2, 3, 3, 2, 1]
     * 输出：[1, 2, 3]
     * 示例2:
     * 输入：[1, 1, 1, 1, 2]
     * 输出：[1, 2]
     * 提示：
     * 链表长度在[0, 20000]范围内。
     * 链表元素在[0, 20000]范围内。
     * 进阶：
     * 如果不得使用临时缓冲区，该怎么解决？
     * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
     * <p>
     * 时间复杂度O(n^2), 空间复杂度O(1)
     * 1 基于哨兵原理
     * 2 设置快慢指针，两层循环
     * 2.1 内层循环使用快指针，遍历后面的节点，判断与外层循环的慢指针的值是否相等，若相等就使用快指针移除此节点
     * 2.2 若不相等，快指针向后迭代
     * 2.3 快指针每次判断的是自己下一个节点的值是否与慢指针对应节点值是否相等
     *
     * @return
     */
    public SingleNode deleteRepeatNodeKeepFirst() {
        SingleNode solder = new SingleNode(null, 1);
        solder.setNext(this.head);
        // 基于哨兵原理
        SingleNode cur = solder;
        while (cur.getNext() != null) {
            // 第一次运行时，快慢指针同时指向哨兵节点的下一个节点，即原链表的头节点
            // 之后就操作的是当前节点的下一个节点
            SingleNode fast = cur.getNext();
            SingleNode slow = cur.getNext();
            while (fast.getNext() != null) {
                // 慢指针与快指针的下一个节点的值比较，不是快慢指针的值比较
                if (slow.getData() == fast.getNext().getData()) {
                    // 若相等，快指针就将次重复值删除，快指针总是在被删除节点之前
                    fast.setNext(fast.getNext().getNext());
                } else {
                    fast = fast.getNext();
                }
            }
            // 哨兵节点迭代
            cur = cur.getNext();
        }
        return solder.getNext();
    }

    /**
     * 给定一个有环链表，实现一个算法返回环路的开头节点。
     * 有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
     * 示例 1：
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：tail connects to node index 1
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * 示例 2：
     * 输入：head = [1,2], pos = 0
     * 输出：tail connects to node index 0
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     * 示例 3：
     * 输入：head = [1], pos = -1
     * 输出：no cycle
     * 解释：链表中没有环。
     * 进阶：
     * 你是否可以不用额外空间解决此题？
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle-lcci
     * <p>
     * 能够找到入口点：
     * 令： m 表示从head到入口的距离， d表示入口到相遇点的距离, r表示环的长度，ls表示slow走的长度，lf表示fast走的长度
     * 有： ls = m + d, lf = m + d + n * r (n为正整数)， lf = 2 * ls (此处为何快指针长度是慢指针长度两倍？？？)
     * 则： m + d + n * r = 2 * (m + d)
     * 则： m = n * r - d， n >= 1
     * <p>
     * 当n=1时，m = r - d, 即”head到入口的距离（m）“等于”相遇点到入口的距离(r - d)“， 使用第二步方法能找到入口点；
     * 当n=2时，m = 2 * r - d, 等价于： m = (r - d) + r, 即”head到入口的距离（m）“等于”相遇点到入口的距离（r - d）加环长度“， 使用第二步方法会让fast指针多走一个环的长度，然后slow和fast还会相遇在环入口
     * 当n>2时，同理。
     *
     * @return
     */
    public SingleNode detectCycle() {
        // 先验证是否有环，找到相交节点
        SingleNode slow = this.head;
        SingleNode fast = this.head;
        // fast != null表示：如果链表节点个数是偶数个，且没有环，此处就会NullPointerException
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                // 快慢指针相遇说明链表有环
                // 将慢指针重置到链表头，理论证明了慢指针从链表头开始，快指针从当前位置向前移动，均以步长为1的速度移动，
                // 两者相遇位置就是相交节点
                slow = this.head;
                while (fast.getNext() != null) {
                    // 相遇
                    if (slow == fast) {
                        return slow;
                    }
                    fast = fast.getNext();
                    slow = slow.getNext();
                }
            }
        }
        // 没有环
        return null;
    }


    public static void main(String[] args) {
        SingleLinkedlist linkedlist = new SingleLinkedlist();
        SingleNode node1 = new SingleNode(null, 1);
        SingleNode node2 = new SingleNode(null, 4);
        SingleNode node3 = new SingleNode(null, 3);
        SingleNode node4 = new SingleNode(null, 2);
        SingleNode node5 = new SingleNode(null, 5);
        SingleNode node6 = new SingleNode(null, 2);
        linkedlist.insertToTail(node1);
        linkedlist.insertToTail(node2);
//        linkedlist.insertToTail(node3);
//        linkedlist.insertToTail(node4);
//        linkedlist.insertToTail(node5);
//        linkedlist.insertToTail(node6);
//        linkedlist.insertToTail(node7);
//        linkedlist.insertToTail(node8);
//        linkedlist.insertToTail(node9);
//        linkedlist.insertToTail(node5);
//        linkedlist.printAll();
//        SingleNode node = linkedlist.oddEvenValueListClassify();
//        linkedlist.printAll();
//        SingleNode node = linkedlist.deleteNodeByLastKth(4);

//        SingleNode node = linkedlist.swapNode();
//        linkedlist.printWithHead(node);

//        SingleNode node = linkedlist.rotateNode(2);
//        linkedlist.printWithHead(node);
//        SingleNode node = linkedlist.deleteRepeatNode();
//        linkedlist.printWithHead(node);

//        SingleNode node = linkedlist.splitLinkedList(0);
//        linkedlist.printWithHead(node);

//        SingleNode node = linkedlist.reverseLinkedListWithIndex(1, 7);
//        linkedlist.printWithHead(node);

//        SingleNode node = linkedlist.reorderLinkedList();
//        linkedlist.printWithHead(node);
        boolean palindrome = linkedlist.isPalindrome();
        System.out.println(palindrome);
//        SingleNode node = linkedlist.removeZeroSumSublists();
//        linkedlist.printWithHead(node);
//        int i = linkedlist.binary2DecimalValue();
//        System.out.println(i);

//        SingleNode node = linkedlist.deleteRepeatNodeKeepFirst();
//        linkedlist.printWithHead(node);
//        SingleNode node = linkedlist.detectCycle();
//        if (node != null) {
//            System.out.println(node.getData() + "--" + node.getNext().getData());
//        } else {
//            System.out.println("no intersection node");
//        }
//        linkedlist.printWithHead(node);
//        SingleNode partition = linkedlist.partition(3);
//        linkedlist.printWithHead(partition);


    }

}
