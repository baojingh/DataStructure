//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;

import java.util.LinkedList;

//Java：将有序数组转换为二叉搜索树
public class P108ConvertSortedArrayToBinarySearchTree {
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
        Solution solution = new P108ConvertSortedArrayToBinarySearchTree().new Solution();
        TreeNode treeNode = solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(treeNode.left.val);
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
        public TreeNode sortedArrayToBST(int[] nums) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            LinkedList<Integer> startList = new LinkedList<>();
            LinkedList<Integer> endList = new LinkedList<>();
            int len = nums.length;
            int mid = 0;
            if (len == 0) {
                return null;
            }
            TreeNode root = new TreeNode(0);
            queue.offer(root);
            startList.offer(0);
            endList.offer(len);
            while (queue.size() > 0) {
                Integer start = startList.poll();
                Integer end = endList.poll();
                mid = (start + end) >>> 1;
                TreeNode node = queue.poll();
                node.val = nums[mid];
                if (start < mid) {
                    // 相当于占位符，将值为0的节点放在左子节点上，等待node.val=nums[mid]覆盖
                    node.left = new TreeNode(0);
                    queue.offer(node.left);
                    startList.offer(start);
                    endList.offer(mid);
                }
                if (mid + 1 < end) {
                    // 相当于占位符，将值为0的节点放在右子节点上，等待node.val=nums[mid]覆盖
                    node.right = new TreeNode(0);
                    queue.offer(node.right);
                    startList.offer(mid + 1);
                    endList.offer(end);
                }
            }
            return root;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}