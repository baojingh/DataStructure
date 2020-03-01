package tree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: hebj
 * @Date: 2020/2/29 20:00
 * @ Description: 树中任意节点的值都大于左树中每个节点的值，都小于右树中每个节点的值
 */
public class BinarySearchTree {

    private Node tree;

    /**
     * 二叉查找树插入流程：
     * 1 插入节点数值大于节点，且右子树为空，则将此节点插入右侧，
     * 2 如果不为空，则遍历右子树，直到找到插入位置。
     */
    public void insert(int data) {

        Node newNode = new Node(data);
        if (tree == null) {
            tree = newNode;
            return;
        }
        // 获取树的根节点
        Node p = this.tree;
        while (p != null) {
            // 节点值大于要插入的值
            if (p.data > data) {
                if (p.left == null) {
                    p.left = newNode;
                    return;
                } else {
                    // 继续遍历左子树
                    p = p.left;
                }
            } else {
                if (p.right == null) {
                    p.right = newNode;
                    return;
                } else {
                    //继续遍历右子树
                    p = p.right;
                }
            }
        }
    }

    /**
     * 1 判断节点是否等于目标值，如果相等就返回
     * 2 目标值大于节点，遍历右子树
     * 3 目标值小于节点，遍历左子树
     *
     * @param data
     * @return
     */
    public Node find(int data) {
        Node p = this.tree;
        if (p == null) {
            return null;
        }
        while (p != null) {
            if (p.data == data) {
                return p;
            }
            if (p.data > data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    /**
     * 寻找子树中的最小值
     *
     * @return
     */
    private Node findMin(Node tree) {
        Node p = tree;
        if (p == null) {
            return null;
        }
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    /**
     * 寻找子树中的最大值
     *
     * @return
     */
    private Node findMax(Node tree) {
        Node p = tree;
        if (p == null) {
            return null;
        }
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    /**
     * 根据数值删除树中节点：
     * 1 此节点没有子节点，直接将其父节点的这个位置设置为null
     * 2 此节点包含一个子节点，将其父节点指向其子节点
     * 3 此节点包含左右节点，先找到右子树中的最小节点，替换到删除节点位置，并将最小节点删除，此最小节点没有子节点
     *
     * @param data
     */
    public void delete(int data) {
        Node p = this.tree;
        Node parent = this.tree;
        if (p == null) {
            return;
        }

        while (p != null && p.data != data) {
            // 节点不为空且此节点不是目标节点
            parent = p;
            if (p.data > data) {
                p = p.left;
            } else if (p.data < data) {
                p = p.right;
            }
        }
        if (p == null) {
            return;
        }
        // 节点不为空，那就说明p就是目标节点
        // 先判断p没有子节点情况，删除叶子节点











    }

    /**
     * 中序遍历输出所有元素
     * 输出的二叉查找树全部是有序的
     */
    public void middleOrder(Node tree) {
        Node p = tree;
        if (p == null) {
            return;
        }
        middleOrder(p.left);
        System.out.println(p.data);
        middleOrder(p.right);
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(2);
        tree.insert(9);
        tree.insert(3);
        tree.insert(7);
        tree.middleOrder(tree.tree);
        Node min = tree.findMin(tree.tree);
        Node max = tree.findMax(tree.tree);
        System.out.println(min.data);
        System.out.println(max.data);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
