package heap;

import lombok.Data;

/**
 * @Author: baojing.he
 * @Date: 2021-03-17 22:13
 * @Description: https://www.jianshu.com/p/4c7ad59a0489
 */

@Data
public class ThinkInHeap {


    private int[] arr;
    private int capacity;
    private int size;

    public ThinkInHeap(int capacity) {
        this.capacity = capacity;
        size = 0;
        arr = new int[capacity + 1];
    }

    public ThinkInHeap() {
    }

    private static void swap(int[] arr, int p1, int p2) {
        arr[p1] = arr[p1] ^ arr[p2];
        arr[p2] = arr[p1] ^ arr[p2];
        arr[p1] = arr[p1] ^ arr[p2];
    }

    public void insert(int data) {
        if (size > capacity) {
            return;
        }
        size = size + 1;
        arr[size] = data;
        int i = size;
        swim(i);
    }

    /**
     * 元素上移
     *
     * @param i
     */
    private void swim(int i) {
        /**
         * 大顶堆
         *
         * 当前节点索引是i，父索引是i/2
         * 当前节点大于父节点，交换
         */

        /**
         * 此处应该使用i/2
         * 当i=1时，不应该去执行交换。
         */
        while (i > 1 && arr[i] > arr[i / 2]) {
            swap(arr, i, i / 2);
            i = i / 2;
        }
    }

    /**
     *
     */
    public int delete() {
        /**
         * 堆中没有元素
         */
        if (this.size == 0) {
            return -1;
        }
        int max = arr[1];
        arr[1] = arr[size];
        size = size - 1;
        sink(1);
        return max;
    }


    /**
     * 元素下移
     * https://blog.csdn.net/csdn_blog_lcl/article/details/78186954
     *
     * @param k
     */
    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            /**
             * j指向i节点最大的子节点
             */
            if ((j < size) && (arr[j] < arr[j + 1])) {
                j = j + 1;
            }
            if (arr[k] >= arr[j]) {
                break;
            }
            swap(arr, k, j);
            k = j;
        }

    }


    public void printAll() {
        for (int i = 1; i < arr.length-1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }


    public static void main(String[] args) {
        ThinkInHeap heap = new ThinkInHeap(7);
        heap.insert(5);
        heap.insert(4);
        heap.insert(6);
        heap.insert(1);
        heap.insert(8);
        heap.insert(9);
        heap.printAll();


        int[] newArr = new int[8];
        int[] arr = heap.getArr();
        for (int i = 1; i < arr.length; i++) {
            newArr[i] = heap.delete();
        }

        for (int i = 1; i < newArr.length - 1; i++) {
            System.out.print(newArr[i] + " ");
        }


    }
}
