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
     *
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     * 给定的 n 保证是有效的。
     * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
     *
     * 1 判断位置是非负整数
     * 2 设置前后指针，之间的差值是N，前指针start先移动N个位置，还需要保证start节点不为空
     * 3 然后end指针开始移动，当start指针为空时，end指针就是所要删除元素的前一个元素
     * 4 基于end指针删除目标元素
     *
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

    public static void main(String[] args) {
        SingleLinkedlist linkedlist = new SingleLinkedlist();
        SingleNode node1 = new SingleNode(null, 2);
        SingleNode node2 = new SingleNode(null, 4);
        SingleNode node3 = new SingleNode(null, 3);
        SingleNode node4 = new SingleNode(null, 5);
        SingleNode node5 = new SingleNode(null, 6);
        SingleNode node6 = new SingleNode(null, 9);
        SingleNode node7 = new SingleNode(null, 7);
        SingleNode node8 = new SingleNode(null, 8);
        linkedlist.insertToTail(node1);
        linkedlist.insertToTail(node2);
        linkedlist.insertToTail(node3);
        linkedlist.insertToTail(node4);
        linkedlist.insertToTail(node5);
        linkedlist.insertToTail(node6);
        linkedlist.insertToTail(node7);
        linkedlist.insertToTail(node8);
//        linkedlist.printAll();

//        SingleNode node = linkedlist.oddEvenValueListClassify();
//        linkedlist.printAll();
        SingleNode node = linkedlist.deleteNodeByLastKth(4);
        linkedlist.printWithHead(node);

    }
}
