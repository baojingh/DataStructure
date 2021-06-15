//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
//
// 
//
// 示例： 
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 
//
// 提示： 
//
// 
// 树中至少有 2 个节点。 
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
//相同 
// 
// Related Topics 树 
// 👍 256 👎 0


package leetcode.editor.cn;

import java.util.Stack;

//Java：二叉搜索树的最小绝对差
public class P530MinimumAbsoluteDifferenceInBst {
    //public class JianZhiMinimumAbsoluteDifferenceInBst{
    public static void main(String[] args) {
        Solution solution = new P530MinimumAbsoluteDifferenceInBst().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)


    public class TreeNode {
        int val;
        boolean isVisited;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

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


        /**
         * 中序遍历：左-中-右
         *
         * @param root
         * @return
         */
        public int getMinimumDifference(TreeNode root) {
            if (root == null) {
                /**
                 * 不存在，就返回-1
                 */
                return -1;
            }
            Stack<TreeNode> stack = new Stack<>();
            root.isVisited = false;
            stack.push(root);

            int prev = Integer.MAX_VALUE;
            int minValue = Integer.MAX_VALUE;

            while (stack.size() > 0) {
                TreeNode node = stack.pop();
                if (!node.isVisited) {
                    if (node.right != null) {
                        node.right.isVisited = false;
                        stack.push(node.right);
                    }
                    node.isVisited = true;
                    stack.push(node);
                    if (node.left != null) {
                        node.left.isVisited = false;
                        stack.push(node.left);
                    }
                } else {
                    int abs = Math.abs(node.val - prev);
                    minValue = Math.min(abs, minValue);
                    prev = node.val;
                }
            }
            return minValue;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}





































