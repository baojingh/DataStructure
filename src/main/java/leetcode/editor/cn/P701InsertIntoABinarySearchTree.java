//给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。 
//
// 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。 
//
// 例如, 
//
// 
//给定二叉搜索树:
//
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//和 插入的值: 5
// 
//
// 你可以返回这个二叉搜索树: 
//
// 
//         4
//       /   \
//      2     7
//     / \   /
//    1   3 5
// 
//
// 或者这个树也是有效的: 
//
// 
//         5
//       /   \
//      2     7
//     / \   
//    1   3
//         \
//          4
// 
// Related Topics 树


package leetcode.editor.cn;

//Java：二叉搜索树中的插入操作
public class P701InsertIntoABinarySearchTree {
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
        Solution solution = new P701InsertIntoABinarySearchTree().new Solution();

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
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        /**
         * 二叉搜索树的查找与插入
         * 1比较节点值与目标值大小
         * 2目标值比较大，solder指向节点的右子节点，并保存上一个节点pre
         * 3目标值比较小，solder指向节点的左子节点，并保存上一个节点pre
         * 4当solder是null时，结束循环
         * 5 solder是null，pre是solder的父节点
         * 6 判断pre与目标值大小，并将新插入的节点当作pre的左子节点或者右子节点
         *
         * @param root
         * @param val
         * @return
         */
        public TreeNode insertIntoBST(TreeNode root, int val) {
//            TreeNode newNode = new TreeNode(val);
//            if (root == null) {
//                return newNode;
//            }
//            // 获取树的根节点
//            TreeNode p = root;
//            while (p != null) {
//                // 节点值大于要插入的值
//                if (p.val > val) {
//                    if (p.left == null) {
//                        p.left = newNode;
//                        break;
//                    } else {
//                        // 继续遍历左子树
//                        p = p.left;
//                    }
//                } else {
//                    if (p.right == null) {
//                        p.right = newNode;
//                        break;
//                    } else {
//                        //继续遍历右子树
//                        p = p.right;
//                    }
//                }
//            }
//            return root;

            TreeNode newNode = new TreeNode(val);
            if (root == null) {
                return newNode;
            }
            TreeNode solder = root;
            TreeNode pre = null;
            while (solder != null) {
                pre = solder;
                if (solder.val < val) {
                    solder = solder.right;
                } else {
                    solder = solder.left;
                }
            }
            if (pre.val <= val) {
                pre.right = newNode;
            } else {
                pre.left = newNode;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}