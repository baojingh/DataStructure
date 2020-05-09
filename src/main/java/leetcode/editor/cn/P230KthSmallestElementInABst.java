//给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。 
//
// 说明： 
//你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 1 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 3 
//
// 进阶： 
//如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？ 
// Related Topics 树 二分查找


package leetcode.editor.cn;

import java.util.Stack;

//Java：二叉搜索树中第K小的元素
public class P230KthSmallestElementInABst {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(10);
        TreeNode node7 = new TreeNode(11);


        node2.left = node1;
        node2.right = node3;

        node6.left = node5;
        node6.right = node7;

        node4.left = node2;
        node4.right = node6;

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        Solution solution = new P230KthSmallestElementInABst().new Solution();
        int smallest = solution.kthSmallest(node4, 3);
        System.out.println(smallest);
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
         * 深度优先搜索
         * 中序遍历，节点顺序递增
         * 第k小，就是从小到大排序，第k个数据
         *
         * @param root
         * @param k
         * @return
         */
        public int kthSmallest(TreeNode root, int k) {
            if (root == null) {
                return 0;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            int res = -1;
            int count = 0;
            while (stack.size() > 0) {
                TreeNode node = stack.pop();
                // 叶子结点，就表示这是第几个数
                if (node.left == null && node.right == null) {
                    count = count + 1;
                    if (count == k) {
                        // 达到目标数，就退出
                        res = node.val;
                        break;
                    }
                    // 叶子结点，注意不能执行后面的stack.push(node)，此处应该继续迭代，从stack中取值
                    continue;
                }
                if (node.right != null) {
                    stack.push(node.right);
                    node.right = null;
                }
                stack.push(node);
                if (node.left != null) {
                    stack.push(node.left);
                    node.left = null;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}