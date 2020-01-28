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
            return false;
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
     * 输出所有元素
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


    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
//        linkedList.insertToTailWithValue(1);
//        linkedList.insertToTailWithValue(2);
//        linkedList.insertToTailWithValue(3);
        linkedList.insertToTailWithValue(3);
        linkedList.insertToTailWithValue(3);
        linkedList.insertToTailWithValue(4);
        linkedList.printAll();

//        Node valueNode = linkedList.findByValue(3);
//        System.out.println("nodeValue:" + valueNode.data);

        boolean b = linkedList.deleteByValue(3);
        linkedList.printAll();

    }


    @Getter
    @Setter
    public static class Node {
        private Node next;
        private int data;

        public Node() {
        }

        public Node(Node next, int data) {
            this.next = next;
            this.data = data;
        }
    }
}


