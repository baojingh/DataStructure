//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树


package leetcode.editor.cn;

import java.util.LinkedList;

//Java：翻转二叉树
public class P226InvertBinaryTree {
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
        Solution solution = new P226InvertBinaryTree().new Solution();
        TreeNode treeNode = solution.invertTree(node1);
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
         * 从上到下依次交换
         *
         * @param root
         * @return
         */
        public TreeNode invertTree(TreeNode root) {
            TreeNode r = root;
            LinkedList<TreeNode> queue = new LinkedList<>();
            if (r == null) {
                return root;
            }
            // 加入队列尾部
            queue.offer(r);
            while (queue.size() > 0) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    // 从对头取出，并删除
                    TreeNode node = queue.poll();
                    // 先交换左右子节点
                    TreeNode tmp = node.right;
                    node.right = node.left;
                    node.left = tmp;
                    // 交换完毕，将左右节点的子节点入队列
                    /**
                     *
                     * 这种情况下，也可以交换，只是有值节点与null的交换
                     *          4
                     *      2       7
                     *   1               8
                     *
                     *
                     */
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}