package queue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: hebj
 * @Date: 2020/2/11 19:38
 */
public class QueueLInkedListDemo {

    private Node head;
    private Node tail;
    private int size;

    public QueueLInkedListDemo() {
    }

    public QueueLInkedListDemo(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public void enqueue(int ele) {
        Node n = new Node(ele);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            this.tail.next = n;
            this.tail = n;
        }
        size = size + 1;
    }

    public Node dequeue() {
        if (this.head == null) {
            return null;
        }
        Node p = this.head;
        this.head = this.head.next;
        size = size - 1;
        return p;
    }

    /**
     * 统计队列中元素个数，时间复杂度是O(n)
     *
     * @return
     */
    private int size() {
        int len = 1;
        Node p = this.head;
        while (p != this.tail) {
            p = p.next;
            len = len + 1;
        }
        return len;
    }

    private void printAll() {
        Node p = this.head;
        System.out.println("queue size:" + size);
        System.out.println("data in queue:");
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }

    }

    public static void main(String[] args) {
        QueueLInkedListDemo demo = new QueueLInkedListDemo(null, null);
        demo.enqueue(1);
        demo.enqueue(2);
        demo.enqueue(3);
        demo.printAll();
        Node n1 = demo.dequeue();
        demo.printAll();
        demo.enqueue(4);
        demo.enqueue(5);
        demo.printAll();
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
