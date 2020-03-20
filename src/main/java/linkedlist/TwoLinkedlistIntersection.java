package linkedlist;

import lombok.NonNull;

/**
 * @Author: hebj
 * @Date: 2020/3/19 20:38
 * @Description: 计算两个链表相交节点：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class TwoLinkedlistIntersection {

    public SingleNode intersection(SingleNode head1, SingleNode head2) {
        SingleNode list1 = head1;
        SingleNode list2 = head2;

        if (list1 == null || list2 == null) {
            return null;
        }
        while (list1 != list2) {
            if (list1 == null) {
                list1 = head2;
            } else {
                list1 = list1.getNext();
            }

            if (list2 == null) {
                list2 = head1;
            } else {
                list2 = list2.getNext();
            }
        }
        return list1;
    }

    public void printAll(SingleNode head) {
        SingleNode currentNode = head;
        System.out.println("linked list data:");
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }
    }


    public static void main(String[] args) {
        TwoLinkedlistIntersection main = new TwoLinkedlistIntersection();
        SingleLinkedlist linkedlist1 = new SingleLinkedlist();
        SingleLinkedlist linkedlist2 = new SingleLinkedlist();


        SingleNode node1 = new SingleNode(null, 1);
        SingleNode node2 = new SingleNode(null, 2);
        SingleNode node3 = new SingleNode(null, 3);
        SingleNode node4 = new SingleNode(null, 4);
        SingleNode node5 = new SingleNode(null, 5);
        SingleNode node6 = new SingleNode(null, 6);
        SingleNode node7 = new SingleNode(null, 7);
        linkedlist1.insertToTail(node1);
        linkedlist1.insertToTail(node2);
        linkedlist1.insertToTail(node3);
        linkedlist1.insertToTail(node4);
        linkedlist1.insertToTail(node5);
        linkedlist1.printAll();

        linkedlist2.insertToTail(node6);
        // node3的next是node4，其后还有node5
        linkedlist2.insertToTail(node3);
        linkedlist2.printAll();

//        SingleNode inter = main.intersection(null, null);
        SingleNode inter = main.intersection(linkedlist1.getHead(), linkedlist2.getHead());
        main.printAll(inter);
    }
}
