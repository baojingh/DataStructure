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

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Java：二叉树的中序遍历
public class P94BinaryTreeInorderTraversal {
    public static void main(String[] args) {

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
         * 中序遍历标记法
         * 左子节点-父节点-右子节点
         * <p>
         * 设计算法
         * 对树中的每个节点进行标记，即使第一次访问到了目标节点，需要对其标记并入栈但不处理数据。
         * 下一次从出栈这个被标记的数据，根据标记来对这个元素处理。
         * 标记的策略是：根据前中后遍历的需求，对数据进行标记。
         *
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            LinkedList<Integer> list = new LinkedList<>();
            if (root == null) {
                return list;
            }
            Stack<TreeNodeColor> stack = new Stack<>();
            stack.push(new TreeNodeColor(root, false));
            while (stack.size() > 0) {
                TreeNodeColor pop = stack.pop();
                if (!pop.isVisited) {
                    if (pop.treeNode.right != null) {
                        stack.push(new TreeNodeColor(pop.treeNode.right, false));
                    }
                    pop.isVisited = true;
                    stack.push(pop);
                    if (pop.treeNode.left != null) {
                        stack.push(new TreeNodeColor(pop.treeNode.left, false));
                    }
                } else {
                    list.add(pop.treeNode.val);
                }
            }
            return list;
        }


//        /**
//         * 迭代方法：
//         * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
//         * solution/dong-hua-yan-shi-94-er-cha-shu-de-zhong-xu-bian-li/
//         * <p>
//         * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
//         * solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode/
//         * 时间复杂度：O(n)
//         * 空间复杂度：O(h),h是树的高度
//         * <p>
//         * 1
//         * / \
//         * 2   3
//         * \
//         * 4
//         * 其执行过程是
//         * <p>
//         * 1放入栈中，继续往左
//         * 2放入栈中，继续往左
//         * 此时节点为空，执行else分支
//         * 首先弹出一个节点，也就是2，再往右走
//         * 第四步是重点，为什么要弹出呢？
//         * 因为中序遍历的顺序是:遍历左子树-打印根节点-遍历右子树
//         * 现在我们往左走已经走不通了(节点为空)，所以就要退回(对应的是else分支)，再执行打印根节点这一步(即将节点保存)。
//         * 打印根节点对应的就是节点2，按照中序遍历的顺序，根节点打印完了，就要遍历右子树。
//         * 所以就有了root = tmp.right这一步。
//         *
//         * @param root
//         * @return
//         */
//        public List<Integer> inorderTraversal1(TreeNode root) {
//            TreeNode cur = root;
//            LinkedList<Integer> list = new LinkedList<>();
//            Stack<TreeNode> stack = new Stack<>();
//            if (cur == null) {
//                return list;
//            }
//            stack.push(cur);
//            while (stack.size() > 0) {
//                TreeNode node = stack.pop();
//                if (node.left == null && node.right == null) {
//                    // 叶子结点
//                    // list.add((Integer.parseInt(node.val)));
//                    // 找到叶子结点，还需要继续迭代，不能向下走，不可执行stack.push(node)
//                    continue;
//                }
//                // 右子节点入栈->本节点入栈->左子节点入栈，出栈的顺序就是左中右
//                if (node.right != null) {
//                    stack.push(node.right);
//                    node.right = null;
//                }
//                stack.push(node);
//                if (node.left != null) {
//                    stack.push(node.left);
//                    node.left = null;
//                }
//            }
//            return list;
//        }
//
//
//        // https://leetcode.cn/problems/binary-tree-preorder-traversal/solutions/87526/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
//        public void inOrderIteration(TreeNode head) {
//            if (head == null) {
//                return;
//            }
//            TreeNode cur = head;
//            Stack<TreeNode> stack = new Stack<>();
//            while (!stack.isEmpty() || cur != null) {
//                while (cur != null) {
//                    stack.push(cur);
//                    cur = cur.left;
//                }
//                TreeNode node = stack.pop();
//                System.out.print(node.val);
//                if (node.right != null) {
//                    cur = node.right;
//                }
//            }
//        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}