package utils;

import java.util.LinkedList;

/**
 * @Author: hebj
 * @Date: 2020/5/12 23:26
 * @Description:
 */
public class TreeFormatUtils {

    /**
     * 根据数据，基于广度优先遍历，输出树形
     * input：[1,2,3,4,5]
     * output
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     *
     * @return
     */
    public static TreeNode printTree(Integer[] nums) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        if (nums.length < 1) {
            return null;
        }
        linkedList.offer(nums[0]);
        while (linkedList.size() > 0) {
            Integer num = linkedList.poll();
        }
        return null;
    }

    public static void main(String[] args) {
//        Integer[] nums = new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        Integer[] nums = new Integer[]{1, null, 8, null, 1};
        TreeNode root = createTree(nums);
        System.out.println(root);
    }

    /**
     * 1 添加数组首元素（转换成节点对象）到队列
     * 2 队列中的队尾元素出队，取出数组中的元素，转换成节点，添加到其左子节点；
     * 取出数组中的下一个元素，转换成节点添加到其右子节点。这部分是将树中这一层的节点，全部加入队列
     * 3 处理树下一层的节点，注意数组索引；计算下一层节点数量，队列元素个数*2，
     *
     * @param nums
     * @return
     */
    private static TreeNode createTree(Integer[] nums) {
        int len = nums.length;
        if (len < 1 || nums[0] == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.offer(root);
        // 每一行起始元素在数组中的索引位置
        int startIndex = 1;
        // 当前行的节点数量
        int nodeNum = 2;
        // 数组中剩余元素数量
        int restNum = len - 1;
        while (restNum > 0) {
            for (int i = startIndex; i < startIndex + nodeNum; i = i + 2) {
                TreeNode node = queue.poll();
                if (i > len - 1) {
                    // 指针查处范围，说明数组元素用完了，返回
                    return root;
                }
                if (nums[i] != null) {
                    // 元素为空，就不能添加
                    node.left = new TreeNode(nums[i]);
                    queue.offer(node.left);
                }
                if (i + 1 > len - 1) {
                    // 指针查处范围，说明数组元素用完了，返回
                    return root;
                }
                if (nums[i + 1] != null) {
                    // 元素为空，就不能添加
                    node.right = new TreeNode(nums[i + 1]);
                    queue.offer(node.right);
                }
            }
            startIndex = startIndex + nodeNum;
            restNum = restNum - nodeNum;
            // 队列中的元素个数是这一行的节点个数
            nodeNum = queue.size() * 2;
        }
        return root;
    }

    private int treeHight(TreeNode root) {
        return 0;
    }

    private int treeWidth(TreeNode root) {
        return 0;
    }

    static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode(Integer x) {
            val = x;
        }
    }

}
