package heap;

import lombok.Data;

/**
 * @Author: baojing.he
 * @Date: 2021-03-17 22:13
 * @Description:
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
        arr[1] = arr[size - 1];
        size = size - 1;
        heapify(1);
        return max;
    }

//    //堆删除元素时的元素下移
//    private void shiftDown(int i) {
//        // TODO Auto-generated method stub
//        while(2*i <= size){
//            // 将要将data[i]与data[j]交换
//            int j = 2*i;
//            // 让j指向他的孩子结点中的大的那一个
//            if(j+1 <= size && data[j] < data[j+1]){
//                j += 1;
//            }
//            if(data[i] > data[j])
//                break;
//            //元素下移
//            int t = data[i];
//            data[i] = data[j];
//            data[j] = t;
//            i = j;
//        }
//    }

    /**
     * 元素下移
     * https://blog.csdn.net/csdn_blog_lcl/article/details/78186954
     *
     * @param i
     */
    private void heapify(int i) {
        while (2 * i <= size) {
            int j = 2 * i;
            /**
             * j指向i节点最大的子节点
             */
            if (arr[j] < arr[j + 1]) {
                j = j + 1;
            }
            swap(arr, i, j);
            i = j;
        }

    }

    public void printAll() {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }


    public static void main(String[] args) {
        ThinkInHeap heap = new ThinkInHeap(5);
        heap.insert(5);
        heap.insert(4);
        heap.insert(6);
        heap.insert(1);
        heap.insert(2);


        int[] arr = heap.getArr();
        for (int i = 1; i < arr.length; i++) {
            heap.heapify(i);
        }

        heap.printAll();


    }
}
