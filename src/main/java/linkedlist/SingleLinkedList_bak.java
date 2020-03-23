package linkedlist;

import lombok.*;

public class SingleLinkedList_bak {

    private Node head = null;

    /**
     * @param ele
     * @return
     */
    public boolean insertToHeadWithValue(int ele) {
        Node node = new Node(null, ele);
        boolean b = insertToHead(node);
        if (!b) {
            return false;
        }
        return true;
    }

    /**
     * 链表头部插入元素
     *
     * @param newNode
     */
    private boolean insertToHead(@NonNull Node newNode) {
        if (head == null) {
            head = newNode;
            return true;
        }
        newNode.next = head;
        head = newNode;
        return true;
    }

    public boolean insertToTailWithValue(int ele) {
        Node node = new Node(null, ele);
        boolean b = insertToTail(node);
        if (!b) {
            return false;
        }
        return true;
    }

    /**
     * 链表尾部插入元素
     *
     * @param node
     * @return
     */
    private boolean insertToTail(@NonNull Node node) {
        if (head == null) {
            head = node;
            return true;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;
        return true;
    }

    public Node findByValue(int ele) {
        Node currentNode = head;
        while (currentNode != null && currentNode.data != ele) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    /**
     * 输出所有元素, 若存在环，应该有检测机制，否则无限循环
     */
    public void printAll() {
        boolean b = hasCycle();
        if (b) {
            System.out.println("linked list has cycle. quit~");
            return;
        }
        Node currentNode = head;
        System.out.println("linked list data:");
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    /**
     * 输出所有元素, 若存在环，应该有检测机制，否则无限循环
     */
    public void printAll(Node head) {

        Node currentNode = head;
        System.out.println("linked list data:");
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    /**
     * 根据值删除节点, 删除重复值
     *
     * @param ele
     * @return
     */
    public boolean deleteByValue(int ele) {
        if (head == null) {
            return false;
        }
        while (head != null && head.data == ele) {
            head = head.next;
        }
        Node currentNode = head;
        while (currentNode != null && currentNode.next != null) {
            if (currentNode.next.data == ele) {
                currentNode.next = currentNode.next.next;
                continue;
            }
            currentNode = currentNode.next;
        }
        return true;
    }

    /**
     * 链表反转
     *
     * @return
     */
    public Node reverseLinkedList() {
        Node currentNode = head;
        Node pre = null;
        Node next = null;
        while (currentNode != null) {
            next = currentNode.next;
            currentNode.next = pre;
            pre = currentNode;
            currentNode = next;
        }
        head = pre;
        return head;
    }

    /**
     * 检测是否含有环
     *
     * @return
     */
    public boolean hasCycle() {
        if (head == null) {
            return false;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取链表中间节点
     *
     * @return
     */
    public Node middleNode() {
        if (head == null) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 删除中间节点
     *
     * @return
     */
    public boolean deleteMiddleNode() {
        if (head == null) {
            return false;
        }
        Node fast = head;
        Node slow = head;
        Node pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            // 目标节点的前一个节点
            pre = slow;
            slow = slow.next;
        }
        // 真正的删除操作
        pre.next = slow.next;
        return true;
    }

    /**
     * 根据索引删除节点
     *
     * @param index 下标从0开始
     * @return
     */
    public boolean deleteByIndex(int index) {
        if (head == null) {
            return false;
        }
        // 单独处理删除头节点情况
        if (index == 0) {
            head = head.next;
            return true;
        }
        int i = 0;
        Node node = head;
        Node pre = head;
        while (node != null) {
            if (i == index) {
                pre.next = node.next;
                return true;
            }
            pre = node;
            node = node.next;
            i = i + 1;
        }
        return false;
    }

    /**
     * 有序合并链表
     *
     * @param head1
     * @param head2
     */
    public Node mergeLinkedlist(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        // 哨兵节点，此思想几乎可以应用于所有链表操作中，后续将基于此思想做调整
        Node solder = new Node(null, 0);
        Node p = solder;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        if (head1 != null) {
            p.next = head1;
        }

        if (head2 != null) {
            p.next = head2;
        }
        return solder.next;
    }

    /**
     * 删除倒数第K个节点,基于哨兵原理,此方案可以进行优化，参看另一个链表练习
     *
     * @param head
     * @return
     */
    public Node deleteNodeByLastKth(Node head, int k) {
        Node solder = new Node(head, 0);
        // 保存头节点
        solder.next = head;
        Node p = head;
        int length = 0;
        while (p != null) {
            p = p.next;
            length = length + 1;
        }
        if (k > length || k < 1) {
            return head;
        }
        length = length - k;
        p = solder;
        while (length > 0) {
            p = p.next;
            length = length - 1;
        }
        p.next = p.next.next;
        // 基于哨兵节点开始返回
        return solder.next;
    }

    public static void main(String[] args) {
        SingleLinkedList_bak linked1 = new SingleLinkedList_bak();
        SingleLinkedList_bak linked2 = new SingleLinkedList_bak();
//        Node node1 = new Node(null, 1);
        Node node2 = new Node(null, 2);
        Node node3 = new Node(null, 3);
        Node node4 = new Node(null, 4);
        Node node5 = new Node(null, 5);

//        linked1.insertToTail(node1);
//        linked1.insertToTail(node2);
//        linked1.insertToTail(node3);
//        linked1.insertToTail(node4);
//        linked1.insertToTail(node5);
        Node newHead = linked1.deleteNodeByLastKth(null, 2);
        linked1.printAll(newHead);

//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node2;
//        linkedList.insertToTail(node1);
//        linkedList.printAll();
//        linked1.insertToTailWithValue(1);
//        linked1.insertToTailWithValue(3);
//        linked1.insertToTailWithValue(5);
//        System.out.println("linked1");
//        linked1.printAll();
//
//        linked2.insertToTailWithValue(2);
//        linked2.insertToTailWithValue(4);
//        linked2.insertToTailWithValue(6);
//        System.out.println("linked2");
//        linked2.printAll();
//
//
//        Node newList = linked1.mergeLinkedlist(linked1.head, linked2.head);
//        linked1.printAll(newList);

//        boolean b = linkedList.hasCycle();
//        System.out.println(b);

//        Node valueNode = linkedList.findByValue(3);
//        System.out.println("nodeValue:" + valueNode.data);

//        boolean b = linkedList.deleteByValue(3);

//        Node h = linkedList.reverseLinkedList();
//        linkedList.printAll();
//        Node middleNode = linkedList.middleNode();
//        if (middleNode == null) {
//            System.out.println("linked list is null");
//        } else {
//            System.out.println("middle node value is:" + middleNode.getData());
//        }

    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Node {
        private Node next;
        private int data;
    }
}


