package utils;

import entity.TreeNode;

import java.util.LinkedList;

/**
 * @Author: hebj
 * @Date: 2020/5/12 23:26
 * @Description:
 */
public class TreeFormatUtils {

    public static void printTreeWithTree(TreeNode root) {
        if (root == null) System.out.println("EMPTY!");
        // 得到树的深度
        int treeDepth = treeHeight(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i++) {
            for (int j = 0; j < arrayWidth; j++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth / 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }

    /**
     * 根据数据，基于广度优先遍历，输出树形
     * input：[1,2,3,4,5]
     * output
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     *
     * @return
     */
    public static void printTree(String[] nums) {
        TreeNode root = createTree(nums);

        if (root == null) System.out.println("EMPTY!");
        // 得到树的深度
        int treeDepth = treeHeight(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i++) {
            for (int j = 0; j < arrayWidth; j++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth / 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }


    public static void main(String[] args) {
//        Integer[] nums = new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        String[] nums = new String[]{"A", "B", "C", "D", "E", "F", "G"};
//        TreeNode root = createTree(nums);
        printTree(nums);
//        System.out.println(hight);
    }


    /**
     * https://www.cnblogs.com/liulaolaiu/p/11744409.html
     */
    private static void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == null) return;
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.val);

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) return;
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }


    /**
     * 1 添加数组首元素（转换成节点对象）到队列
     * 2 队列中的队尾元素出队，取出数组中的元素，转换成节点，添加到其左子节点；
     * 取出数组中的下一个元素，转换成节点添加到其右子节点。这部分是将树中这一层的节点，全部加入队列
     * 3 处理树下一层的节点，注意数组索引；计算下一层节点数量，队列元素个数*2，
     *
     * @param nums
     * @return
     */
    private static TreeNode createTree(String[] nums) {
        int len = nums.length;
        if (len < 1 || nums[0] == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.offer(root);
        // 每一行起始元素在数组中的索引位置
        int startIndex = 1;
        // 当前行的节点数量
        int nodeNum = 2;
        // 数组中剩余元素数量
        int restNum = len - 1;
        while (restNum > 0) {
            for (int i = startIndex; i < startIndex + nodeNum; i = i + 2) {
                TreeNode node = queue.poll();
                if (i > len - 1) {
                    // 指针查处范围，说明数组元素用完了，返回
                    return root;
                }
                if (nums[i] != null) {
                    // 元素为空，就不能添加
                    node.left = new TreeNode(nums[i]);
                    queue.offer(node.left);
                }
                if (i + 1 > len - 1) {
                    // 指针查处范围，说明数组元素用完了，返回
                    return root;
                }
                if (nums[i + 1] != null) {
                    // 元素为空，就不能添加
                    node.right = new TreeNode(nums[i + 1]);
                    queue.offer(node.right);
                }
            }
            startIndex = startIndex + nodeNum;
            restNum = restNum - nodeNum;
            // 队列中的元素个数是这一行的节点个数
            nodeNum = queue.size() * 2;
        }
        return root;
    }

    /**
     * 树的最大深度，根节点到最远节点的节点个数，树的层数
     *
     * @param root
     * @return
     */
    private static int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (queue.size() > 0) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level = level + 1;
        }
        return level;
    }

    /**
     * 树的节点个数
     *
     * @param root
     * @return
     */
    private static int treeNodeNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            level = level + 1;
        }
        return level;
    }

    private int treeWidth(TreeNode root) {
        return 0;
    }


}
