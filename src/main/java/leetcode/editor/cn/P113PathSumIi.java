//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：路径总和 II
public class P113PathSumIi {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node1.left = node2;
        node1.right = node3;

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        Solution solution = new P113PathSumIi().new Solution();

        System.out.println();
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        /**
         * 广度优先遍历
         *
         * @param root
         * @param sum
         * @return
         */
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            // 存放节点
            LinkedList<TreeNode> queue = new LinkedList<>();

            // 每个路径的节点累加和
            LinkedList<Integer> integerStack = new LinkedList<>();

            // 结果集
            LinkedList<List<Integer>> integerList = new LinkedList<List<Integer>>();

            // 每个路径的节点列表
            LinkedList<LinkedList<Integer>> integers = new LinkedList<>();
            if (root == null) {
                return integerList;
            }
            queue.offer(root);
            integerStack.offer(root.val);

            // 根节点以集合形式存入队列
            LinkedList<Integer> tmp = new LinkedList<>();
            tmp.add(root.val);
            integers.offer(tmp);

            while (queue.size() > 0) {
                // 节点出队列
                TreeNode node = queue.poll();

                // 路径累计和
                Integer integer = integerStack.poll();

                // 路径集合
                LinkedList<Integer> linkedList = integers.poll();
                // 达到叶子结点，是否有路径之和是sum
                if (node.left == null && node.right == null) {
                    if (integer == sum) {
                        // 添加到结果集
                        integerList.add(linkedList);
                    }
                }

                if (node.left != null) {
                    // 节点node的左节点入队列
                    queue.offer(node.left);
                    // 累计和入队列
                    integerStack.offer(integer + node.left.val);

                    /**
                     * ⚠️⚠️
                     * ️出队列的集合，添加左子节点，然后将此集合入队列
                     * 注意这个入队列的集合是一个全新的集合，确保集合内只有左子节点的元素
                     * 如果都使用linkedList，那么左右子节点俊晖被加入集合，无法实现左右子节点的分割
                     */
                    LinkedList<Integer> leftList = new LinkedList<>(linkedList);
                    leftList.offer(node.left.val);
                    integers.offer(leftList);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    integerStack.offer(integer + node.right.val);
                    LinkedList<Integer> rightList = new LinkedList<>(linkedList);
                    rightList.offer(node.right.val);
                    integers.offer(rightList);
                }
            }
            return integerList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}