//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 313 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.P100SameTree.TreeNode;

import java.util.*;

//Java：二叉搜索树中的众数
public class P501FindModeInBinarySearchTree {
    //public class JianZhiFindModeInBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new P501FindModeInBinarySearchTree().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        boolean isVisited;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

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
         * 二叉搜索树，中序遍历
         *
         * @param root
         * @return
         */
        public int[] findMode(TreeNode root) {
            HashMap<Integer, Integer> map = new HashMap<>();
            List<Integer> list = midSearch(root);
            for (Integer ele : list) {
                map.put(ele, map.getOrDefault(ele, 0) + 1);
            }

            int max = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer value = entry.getValue();
                if (value > max) {
                    max = value;
                }
            }

            LinkedList<Integer> resList = new LinkedList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer value = entry.getValue();
                if (value == max) {
                    resList.add(entry.getKey());
                }
            }

            int[] arr = new int[resList.size()];
            int i = 0;
            for (int ele : resList) {
                arr[i++] = ele;
            }

            return arr;
        }

        private List<Integer> midSearch(TreeNode root) {
            LinkedList<Integer> list = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            root.isVisited = false;
            stack.push(root);
            while (stack.size() > 0) {
                TreeNode pop = stack.pop();
                if (!pop.isVisited) {
                    /**
                     * 中序遍历顺序：左-中-右
                     */

                    if (pop.right != null) {
                        pop.right.isVisited = false;
                        stack.push(pop.right);
                    }

                    pop.isVisited = true;
                    stack.push(pop);


                    if (pop.left != null) {
                        pop.left.isVisited = false;
                        stack.push(pop.left);
                    }

                } else {
                    /**
                     * 处理数据
                     */
                    list.add(pop.val);
                }
            }
            return list;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}













































