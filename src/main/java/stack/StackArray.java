package stack;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * @Author: hebj
 * @Date: 2020/2/8 09:38
 */
public class StackArray {

    private int[] items;
    private int capacity;
    private int size;

    public StackArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        items = new int[capacity];
    }

    public StackArray() {
    }

    private boolean isEmpty() {
        if (this.size != 0) {
            return false;
        }
        return true;
    }

    private boolean isFull() {
        if (size < capacity) {
            return false;
        }
        return true;
    }

    /**
     * 入栈
     *
     * @param ele
     * @return
     */
    public boolean push(int ele) {
        if (isFull()) {
            return false;
        }
        items[size] = ele;
        size = size + 1;
        return true;
    }

    private boolean resize(int len) {
        int[] items1 = new int[len];
        for (int i = 0; i < items.length; i++) {
            items1[i] = items[i];
        }
        this.capacity = len;
        items = items1;
        return true;
    }

    /**
     * 入栈+动态扩容
     *
     * @param ele
     * @return
     */
    public boolean pushDynamic(int ele) {
        if (isFull()) {
            // 扩容成原来两倍
            resize(this.capacity * 2);
        }
        items[size] = ele;
        size = size + 1;
        return true;
    }

    public void printAll() {
        System.out.println("data in stack");
        for (int i = this.size - 1; i >= 0; i--) {
            System.out.println(items[i]);
        }
        System.out.println(String.format("data size in stack is: %s, capacity is: %s", this.size, this.capacity));
    }

    /**
     * 出栈
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int val = items[size - 1];
        size = size - 1;
        return val;
    }

    public static void main(String[] args) {
        StackArray stackArray = new StackArray(3);
        stackArray.pushDynamic(1);
        stackArray.pushDynamic(2);
        stackArray.pushDynamic(3);
        stackArray.pushDynamic(4);
        stackArray.printAll();
        stackArray.pop();
        stackArray.pop();
        stackArray.printAll();
    }

}



