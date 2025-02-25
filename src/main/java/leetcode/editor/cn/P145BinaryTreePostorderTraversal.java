//给定一个二叉树，返回它的 后序 遍历。 
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
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Java：二叉树的后序遍历
public class P145BinaryTreePostorderTraversal {
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

        P145BinaryTreePostorderTraversal.Solution solution = new P145BinaryTreePostorderTraversal().new Solution();
        List<Integer> integers = solution.postorderTraversal(node1);


        System.out.println(Arrays.toString(integers.toArray()));
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
         * 后续遍历
         * 左-右-中
         *
         * @param root
         * @return
         */
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new LinkedList<>();
            if (root == null) {
                return list;
            }
            Stack<TreeNodeColor> stack = new Stack<>();
            stack.push(new TreeNodeColor(root, false));
            while (stack.size() > 0) {
                TreeNodeColor pop = stack.pop();
                if (!pop.isVisited) {
                    pop.isVisited = true;
                    stack.push(pop);
                    if (pop.treeNode.right != null) {
                        stack.push(new TreeNodeColor(pop.treeNode.right, false));
                    }
                    if (pop.treeNode.left != null) {
                        stack.push(new TreeNodeColor(pop.treeNode.left, false));
                    }
                } else {
                    list.add(pop.treeNode.val);
                }
            }
            return list;
        }


//        public List<Integer> postorderTraversal(TreeNode root) {
//            ArrayList<Integer> list = new ArrayList<>();
//            if (root == null) {
//                return list;
//            }
//            Stack<TreeNode> stack = new Stack<>();
//            TreeNode cur = root;
//            while (cur != null || !stack.isEmpty()) {
//                if (cur != null) {
//                    list.add(cur.val);
//                    stack.push(cur);
//                    cur = cur.right;
//                } else {
//                    cur = stack.pop();
//                    cur = cur.left;
//                }
//            }
//            Collections.reverse(list);
//            return list;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}