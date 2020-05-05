//给定两个二叉树，编写一个函数来检验它们是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 示例 1: 
//
// 输入:      1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true 
//
// 示例 2: 
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
// 
//
// 示例 3: 
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
// 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;

import java.util.Stack;

//Java：相同的树
public class P100SameTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;

        Solution solution = new P100SameTree().new Solution();
        boolean sameTree = solution.isSameTree(node1, n1);
        System.out.println(sameTree);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean sameTree1 = isSameTree(p.left, q.left);
        boolean sameTree2 = isSameTree(p.right, q.right);
        boolean b = sameTree1 && sameTree2;
        return b;
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
         * 迭代的方案
         * https://leetcode-cn.com/problems/same-tree/solution/
         * dong-hua-yan-shi-100-xiang-tong-de-shu-by-user7439/
         *
         * @param p
         * @param q
         * @return
         */
        public boolean isSameTree(TreeNode p, TreeNode q) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pCur = p;
            TreeNode qCur = q;
            // 根节点元素入栈
            // 注意顺序，p，q
            stack.push(qCur);
            stack.push(pCur);
            while (!stack.isEmpty()) {
                pCur = stack.pop();
                qCur = stack.pop();
                // 遇到叶子结点，就跳过
                if (qCur == null && pCur == null) {
                    continue;
                }
                // 当前p，q均不为空且两个值相等，才会入栈
                //不相等情况： 一个为空，一个不为空；两个值不相等
                if (qCur != null && pCur != null && qCur.val == pCur.val) {
                    stack.push(pCur.left);
                    stack.push(qCur.left);
                    stack.push(pCur.right);
                    stack.push(qCur.right);
                } else {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}