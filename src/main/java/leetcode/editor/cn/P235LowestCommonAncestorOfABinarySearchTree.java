//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
// Related Topics 树 
// 👍 565 👎 0


package leetcode.editor.cn;

//Java：二叉搜索树的最近公共祖先
public class P235LowestCommonAncestorOfABinarySearchTree {
    //public class JianZhiLowestCommonAncestorOfABinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new P235LowestCommonAncestorOfABinarySearchTree().new Solution();
        TreeNode p = new TreeNode(2);
        TreeNode root = p;
        TreeNode q = new TreeNode(1);
        root.left = q;
        TreeNode treeNode = solution.lowestCommonAncestor(root, p, q);
        System.out.println(treeNode.val);
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

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        /**
         * 二叉搜索树特点：
         * 1. 所有节点的左子树中的所有节点值小于此节点值；右子树中的所有节点值大于此节点值
         * 2. 中序遍历二叉搜索树，得到的是递增序列
         * <p>
         * 设计算法
         * 1. 如果n>q,n>p，如果再去迭代右子树，得到的数值一直会比较大，永远找不到。说明n应该去左子树遍历
         * 2. 如果n<q,n<p，说明n应该去右子树遍历
         * 3. 其他情况，那就说明分叉点就是n，也是最近的公共节点
         *
         * @param root
         * @param p 在前
         * @param q 在后
         * @return
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode pointer = root;
            while (pointer != null) {
                if (pointer.val > p.val && pointer.val > q.val) {
                    pointer = pointer.left;
                } else if (pointer.val < p.val && pointer.val < q.val) {
                    pointer = pointer.right;
                } else {
                    return pointer;
                }

            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}