//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索


package leetcode.editor.cn;

import java.util.LinkedList;

//Java：二叉树的最小深度
public class P111MinimumDepthOfBinaryTree {
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
        Solution solution = new P111MinimumDepthOfBinaryTree().new Solution();

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
         * 队列：入队列是将元素放入队列尾部；出队列是从头部出
         * @param root
         * @return
         */
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            int level = 1;
            // 元素插入链表尾部
            queue.offer(root);
            while (queue.size() > 0) {
                // 当前层元素个数
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    // 链表头部，元素出队列
                    TreeNode node = queue.poll();
                    // 当前如果是叶子结点，就返回level
                    if (node != null && node.left == null && node.right == null) {
                        return level;
                    }
                    //不是叶子结点
                    if (node != null && node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node != null && node.right != null) {
                        queue.offer(node.right);
                    }
                }
                level = level + 1;
            }
            return level;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}