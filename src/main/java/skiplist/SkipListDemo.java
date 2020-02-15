package skiplist;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: hebj
 * @Date: 2020/2/15 10:29
 */
public class SkipListDemo {

    private static final int MAX_LEVEL = 16;
    private int levelCount = 1;
    private Node head = new Node(MAX_LEVEL);
    private Random r = new Random();

    private void insert2(int value) {
        int level = 1;
        if (head.forwards[0] != null) {
            level = randomLevel();
        }
        if (level > levelCount) {
            levelCount = levelCount + 1;
            level = levelCount;
        }
        Node newNode = new Node(level);
        newNode.data = value;
        Node p = head;
        // 从最大层开始查找，找到前一节点，通过i--移动到下一层继续查找
        for (int i = levelCount - 1; i > -1; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                // 获取前一个节点
                p = p.forwards[i];
            }
            if (level > i) {
                if (p.forwards[i] == null) {
                    p.forwards[i] = newNode;
                } else {
                    Node next = p.forwards[i];
                    p.forwards[i] = newNode;
                    newNode.forwards[i] = next;
                }
            }
        }
    }

    /**
     * 随机level次；如果是基数层数，就+1，防止伪随机
     *
     * @return
     */
    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; i++) {
            if (r.nextInt() % 2 == 1) {
                level = level + 1;
            }
        }
        return level;
    }

    public static void main(String[] args) {

    }

    class Node {
        private int data = -1;
        private Node forwards[];
        private int maxLevel = 0;

        public Node(int level) {
            forwards = new Node[level];
        }

        public Node() {
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{ data: ").append(data);
            sb.append(", levels: ").append(maxLevel);
            sb.append(" }");
            return sb.toString();
        }
    }

}
