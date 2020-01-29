package linkedlist;

import lombok.*;

public class SingleLinkedList {

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


    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
//        Node node1 = new Node(null, 1);
//        Node node2 = new Node(null, 2);
//        Node node3 = new Node(null, 3);
//        Node node4 = new Node(null, 4);
//        Node node5 = new Node(null, 5);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node2;
//        linkedList.insertToTail(node1);
//        linkedList.printAll();
        linkedList.insertToTailWithValue(1);
        linkedList.insertToTailWithValue(2);
        linkedList.insertToTailWithValue(3);
//        linkedList.insertToTailWithValue(4);
//        linkedList.insertToTailWithValue(5);
//        linkedList.insertToTailWithValue(6);
        linkedList.printAll();

//        boolean b = linkedList.hasCycle();
//        System.out.println(b);

//        Node valueNode = linkedList.findByValue(3);
//        System.out.println("nodeValue:" + valueNode.data);

//        boolean b = linkedList.deleteByValue(3);

//        Node h = linkedList.reverseLinkedList();
//        linkedList.printAll();
        Node middleNode = linkedList.middleNode();
        if (middleNode == null) {
            System.out.println("linked list is null");
        } else {
            System.out.println("middle node value is:" + middleNode.getData());
        }

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


