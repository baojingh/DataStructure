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
     * 奇偶链表分别排列https://leetcode-cn.com/problems/odd-even-linked-list/
     * 输入: 1->2->3->4->5->NULL
     * 输出: 1->3->5->2->4->NULL
     * <p>
     * 输入: 2->1->3->5->6->4->7->NULL
     * 输出: 2->3->6->7->1->5->4->NULL
     *
     * @return
     */
    public SingleNode oddEvenListClassify() {
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

    public void printAll() {
        System.out.println("linked list data:");
        SingleNode currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }
    }

    public static void main(String[] args) {
        SingleLinkedlist linkedlist = new SingleLinkedlist();
        SingleNode node1 = new SingleNode(null, 2);
//        SingleNode node2 = new SingleNode(null, 1);
//        SingleNode node3 = new SingleNode(null, 3);
//        SingleNode node4 = new SingleNode(null, 5);
//        SingleNode node5 = new SingleNode(null, 6);
//        SingleNode node6 = new SingleNode(null, 4);
//        SingleNode node7 = new SingleNode(null, 7);
        linkedlist.insertToTail(node1);
//        linkedlist.insertToTail(node2);
//        linkedlist.insertToTail(node3);
//        linkedlist.insertToTail(node4);
//        linkedlist.insertToTail(node5);
//        linkedlist.insertToTail(node6);
//        linkedlist.insertToTail(node7);
        linkedlist.printAll();

        linkedlist.oddEvenListClassify();
        linkedlist.printAll();

    }
}
