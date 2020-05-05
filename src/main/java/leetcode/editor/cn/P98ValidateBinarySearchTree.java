//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;

import java.util.Stack;

//Java：验证二叉搜索树
public class P98ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;

//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//        n1.left = n2;
//        n1.right = n3;
        Solution solution = new P98ValidateBinarySearchTree().new Solution();
        boolean validBST = solution.isValidBST(node1);
        System.out.println(validBST);
//        boolean b = find(node1, 3);
//        System.out.println(b);
    }

    public static boolean find(TreeNode node, int target) {
        if (node == null) {
            return false;
        }
        boolean b;
        if (node.val > target) {
            b = find(node.right, target);
            return b;
        } else if (node.val < target) {
            b = find(node.left, target);
            return b;
        } else {
            return true;
        }
    }

    static class ValidBST {
        public boolean isValidBST(TreeNode root) {
            boolean bst = isValidBST(root, null, null);
            return bst;
        }

        private boolean isValidBST(TreeNode node, TreeNode min, TreeNode max) {
            if (node == null) {
                return true;
            }
            if (min != null && node.val <= min.val) {
                return false;
            }
            if (max != null && node.val >= max.val) {
                return false;
            }
            boolean b1 = isValidBST(node.left, min, node);
            boolean b2 = isValidBST(node.right, node, max);
            return b1 && b2;
        }
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
         * 使用栈，基于中序遍历，数据是递增的
         *
         * @param root
         * @return
         */
        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            double maxValue = - Double.MAX_VALUE;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    // 中序遍历，先找左子树
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    // 出栈
                    cur = stack.pop();
                    int curVal = cur.val;
                    // 固定一个当前的最大值，如果有比这个最大值还小的值出现，说明中序遍历的序列，不是递增的
                    if (maxValue >= curVal) {
                        return false;
                    }
                    maxValue = curVal;
                    cur = cur.right;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}