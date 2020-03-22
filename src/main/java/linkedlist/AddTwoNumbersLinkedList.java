package linkedlist;

/**
 * @Author: hebj
 * @Date: 2020/3/22 22:17
 * @Description:
 */

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */
public class AddTwoNumbersLinkedList {

    public SingleNode addTwoNumber(SingleNode list1, SingleNode list2) {
        SingleNode solder = new SingleNode(null, 0);
        SingleNode cur = solder;
        int carry = 0;
        while (list1 != null || list2 != null) {
            int x = list1 == null ? 0 : list1.getData();
            int y = list2 == null ? 0 : list2.getData();
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;
            SingleNode node = new SingleNode(null, sum);
            cur.setNext(node);
            cur = cur.getNext();

            if (list1 != null) {
                list1 = list1.getNext();
            }
            if (list2 != null) {
                list2 = list2.getNext();
            }
        }
        if (carry == 1) {
            cur.setNext(new SingleNode(null, carry));
        }

        return solder.getNext();
    }

    public static void main(String[] args) {

        SingleNode node1 = new SingleNode(null, 1);
        SingleNode node2 = new SingleNode(null, 2);
        SingleNode node3 = new SingleNode(null, 3);

        SingleNode node4 = new SingleNode(null, 9);
        SingleNode node5 = new SingleNode(null, 8);
        SingleNode node6 = new SingleNode(null, 6);

        SingleLinkedlist list1 = new SingleLinkedlist(node1);
        SingleLinkedlist list2 = new SingleLinkedlist(node4);
        AddTwoNumbersLinkedList addTwoNumbersLinkedList = new AddTwoNumbersLinkedList();

        list1.insertToTail(node2);
        list1.insertToTail(node3);
        list2.insertToTail(node5);
        list2.insertToTail(node6);

        SingleNode node = addTwoNumbersLinkedList.addTwoNumber(list1.getHead(), list2.getHead());
        while (node != null) {
            System.out.print(node.getData());
            node = node.getNext();
        }
    }

}
