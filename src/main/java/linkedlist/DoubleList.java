package linkedlist;

import lombok.*;

public class DoubleList {
    private Node head;
    private Node tail;
    private int size;
    private int capacity;

    public DoubleList(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.capacity = 5;
    }

    public DoubleList() {
    }

    private boolean isFull() {
        if (this.size >= this.capacity) {
            return true;
        }
        return false;
    }

    private boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    private int getSize() {
        return size;
    }

    public void insertToHeadWithValue(int k, int v) {
        Node node = new Node(k, v);
        insertToHead(node);
    }

    public void insertToHead(Node node) {
        if (isEmpty()) {
            this.tail = node;
        } else {
            // 1. 插入节点的前驱 后继节点
            // 2. 后节点的前驱
            // 3. 前节点的后继
            node.prev = null;
            node.next = head;
            head.prev = node;
        }
        this.head = node;
        this.size = this.size + 1;
    }


    public void insertToTailWithValue(int k, int v) {
        Node node = new Node(k, v);
        insertToTail(node);
    }

    /**
     * 链表尾部插入元素
     *
     * @param node
     * @return
     */
    private void insertToTail(@NonNull Node node) {
        if (head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.prev = this.tail;
            // this.tail.next 是 null
            node.next = this.tail.next;
            this.tail.next = node;
            this.tail = node;
        }
        this.size = this.size + 1;
    }

    /**
     * 删除双向链表最后一个节点
     *
     * @return
     */
    public Node deleteTail() {
        if (isEmpty()) {
            return null;
        }
        Node tmp = this.tail;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail.prev.next = this.tail.next;
            this.tail = this.tail.prev;
        }
        this.size = this.size - 1;
        return tmp;
    }


    /**
     * 输出所有元素, 若存在环，应该有检测机制，否则无限循环
     */
    public void printAll() {
        Node currentNode = head;
        System.out.println("double linked list data:");
        while (currentNode != null) {
            System.out.println(currentNode.key + " " + currentNode.val);
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        DoubleList dl = new DoubleList();
        dl.insertToTailWithValue(1, 1);
        dl.insertToTailWithValue(2, 2);
//        dl.insertToTailWithValue(3, 3);
//        dl.insertToTailWithValue(4, 4);
        dl.printAll();
        Node n1 = dl.deleteTail();
        System.out.println(n1.key + "-" + n1.val);
        dl.deleteTail();
        dl.printAll();


    }


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Node {
        private int key;
        private int val;
        private Node next;
        private Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
