package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

    private void printList(List<List<Integer>> list) {
        for (List<Integer> val : list) {
            System.out.println(val);
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

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * 示例：
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     * 链接：https://leetcode-cn.com/problems/3sum
     * 时间复杂度O
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> arrayList = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return arrayList;
        }
        Arrays.sort(nums);
        int len = nums.length;
        // 此处不许i < len -1,因为while条件会验证L与R大小
        for (int i = 0; i < len; i++) {
            // 选取i对应的元素
            int base = nums[i];
            // base如果是正值，其后面的值肯定也是正值，因为数组被排序了。
            // continue代表进行下一次循环
            if (base > 0) {
                // base大于0，后续树枝都会比base大，说明后续没有数字相加之和是0
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 为base去重
                continue;
            }
            // 比较区间[i+1, len - 1]
            // 选区区间内的元素分别与base相加，是否是0
            // 数组已排序，因此可以从两端向中间靠拢
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[L] + nums[R] + base;
                if (sum == 0) {
                    List<Integer> integerList = Arrays.asList(base, nums[L], nums[R]);
                    arrayList.add(integerList);
                    // 三数之和大于0，代表右侧数据比较大，右侧指针向左移动
                    // 移动过程中发现两个相邻数据相等，就跳过
                    // 此处为什么需要加 R > L ？ 应对[0,0,0]的情况
                    while (R > L && nums[R] == nums[R - 1]) {
                        R = R - 1;
                    }
                    // 三数之和小于0，代表左侧数据比较小，左侧指针向右移动
                    // 移动过程中发现两个相邻数据相等，就跳过
                    while (R > L && nums[L] == nums[L + 1]) {
                        L = L + 1;
                    }
                    R = R - 1;
                    L = L + 1;
                } else if (sum > 0) {
                    // 此处可以优化，如果与其左侧的值相等，就直接跳过
                    /**
                     while (nums[R] == nums[R - 1]) {
                     R = R - 1;
                     }
                     */
                    R = R - 1;
                } else if (sum < 0) {
                    // 优化方法参看上述信息
                    L = L + 1;
                }
            }
        }
        return arrayList;
    }


    public static void main(String[] args) {
        ArrayLeetcode array = new ArrayLeetcode();
        int[] nums = new int[]{};
//        int target = 16;
//        int[] ints = array.twoSum(nums, target);
//        array.printAll(ints);
//        int i = array.maxArea(nums);
//        System.out.println(i);
        List<List<Integer>> lists = array.threeSum(nums);
        array.printList(lists);
    }
}
