package queue;

/**
 * @Author: hebj
 * @Date: 2020/2/11 07:58
 */
public class QueueArrayDemo {

    private int[] items;
    private int capacity;
    private int head;
    private int tail;

    public QueueArrayDemo(int capacity) {
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
        items = new int[capacity];
    }

    public QueueArrayDemo() {
    }

    private int size() {
        return this.tail - this.head;
    }

    /**
     * 队列满的条件：
     * 1. 元素个数 == capacity
     *
     * @return
     */
    private boolean isFull() {
        if (this.capacity == size()) {
            return true;
        }
        return false;
    }

    /**
     * 队列空的条件：
     * 1.
     *
     * @return
     */
    private boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 入队列操作，判断队列前是否还有空余位置、插入
     * @param ele
     */
    public void enqueue(int ele) {
        if (isFull()) {
            return;
        }
        if (this.head != 0) {
            // 移动元素
            int len = size();
            for (int i = 0; i < len; i++) {
                items[i] = items[this.head];
                this.head = this.head + 1;
            }
            this.tail = len;
            this.head = 0;
        }
        this.items[tail] = ele;
        this.tail = this.tail + 1;
    }

    /**
     * 出队列
     * @return
     */
    public int dequeue() {
        if (isEmpty()) {
            return -1;
        }
        int val = items[this.head];
        this.head = this.head + 1;
        return val;
    }

    private void printAll() {
        System.out.println("data in queue:");
        for (int i = this.head; i < size(); i++) {
            System.out.println(items[i]);
        }
    }


    public static void main(String[] args) {
        QueueArrayDemo queueArrayDemo = new QueueArrayDemo(3);

        queueArrayDemo.enqueue(1);
        queueArrayDemo.enqueue(2);
        queueArrayDemo.enqueue(3);
        queueArrayDemo.printAll();
        int v1 = queueArrayDemo.dequeue();
        System.out.println("dequeue:" + v1);
        queueArrayDemo.enqueue(4);
        queueArrayDemo.printAll();

    }


}
