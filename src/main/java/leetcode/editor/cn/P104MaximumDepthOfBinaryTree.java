//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Stack;

//Java：二叉树的最大深度
public class P104MaximumDepthOfBinaryTree {
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
        Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();

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

    class Pair {
        /**
         * 存储当前节点以及对应的深度，深度就是节点个数
         */
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }

    }

    class MaxDeepth {
        public int maxDepth(TreeNode root) {
            Stack<Pair> stack = new Stack<>();
            int maxLevel = 0;
            stack.push(new Pair(root, 1));
            while (!stack.isEmpty()) {
                Pair pop = stack.pop();
                int level = pop.level;
                TreeNode node = pop.node;
                if (node != null) {
                    maxLevel = Math.max(maxLevel, level);
                    stack.push(new Pair(node.left, level + 1));
                    stack.push(new Pair(node.right, level + 1));
                }
            }
            return maxLevel;
        }
    }


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
        public int maxDepth(TreeNode root) {
            int level = 0;
            if (root == null) {
                return level;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            // 链表的尾部插入元素
            queue.offer(root);
            while (queue.size() > 0) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    // 链表头部元素，并删除
                    TreeNode node = queue.poll();
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