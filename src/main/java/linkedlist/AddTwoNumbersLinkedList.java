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


    /**
     * 解决办法：
     * 1 链表头节点到为节点分别代表一个数字的低位和高位，从链表头到链表尾依次相加注意进位即可，这个需求降低了问题难度。
     * 2 每次从两个链表各获取一个节点，值相加，保存进位
     * 3 如果两个链表长度不相等，将链表尾部补0后参与两个链表中的元素相加运算，即数据高位补0
     * 4 数据相加之和保存入第三个链表。如果和sum大于9，将保存进位即sum/10，并将sum % 10 存入链表
     *
     * @param list1
     * @param list2
     * @return
     */
    public SingleNode addTwoNumber(SingleNode list1, SingleNode list2) {
        // 创建哨兵，处理节点为空的情况；方便获取链表头节点
        SingleNode solder = new SingleNode(null, 0);
        SingleNode cur = solder;
        int carry = 0;
        // 当两个链表全部为null，表示数据相加完成
        while (list1 != null || list2 != null) {
            // 某个链表节点是null，以0代替
            int x = list1 == null ? 0 : list1.getData();
            int y = list2 == null ? 0 : list2.getData();
            // 两个数字相加，算入进位
            int sum = x + y + carry;
            // 获取进位
            carry = sum / 10;
            // 获取相加之和，存入链表。例如如果sun是9，可以直接存入链表；
            // 如果sum是12，就需要将进位存入carry，sum转换成sum%10=2，存入节点。
            sum = sum % 10;
            SingleNode node = new SingleNode(null, sum);
            cur.setNext(node);
            cur = cur.getNext();
            // 判断到底是哪一个链表不为空，如果不是空，就取这个链表的下一个元素。
            if (list1 != null) {
                list1 = list1.getNext();
            }
            if (list2 != null) {
                list2 = list2.getNext();
            }
        }
        // 计算完成后，如果进位还是1，则将其放入和链表的尾部。
        if (carry == 1) {
            cur.setNext(new SingleNode(null, carry));
        }
        // 取哨兵节点之后的节点，这是一个链表。
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
