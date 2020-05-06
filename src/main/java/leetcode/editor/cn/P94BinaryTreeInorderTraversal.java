//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Java：二叉树的中序遍历
public class P94BinaryTreeInorderTraversal {
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
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
        List<Integer> integers = solution.inorderTraversal(node1);
        System.out.println(integers.toString());
    }

    /**
     * 递归-中序遍历
     *
     * @param node
     */
    public static void middleOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        middleOrder(node.left);
        System.out.println(node.val);
        middleOrder(node.right);
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
         * 迭代方法：
         * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
         * solution/dong-hua-yan-shi-94-er-cha-shu-de-zhong-xu-bian-li/
         * <p>
         * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
         * solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode/
         * 时间复杂度：O(n)
         * 空间复杂度：O(h),h是树的高度
         * <p>
         * 1
         * / \
         * 2   3
         * \
         * 4
         * 其执行过程是
         * <p>
         * 1放入栈中，继续往左
         * 2放入栈中，继续往左
         * 此时节点为空，执行else分支
         * 首先弹出一个节点，也就是2，再往右走
         * 第四步是重点，为什么要弹出呢？
         * 因为中序遍历的顺序是:遍历左子树-打印根节点-遍历右子树
         * 现在我们往左走已经走不通了(节点为空)，所以就要退回(对应的是else分支)，再执行打印根节点这一步(即将节点保存)。
         * 打印根节点对应的就是节点2，按照中序遍历的顺序，根节点打印完了，就要遍历右子树。
         * 所以就有了root = tmp.right这一步。
         *
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                // 向左子树方向前进
                // 每前进一次，就将值入栈
                // 模拟递归
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    // 当前节点为空，就说明左子树走到头
                    // 开始出栈
                    // 出栈的元素，遍历右子树
                    TreeNode node = stack.pop();
                    list.add(node.val);
                    cur = node.right;
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}