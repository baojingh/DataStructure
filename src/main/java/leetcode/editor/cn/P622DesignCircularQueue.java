//设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。
// 它也被称为“环形缓冲器”
//。 
//
// 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，
// 即使在队列前面仍有空间。但是使用循环
//队列，我们能使用这些空间去存储新的值。 
//
// 你的实现应该支持如下操作： 
//
// 
// MyCircularQueue(k): 构造器，设置队列长度为 k 。 
// Front: 从队首获取元素。如果队列为空，返回 -1 。 
// Rear: 获取队尾元素。如果队列为空，返回 -1 。 
// enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。 
// deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。 
// isEmpty(): 检查循环队列是否为空。 
// isFull(): 检查循环队列是否已满。 
// 
//
// 
//
// 示例： 
//
// MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
//circularQueue.enQueue(1);  // 返回 true
//circularQueue.enQueue(2);  // 返回 true
//circularQueue.enQueue(3);  // 返回 true
//circularQueue.enQueue(4);  // 返回 false，队列已满
//circularQueue.Rear();  // 返回 3
//circularQueue.isFull();  // 返回 true
//circularQueue.deQueue();  // 返回 true
//circularQueue.enQueue(4);  // 返回 true
//circularQueue.Rear();  // 返回 4 
//
// 
//
// 提示： 
//
// 
// 所有的值都在 0 至 1000 的范围内； 
// 操作数将在 1 至 1000 的范围内； 
// 请不要使用内置的队列库。 
// 
// Related Topics 设计 队列


package leetcode.editor.cn;

//Java：设计循环队列
public class P622DesignCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new P622DesignCircularQueue().new MyCircularQueue(4);

        circularQueue.enQueue(1);
        circularQueue.enQueue(2);
        circularQueue.enQueue(3);
        circularQueue.enQueue(4);
        circularQueue.enQueue(5);
        circularQueue.deQueue();
        int front = circularQueue.Front();
        int rear = circularQueue.Rear();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularQueue {

        Node head;
        Node tail;
        int size;
        int capacity;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            size = 0;
            capacity = k;
            this.head = null;
            this.tail = null;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if (isFull()) {
                // 队列满，不能添加
                return false;
            }

            Node node = new Node(value);
            if (isEmpty()) {
                head = node;
                tail = node;
                head.next = tail;
                tail.next = head;
            } else {
                node.next = head;
                this.tail.next = node;
                this.tail = this.tail.next;
            }
            size = size + 1;
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         * 先进先出
         */
        public boolean deQueue() {
            if (isEmpty()) {
                // 队列空，不能出队列
                return false;
            }
            if (size == 1) {
                head = null;
                tail = null;
                size = size - 1;
                return true;
            }
            this.head = this.head.next;
            tail.next = head;
            size = size - 1;
            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (head != null) {
                return head.value;
            }
            return -1;
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (tail != null) {
                return tail.value;
            }
            return -1;
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            if (size == 0) {
                return true;
            }
            return false;

        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            if (size == capacity) {
                return true;
            }
            return false;
        }

        private void printAll() {
            System.out.println("*******************");
            Node cur = head;
            while (cur != null) {
                if (cur == tail) {
                    System.out.println(cur.value);
                    return;
                }
                System.out.println(cur.value);
                cur = cur.next;
            }
        }


    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}