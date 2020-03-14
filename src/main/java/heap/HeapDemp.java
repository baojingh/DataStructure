package heap;

/**
 * @Author: hebj
 * @Date: 2020/3/12 22:06
 * @Description:
 */
public class HeapDemp {

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
            heapify(arr, len, 0);

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
            heapify(arr, arr.length - 1, i);
        }
    }

    /**
     * @param arr 数组
     * @param n   最后对元素下标
     * @param i   当前元素下标, 从最大非叶子节点元素，向上直到根节点。i从大到小。
     */
    public void heapify(int[] arr, int n, int i) {
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


    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[0] = 0;
        arr[1] = 7;
        arr[2] = 5;
        arr[3] = 19;
        arr[4] = 8;
        arr[5] = 4;
        arr[6] = 1;
        arr[7] = 20;
        arr[8] = 13;
        arr[9] = 16;

        HeapDemp heapDemp = new HeapDemp();
        heapDemp.buildHeap(arr);
        System.out.println(arr.length);
    }

}
