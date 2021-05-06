//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 311 👎 0


package leetcode.editor.cn;


import leetcode.editor.cn.P100SameTree.TreeNode;

import java.util.LinkedList;

//Java：左叶子之和
public class P404SumOfLeftLeaves {
    //public class JianZhiSumOfLeftLeaves{
    public static void main(String[] args) {
        Solution solution = new P404SumOfLeftLeaves().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            int widesearch = widesearch(root);
            return widesearch;
        }

        /**
         * 广度优先遍历，只遍历左叶子节点
         *
         * @param root
         */
        private int widesearch(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int sum = 0;
            while (queue.size() > 0) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                if (isLeaf(poll.left)) {
                    sum = sum + poll.left.val;
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            return sum;

        }

        /**
         * 当前节点是否是叶子节点
         *
         * @param node
         * @return
         */
        private boolean isLeaf(TreeNode node) {
            if (node != null && node.left == null && node.right == null) {
                return true;
            }
            return false;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}