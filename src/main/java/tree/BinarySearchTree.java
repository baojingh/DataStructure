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
                } else {
                    // 继续遍历左子树
                    p = p.left;
                }
            } else {
                if (p.right == null) {
                    p.right = newNode;
                } else {
                    //继续遍历右子树
                    p = p.right;
                }
            }
        }
    }

    public static void main(String[] args) {

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    class Node {
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
