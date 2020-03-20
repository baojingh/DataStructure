package heap;

/**
 * @Author: hebj
 * @Date: 2020/3/12 22:06
 * @Description:
 */
public class HeapDemp {

    private int[] arr;
    private int capacity;
    private int count;

    public HeapDemp(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.count = 0;
    }

    public HeapDemp() {
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCount() {
        return this.count;
    }

    public void incByOne() {
        this.count = this.count + 1;
    }

    public void descByOne() {
        this.count = this.count - 1;
    }

    private boolean isEmpty() {
        return 0 == this.count;
    }

    private boolean isFull() {
        return this.capacity == this.count;
    }

    public void sort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        buildHeap(arr);
        int len = arr.length - 1;
        while (len > 0) {
            // 将堆顶元素与最后一个元素交换
            swapValue(arr, 0, len);
            // 将剩下元素重新堆化，堆顶元素变成最大元素
            heapify(len, 0);
        }
    }


    public void buildHeap(int[] arr) {
        // 树中最后一个非叶子节点位置，(arr.length -1) / 2
        // 从最后一个非叶子节点，依次堆化，直到根节点
        if (arr == null) {
            return;
        }
        int len = (arr.length - 1) / 2;
        for (int i = len; i > -1; i--) {
            heapify(arr.length - 1, i);
        }
    }

    /**
     * @param n 最后对元素下标
     * @param i 当前元素下标, 从最大非叶子节点元素，向上直到根节点。i从大到小。
     */
    public void heapify(int n, int i) {
        while (true) {
            int maxPos = i;
            // 与左子节点比较，[n/2 + 1, n]属于叶子节点，不需要堆化
            if (i * 2 + 1 <= n && arr[i] <= arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            // 最大值与右子节点 i * 2 + 2 比较，获取最大值位置
            if (i * 2 + 2 <= n && arr[maxPos] < arr[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            // 最大值与当前位置相等，就结束循环
            if (maxPos == i) {
                break;
            }
            swapValue(arr, i, maxPos);
            // 以交换后子节点位置继续向下查找
            i = maxPos;
        }
    }

    private void swapValue(int[] arr, int i, int maxPos) {
        arr[i] = arr[i] + arr[maxPos];
        arr[maxPos] = arr[i] - arr[maxPos];
        arr[i] = arr[i] - arr[maxPos];
    }

    public void insert(int data) {
        // 数组满
        if (isFull()) {
            return;
        }
        int i = this.count + 1;
        if (isEmpty()) {
            i = 1;
        }
        arr[i] = data;
        incByOne();
        // 维持大顶堆
        while (i / 2 > 0 && arr[i] > arr[i / 2]) {
            swapValue(arr, i, i / 2);
            i = i / 2;
        }
    }

    private void printAll() {
        for (int i = 1; i <= this.count; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 删除堆顶元素
     */
    public void deleteMax() {
        if (isEmpty()) {
            return;
        }
        int len = getCount();
        arr[1] = arr[len];
        descByOne();
        // 此处堆化有问题，先比较左子树还是右子树？2020-03-18，参考数据结构与算法之美的删除节点中的堆化方法
        heapify(getCount(), 1);
    }



    public static void main(String[] args) {

        HeapDemp heapDemp = new HeapDemp(20);
//        heapDemp.insert(33);
//        heapDemp.insert(17);
//        heapDemp.insert(21);
//        heapDemp.insert(16);
//        heapDemp.insert(13);
//        heapDemp.insert(15);
//        heapDemp.insert(9);
//        heapDemp.insert(5);
//        heapDemp.insert(6);
//        heapDemp.insert(7);
//        heapDemp.insert(8);
//        heapDemp.insert(1);
//        heapDemp.insert(2);
//        heapDemp.insert(22);

        heapDemp.insert(33);
        heapDemp.insert(27);
        heapDemp.insert(21);
        heapDemp.insert(16);
        heapDemp.insert(13);
        heapDemp.insert(15);
        heapDemp.insert(19);
        heapDemp.insert(5);
        heapDemp.insert(6);
        heapDemp.insert(7);
        heapDemp.insert(8);
        heapDemp.insert(1);
        heapDemp.insert(2);
        heapDemp.insert(12);
        heapDemp.printAll();
        System.out.println();
        heapDemp.deleteMax();
        heapDemp.printAll();

//        heapDemp.buildHeap(arr);
//        System.out.println(arr.length);
    }

}
