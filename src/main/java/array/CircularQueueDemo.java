package array;

public class CircularQueueDemo {
    private int capacity;
    private int count;
    private String[] data;
    private int head;
    private int tail;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public CircularQueueDemo(int capacity) {
        this.data = new String[capacity];
        this.capacity = capacity;
    }

    public CircularQueueDemo() {
    }


    private boolean isEmpty() {
        int h = getHead();
        int t = getTail();
        if (h == t) {
            return true;
        }
        return false;
    }

    private boolean isFull() {
        int h = getHead();
        int t = getTail();
        int cap = getCapacity();
        if ((t + 1) % cap == h) {
            return true;
        }
        return false;
    }

    /**
     * 入队操作
     *
     * @param ele
     * @return
     */
    public boolean enqueue(String ele) {
        int cap = getCapacity();
        boolean full = isFull();
        if (full) {
            return false;
        }
        int t = getTail();
        this.data[t] = ele;
        int tmp = (t + 1) % cap;
        setTail(tmp);
        return true;
    }

    /**
     * 出队列
     *
     * @return
     */
    public boolean dequeue() {
        boolean empty = isEmpty();
        if (empty) {
            return false;
        }
        int h = getHead();
        int cap = getCapacity();
        String ele = this.data[h];
        int tmp = (h + 1) % cap;
        setHead(tmp);
        return true;
    }

    public void printAll() {
        int h = getHead();
        int t = getTail();
        for (int i = h; i < t; i++) {
            System.out.println(i + " " + this.data[i]);
        }
        System.out.println("*************");
    }

    public static void main(String[] args) {
        CircularQueueDemo demo = new CircularQueueDemo(5);
        demo.enqueue("0");
        demo.enqueue("1");
        demo.enqueue("2");
        demo.enqueue("3");
        demo.enqueue("4");
        demo.enqueue("5");
        demo.printAll();
        demo.dequeue();
        demo.dequeue();
        demo.printAll();
    }

}
