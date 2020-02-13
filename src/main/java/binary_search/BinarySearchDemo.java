package binary_search;

/**
 * @Author: hebj
 * @Date: 2020/2/12 19:42
 */
public class BinarySearchDemo {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 7, 8, 9};
        int index = binarySearch1(arr, 2);
        System.out.println("exists:" + index);
    }

    /**
     * https://leetcode-cn.com/problems/binary-search/solution/er-fen-cha-zhao-xiang-jie-by-labuladong/
     *
     * @param arr
     * @param data
     * @return
     */
    public static boolean binarySearch(int[] arr, int data) {
        int low = 0;
        int len = arr.length;
        int high = len - 1;
        // low<high, 如果最后一个元素满足条件，此时就搜索不到最后一个元素
        while (low <= high) {
            // 避免整数过大，溢出
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > data) {
                high = mid - 1;
            } else if (arr[mid] < data) {
                // {1,3,5}, 寻找4; 如果low = mid; 会在此处一直循环;
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找第一个等于指定值的元素，即数组中包含重复元素
     */
    public static int binarySearch1(int[] arr, int data) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > data) {
                high = mid - 1;
            } else if (arr[mid] < data) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] != data) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;

    }

}
