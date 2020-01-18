package array;

public class StaticArray {

    private int capacity;
    private int count;
    private int[] data;

    public StaticArray(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        this.count = 0;
    }

    public void increase() {
        int cap = getCapacity();
        if (this.count < cap) {
            this.count = this.count + 1;
        }

    }

    public void decrease() {
        int len = getLen();
        if (len > 0) {
            this.count = this.count - 1;
        }

    }

    /**
     * 获取数组长度
     *
     * @return
     */
    public int getLen() {
        return this.count;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isFull() {
        int n = getLen();
        int cap = getCapacity();
        if (n >= cap) {
            return true;
        }
        return false;
    }

    /**
     * 数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        int n = getLen();
        if (n == 0) {
            return true;
        }
        return false;
    }

    /**
     * 获取数组容量
     *
     * @return
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * 向数组中插入元素
     *
     * @param index
     * @param ele
     * @return
     */
    public boolean insert(int index, int ele) {
        boolean isFull = isFull();
        int len = getLen();
        int cap = getCapacity();

        if (isFull) {
            return false;
        }
        if (index < 0 || index > cap - 1) {
            return false;
        }
        for (int i = len; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = ele;
        increase();
        return true;
    }

    public boolean delete(int index) {
        int cap = getCapacity();
        int len = getLen();
        boolean isEmpty = isEmpty();
        if (isEmpty) {
            return false;
        }
        if (index < 0 || index > cap - 1) {
            return false;
        }
        for (int i = index; i < len - 1; i++) {
            data[i] = data[i + 1];
        }
        decrease();
        return true;
    }

    public void printAll() {
        for (int ele : this.data) {
            System.out.println(ele);
        }
    }

    public StaticArray() {
    }


}
