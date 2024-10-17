package popular;


// https://leetcode.cn/problems/top-k-frequent-elements/description/

public class P347TopK {
    public static void main(String[] args) {
        System.out.println("hello");
    }


    /**
     * 设计算法
     * 1 使用map存储元素以及其出现的次数
     * 2 使用长度是k的小顶堆存储每个元素，按照其出现次数排序，降序排列
     * 3 迭代完map中的元素，堆中就是目标元素
     * <p>
     * 测试用例
     * 1 1,2,3,4,5,2,3,1 2
     * 1 1,2,3 1
     * 1 1,2,3 2
     * 1 1,2,3 3
     * 1 1,2,3 4
     * 2 1 1
     * 2 1 2
     * 2 1,1 2
     * 2 1,1 1
     * 3 null
     * 3
     *
     * @param nums
     * @param k
     * @return
     */

    public int[] topKFrequent(int[] nums, int k) {
        return null;
    }
}


