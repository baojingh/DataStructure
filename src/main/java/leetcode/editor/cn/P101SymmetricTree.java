//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索


package leetcode.editor.cn;

import java.util.LinkedList;

//Java：对称二叉树
public class P101SymmetricTree {
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
        Solution solution = new P101SymmetricTree().new Solution();

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
         * 广度优先遍历，使用队列
         * 每次入队列两个节点，这两个节点是对称的
         *
         * @param root
         * @return
         */
        public boolean isSymmetric(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            if (root == null) {
                return true;
            }
            queue.offer(root.left);
            queue.offer(root.right);
            while (queue.size() > 0) {
                TreeNode leftNode = queue.poll();
                TreeNode rightNode = queue.poll();
                /**
                 * 2的右子节点以及2的左子节点是null，并不能确定不是对称的，因此，还需要继续向下遍历，验证两个节点3，3
                 *      1
                 *   2    2
                 * 3         3
                 *
                 */
                if (leftNode == null && rightNode == null) {
                    continue;
                }
                // 如果其中一个节点是null，那就可以说明不是对称的
                /**
                 * 2的右子节点以及2的左子节点是null，并不能确定不是对称的，因此，还需要继续向下遍历，验证两个节点3，3
                 *      1
                 *   2    2
                 * 3
                 *
                 */
                if (leftNode == null || rightNode == null) {
                    return false;
                }
                // 值不相等，说明是不对称的
                if (leftNode.val != rightNode.val) {
                    return false;
                }
                // 注意，对称入队列
                queue.offer(leftNode.left);
                queue.offer(rightNode.right);

                queue.offer(leftNode.right);
                queue.offer(rightNode.left);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}