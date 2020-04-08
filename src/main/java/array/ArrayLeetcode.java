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

    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * <p>
     * 图解比较清晰
     * https://leetcode-cn.com/problems/container-with-most-water
     * /solution/container-with-most-water-shuang-zhi-zhen-fa-yi-do/
     * <p>
     * https://leetcode-cn.com/problems/container-with-most-water/solution/
     * man-hua-bi-xu-neng-kan-dong-de-ti-jie-xiao-hao-chu/#comment
     * <p>
     * 为什么要将短板向长板方向移动？反证法
     * 假设height[start] < height[end]
     * w = end - start
     * area = height[start] * w
     * <p>
     * 假设移动短板到start1
     * 如果height[start1] > height[end]
     * height[end] * (w -1) 可能打或者可能小，可能相等
     * 如果height[start1] < height[end]
     * height[start1] * (w -1) 可能打或者可能小，可能相等
     * <p>
     * 假如移动长板到end1
     * 如果height[end1] > height[start]
     * height[start] * (w -1) < area
     * 如果height[end1] < height[start]
     * height[end1] * (w -1) < area
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int area = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int start = height[i];
            int end = height[j];
            int temp_area = 0;
            if (start > end) {
                // 短板向后
                temp_area = (j - i) * end;
                j = j - 1;
            } else {
                // 短板向前移动
                temp_area = (j - i) * start;
                i = i + 1;
            }
            area = Math.max(area, temp_area);
        }
        return area;
    }


    public static void main(String[] args) {
        ArrayLeetcode array = new ArrayLeetcode();
        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int target = 16;
//        int[] ints = array.twoSum(nums, target);
//        array.printAll(ints);
        int i = array.maxArea(nums);
        System.out.println(i);

    }
}
