package array;

/**
 * @Author: hebj
 * @Date: 2020/3/15 09:51
 * @Description: 合并两个有序数组
 */
public class MergeTwoArray {

    /*
        给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
        说明:
        初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
        你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
        输入:
        nums1 = [1,2,3,0,0,0], m = 3
        nums2 = [2,5,6],       n = 3
        输出: [1,2,2,3,5,6]
     */

    /**
     * @param arr1
     * @param arr1Len 有元素的长度
     * @param arr2
     * @param arr2Len 有元素的长度
     */
    public void merge(int[] arr1, int arr1Len, int[] arr2, int arr2Len) {
        int i = arr1Len - 1;
        int j = arr2Len - 1;
        int k = arr1Len + arr2Len - 1;
        // 主要利用两个数组的有序性
        // 比较两个数组的最后面的元素，从后向前比较。将大元素放入arr1中最后面的位置，从后向前放元素。
        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) {
                arr1[k] = arr1[i];
                k = k - 1;
                i = i - 1;
            } else {
                arr1[k] = arr2[j];
                k = k - 1;
                j = j - 1;
            }
        }
        // arr2中剩余的元素，依次放入arr1
        while (j >= 0) {
            arr1[k] = arr2[j];
            k = k - 1;
            j = j - 1;
        }
    }

    public static void main(String[] args) {
        MergeTwoArray array = new MergeTwoArray();
        int[] a1 = new int[]{2, 5, 8, 9, 11, -1, -1, -1, -1, -1, -1};
        int[] a2 = new int[]{3, 6, 15};
        array.merge(a1, 5, a2, 3);
        for (int value : a1) {
            System.out.println(value);
        }
    }

}
