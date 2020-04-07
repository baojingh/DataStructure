package array;

import java.util.HashMap;

/**
 * @Author: hebj
 * @Date: 2020/4/6 10:28
 * @Description:
 */
public class ArrayLeetcode {


    private void printAll(int[] nums) {
        if (nums == null) {
            System.out.println("array is null");
            return;
        }
        System.out.println("array:");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * 链接：https://leetcode-cn.com/problems/two-sum
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            Integer integer = map.get(val);
            if (integer == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{i, integer};
            }
        }
        return null;
    }


    public static void main(String[] args) {
        ArrayLeetcode array = new ArrayLeetcode();
        int[] nums = new int[]{1, 8, 6, 8, 9};
        int target = 16;
        int[] ints = array.twoSum(nums, target);
        array.printAll(ints);
    }
}
