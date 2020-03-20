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
        SingleNode node1 = new SingleNode(null, 1);
        SingleNode node2 = new SingleNode(null, 2);
        SingleNode node3 = new SingleNode(null, 3);
        SingleNode node4 = new SingleNode(null, 4);
        SingleNode node5 = new SingleNode(null, 5);
        SingleNode node6 = new SingleNode(null, 6);
        linkedlist.insertToTail(node1);
        linkedlist.insertToTail(node2);
        linkedlist.insertToTail(node3);
        linkedlist.insertToTail(node4);
        linkedlist.insertToTail(node5);
        linkedlist.printAll();
    }
}
