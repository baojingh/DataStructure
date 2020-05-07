//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：二叉树的所有路径
public class P257BinaryTreePaths {
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
        Solution solution = new P257BinaryTreePaths().new Solution();

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
         * 1 每个节点入队列，每个节点对应的路径入队列
         * 2 队列不为空，节点出队列，节点对应的路径出队列
         * 3 如果节点的左右子节点均为null，说明这个节点是叶子结点，将其对应的路径加入list列表
         * 4 如果节点的左右子节点不为null，说明这个节点不是叶子结点
         * 将左子节点入队列；将左子节点的路径入队列
         * 将右子节点入队列；将右子节点的路径入队列
         * 5 继续执行2，终止条件是节点队列长度为0
         *
         * @param root
         * @return
         */
        public List<String> binaryTreePaths(TreeNode root) {
            // 每个节点入队列
            LinkedList<TreeNode> queue = new LinkedList<>();
            // 存储路径
            LinkedList<String> pathList = new LinkedList<>();
            // 每个节点对应的路径，入队列
            LinkedList<String> pathStack = new LinkedList<>();
            if (root == null) {
                return pathList;
            }
            queue.offer(root);
            pathStack.offer(Integer.toString(root.val));
            while (queue.size() > 0) {
                TreeNode node = queue.poll();
                String path = pathStack.poll();
                // 此节点是叶子结点
                if (node.left == null && node.right == null) {
                    pathList.add(path);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    pathStack.offer(path + "->" + node.left.val);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    pathStack.offer(path + "->" + node.right.val);
                }
            }
            return pathList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}