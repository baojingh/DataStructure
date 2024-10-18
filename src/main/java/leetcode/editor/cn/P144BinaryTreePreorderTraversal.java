//给定一个二叉树，返回它的 前序 遍历。 
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
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Java：二叉树的前序遍历
public class P144BinaryTreePreorderTraversal {
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
        Solution solution = new P144BinaryTreePreorderTraversal().new Solution();
        List<Integer> list = solution.preorderTraversal(node1);
        System.out.println(list.toString());
    }

    /**
     * 先访问本节点-再访问左子节点-再访问右子节点
     *
     * @param node
     */
    public static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    static class TreeNode {
        int val;
        boolean isVisited;
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

        public class TreeNodeColor {
            TreeNode treeNode;
            boolean isVisited;

            public TreeNodeColor(TreeNode treeNode, boolean isVisited) {
                this.treeNode = treeNode;
                this.isVisited = isVisited;
            }

            public TreeNodeColor() {
            }
        }

        /**
         * 前序遍历标记法
         * 父节点-左子节点-右子节点
         * <p>
         * 设计算法
         * 对树中的每个节点进行标记，即使第一次访问到了目标节点，需要对其标记并入栈但不处理数据。
         * 下一次从出栈这个被标记的数据，根据标记来对这个元素处理。
         * 标记的策略是：根据前中后遍历的需求，对数据进行标记。
         *
         * @param root
         * @return
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            LinkedList<Integer> list = new LinkedList<>();
            if (root == null) {
                /**
                 * 树是否是空
                 */
                return list;
            }
            Stack<TreeNodeColor> stack = new Stack<>();
            stack.push(new TreeNodeColor(root, false));
            while (stack.size() > 0) {
                TreeNodeColor pop = stack.pop();
                if (!pop.isVisited) {
                    if (pop.treeNode.right != null) {
                        TreeNode right = pop.treeNode.right;
                        stack.push(new TreeNodeColor(right, false));
                    }
                    if (pop.treeNode.left != null) {
                        TreeNode left = pop.treeNode.left;
                        stack.push(new TreeNodeColor(left, false));
                    }
                    pop.isVisited = true;
                    stack.push(pop);
                } else {
                    list.add(pop.treeNode.val);
                }
            }
            return list;


//            Stack<TreeNode> stack = new Stack<>();
//            LinkedList<Integer> list = new LinkedList<>();
//            stack.push(root);
//            while (stack.size() > 0) {
//                TreeNode pop = stack.pop();
//                if (!pop.isVisited) {
//                    if (pop.right != null) {
//                        TreeNode right = pop.right;
//                        right.isVisited = false;
//                        stack.push(right);
//                    }
//                    if (pop.left != null) {
//                        TreeNode left = pop.left;
//                        left.isVisited = false;
//                        stack.push(left);
//                    }
//                    pop.isVisited = true;
//                    stack.push(pop);
//                } else {
//                    list.add(pop.val);
//                }
//            }
//            return list;
        }


//        /**
//         * https://leetcode.cn/problems/binary-tree-preorder-traversal/solutions/87526/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
//         * https://blog.51cto.com/u_15102970/2637848
//         * @param root
//         * @return
//         */
//        public List<Integer> preorderTraversal1(TreeNode root) {
//            List<Integer> list = new ArrayList<>();
//            if (root == null) {
//                return list;
//            }
//            Stack<TreeNode> stack = new Stack<>();
//            stack.push(root);
//            while (stack.size() > 0) {
//                TreeNode node = stack.pop();
//                list.add(node.val);
//                if (node.right != null) {
//                    stack.push(node.right);
//                }
//                if (node.left != null) {
//                    stack.push(node.left);
//                }
//            }
//            return list;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
































