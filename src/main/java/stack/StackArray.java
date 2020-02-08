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

    /**
     * 入栈+动态扩容
     *
     * @param ele
     * @return
     */
    public int pushDynamic(int ele) {

        return 1;
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
//        StackArray stackArray = new StackArray(3);
//        stackArray.push(1);
//        stackArray.push(2);
//
//        int v1 = stackArray.pop();
//        System.out.println(v1);
//
//        stackArray.push(3);
//
//        int v2 = stackArray.pop();
//        System.out.println(v2);
        while (true) {
            System.out.println("hello");
        }

    }


}
