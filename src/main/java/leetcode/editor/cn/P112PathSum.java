//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。 
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
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;

import java.util.LinkedList;

//Java：路径总和
public class P112PathSum {
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
        Solution solution = new P112PathSum().new Solution();

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
        public boolean hasPathSum(TreeNode root, int sum) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            LinkedList<Integer> integerStack = new LinkedList<>();
            LinkedList<String> pathStack = new LinkedList<>();
            if (root == null) {
                return false;
            }
            queue.offer(root);
            integerStack.offer(root.val);
            pathStack.offer(Integer.toString(root.val));
            while (queue.size() > 0) {
                TreeNode node = queue.poll();
                String path = pathStack.poll();
                System.out.println("[" + path + "]");
                Integer integer = integerStack.poll();
                if (node.left == null && node.right == null) {
                    if (sum == integer) {
                        System.out.println(path);
                        return true;
                    }
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    pathStack.offer(new StringBuffer(path).append(" ->").append(node.left.val).toString());
                    integerStack.offer(node.left.val + integer);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    pathStack.offer(new StringBuffer(path).append(" ->").append(node.right.val).toString());
                    integerStack.offer(node.right.val + integer);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}