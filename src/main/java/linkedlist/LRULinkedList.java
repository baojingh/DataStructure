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
            this.length = this.length - 1;
        }
        Node currentNode = head;
        while (currentNode != null && currentNode.next != null) {
            if (currentNode.next.data == ele) {
                currentNode.next = currentNode.next.next;
                this.length = this.length - 1;
                continue;
            }
            currentNode = currentNode.next;
        }
        return true;
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
            this.length = this.length + 1;
            return true;
        }
        newNode.next = head;
        head = newNode;
        this.length = this.length + 1;
        return true;
    }

    public boolean insertToTailWithValue(int ele) {
        Node node = new Node(ele, null);
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
            this.length = this.length + 1;
            return true;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;
        this.length = this.length + 1;
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
            this.length = this.length - 1;
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

    private boolean isFull() {
        if (this.length >= this.capacity) {
            return true;
        }
        return false;
    }

    private boolean isEmpty() {
        if (this.length == 0) {
            return true;
        }
        return false;
    }

    /**
     * 向链表中插入元素：
     * 1. 遍历链表，查看此元素是否存在。
     * 2. 如果存在就将此元素在原有位置删除，再将此元素插入表头。
     * 3. 如果链表不满，就直接插入表头；若链表已满，将链表尾部元素删除，继续将此元素插入表头
     *
     * @param ele
     * @return
     */
    public boolean insert2LinkedList(int ele) {
        Node byValue = findByValue(ele);
        // 存在此元素，就直接删除
        if (byValue != null) {
            boolean b = deleteByValue(ele);
            insertToHeadWithValue(ele);
            return true;
        }
        // 不存在此元素时
        // 链表满
        boolean full = isFull();
        if (full) {
            deleteTail();
        }
        // 链表未满
        insertToHeadWithValue(ele);
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
//        list.insertToHeadWithValue(1);
//        list.insertToHeadWithValue(2);
//        list.insertToHeadWithValue(3);
//        list.insertToHeadWithValue(4);
//        list.insertToHeadWithValue(5);
//        list.printAll();

//        list.deleteTail();
        list.insert2LinkedList(1);
        list.insert2LinkedList(2);
        list.insert2LinkedList(3);
        list.insert2LinkedList(4);
        list.insert2LinkedList(5);
        list.insert2LinkedList(6);
        list.insert2LinkedList(1);
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
