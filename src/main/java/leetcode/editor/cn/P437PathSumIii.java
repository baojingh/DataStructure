//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树


package leetcode.editor.cn;

import java.util.LinkedList;

//Java：路径总和 III
public class P437PathSumIii {
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
        Solution solution = new P437PathSumIii().new Solution();

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
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        /**
         * 不考虑输出路径，使用广度优先遍历
         * 2020-05-08思路未理清
         * <p>
         *     https://leetcode-cn.com/problems/path-sum-iii/solution/pythonying-yong-zhan-de-die-dai-by-luanz/
         * 构建一个节点栈的数据结构，数据形式为（node，*node所有可能路径和的列表*），这里node所有可能路径和的列表允许重复值，代表不同路径计算得到相同结果。
         * 从栈中取出一个数据，即(节点，节点的路径和列表)
         * 初始化当前节点下的左/右节点路径和列表，sumLeft, sumRight
         * 对该节点的路径和sums列表遍历，判断：
         * 该路径和是否等于目标值，若相等则res += 1
         * 如果左节点存在，则当前结果s的基础上加上左节点的值，加入到sumLeft中
         * 对右节点做相同工作
         * 如果左节点存在，则在栈中加入一个新的值（node.left，sumLeft）,其中此处的sumLeft除了在根节点的遍历基础上，增加以此节点为路径起点的结果，即node.left.val
         * 对右节点做相同工作
         * 直至栈为空，输出结果
         *
         * @param root
         * @param sum
         * @return
         */
        public int pathSum(TreeNode root, int sum) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            LinkedList<LinkedList<Integer>> pathStack = new LinkedList<>();
            int count = 0;
            if (root == null) {
                return count;
            }

            LinkedList<Integer> tmp = new LinkedList<>();
            tmp.offer(root.val);
            pathStack.offer(tmp);

            queue.offer(root);
            while (queue.size() > 0) {
                TreeNode node = queue.poll();
                LinkedList<Integer> linkedList = pathStack.poll();
                System.out.println(linkedList.toString());

                LinkedList<Integer> leftSumList = new LinkedList<>();
                LinkedList<Integer> rightSumList = new LinkedList<>();

                for (Integer val : linkedList) {
                    if (val == sum) {
                        count = count + 1;
                    }
                    if (node.left != null) {
                        leftSumList.offer(val + node.left.val);
                    }
                    if (node.right != null) {
                        rightSumList.offer(val + node.right.val);
                    }
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    leftSumList.offer(node.left.val);
                    pathStack.offer(leftSumList);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    rightSumList.offer(node.right.val);
                    pathStack.offer(rightSumList);
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}