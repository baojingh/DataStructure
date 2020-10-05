package array;

public class ArrayQueueDemo {
    
    
    private int capacity;
    private int count;
    private String[] data;
    private int head;
    private int tail;

    public ArrayQueueDemo(int capacity) {
        this.data = new String[capacity];
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public ArrayQueueDemo() {
    }

    private int getCapacity() {
        return this.capacity;
    }

    /**
     * 队列元素个数
     *
     * @return
     */
    private int getCount() {
        return this.tail - this.head;
    }


    /**
     * 队列是否为空
     *
     * @return
     */
    private boolean isEmpty() {
        if (head == tail) {
            return true;
        }
        return false;
    }

    /**
     * 队列会是否已满
     *
     * @return
     */
    private boolean isFull() {
        if (this.tail != this.capacity) {
            // tail没达到最后, 即为不满
            return false;
        }
        int len = this.tail - this.head;
        if (len >= this.capacity) {
            // 队列中的元素个数超过队列容量
            return true;
        }
        return false;
    }

    /**
     * 入队列
     *
     * @param ele
     */
    public boolean enqueue(String ele) {
        if (ele == null) {
            return false;
        }
        int h = this.head;
        if (this.tail == this.capacity) {
            // 队列已满
            if (h == 0) return false;
            //移动元素
            int len = this.tail - h;
            for (int i = 0; i < len; i++) {
                this.data[i] = this.data[i + h];
            }
            this.tail = this.tail - this.head;
            this.head = 0;
        }
        this.data[tail] = ele;
        tail = tail + 1;
        return true;
    }

    public boolean dequeue() {
        boolean empty = isEmpty();
        if (empty) {
            return false;
        }
        String ele = this.data[head];
        head = head + 1;
        return true;
    }

    private void printAll() {
        for (int i = head; i < this.tail; i++) {
            System.out.println(i + " " + this.data[i]);
        }
    }

    public static void main(String[] args) {
        ArrayQueueDemo demo = new ArrayQueueDemo(5);
        demo.enqueue("0");
        demo.enqueue("1");
        demo.enqueue("2");
        demo.enqueue("3");
        demo.enqueue("4");
        demo.enqueue("5");
        demo.printAll();
        System.out.println("*******");
        demo.dequeue();
        demo.printAll();

        
        
        
        System.out.println("*******");
        demo.dequeue();
        demo.printAll();
        demo.dequeue();
    }

}
