//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：二叉树的层序遍历
public class P102BinaryTreeLevelOrderTraversal {
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
        Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
        List<List<Integer>> lists = solution.levelOrder(node1);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
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
         * 参照树的最大深度/最小深度解法
         *
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            LinkedList<TreeNode> linkedList = new LinkedList<>();
            if (root == null) {
                return list;
            }
            // 入队列
            linkedList.offer(root);
            while (linkedList.size() > 0) {
                // 根节点只有一个
                int size = linkedList.size();
                // 取出这一层的节点
                // 将左右子节点加入队列
                List<Integer> tmp = new ArrayList<Integer>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = linkedList.poll();
                    tmp.add(node.val);
                    if (node.left != null) {
                        linkedList.offer(node.left);
                    }
                    if (node.right != null) {
                        linkedList.offer(node.right);
                    }
                }
                list.add(tmp);
            }
            return list;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}