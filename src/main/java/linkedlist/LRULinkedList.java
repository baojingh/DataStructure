package linkedlist;

import lombok.*;

@Setter
@Getter
public class LRULinkedList {
    private Node head;
    // 链表容量
    private int capacity;
    // 链表元素个数
    private int length;

    public LRULinkedList(int capacity) {
        this.head = null;
        this.capacity = capacity;
        this.length = 0;
    }

    public LRULinkedList(Node head) {
    }

    /**
     * @param ele
     * @return
     */
    public boolean insertToHeadWithValue(int ele) {
        Node node = new Node(ele, null);
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
        this.length = this.length + 1;
        return true;
    }

    /**
     * 删除尾部元素
     *
     * @return
     */
    public boolean deleteTail() {
        Node h = getHead();
        if (h == null) {
            return false;
        }
        // 链表只有一个节点
        if (h.next == null) {
            head = null;
            return true;
        }
        // 链表多余一个节点
        Node pre = h;
        while (h.next != null) {
            pre = h;
            h = h.next;
        }
        pre.next = null;
        length = length - 1;
        return true;
    }

    public void printAll(Node head) {
        Node currentNode = head;
        System.out.println("linked list data:");
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.next;
        }
    }

    public void printAll() {
        Node currentNode = this.head;
        System.out.println("linked list data:");
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.next;
        }
    }


    public static void main(String[] args) {
        LRULinkedList list = new LRULinkedList(5);
        list.insertToHeadWithValue(1);
        list.insertToHeadWithValue(2);
        list.insertToHeadWithValue(3);
//        list.insertToHeadWithValue(4);
//        list.insertToHeadWithValue(5);
        list.printAll();

        list.deleteTail();
        list.printAll();


    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Node {
        private int data;
        private Node next;
    }

}
