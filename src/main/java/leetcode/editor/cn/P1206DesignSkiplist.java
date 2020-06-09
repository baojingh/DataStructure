//不使用任何库函数，设计一个跳表。 
//
// 跳表是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想
//与链表相似。 
//
// 例如，一个跳表包含 [30, 40, 50, 60, 70, 90]，然后增加 80、45 到跳表中，以下图的方式操作： 
//
// 
//Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons 
//
// 跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(
//n))，空间复杂度是 O(n)。 
//
// 在本题中，你的设计应该要包含这些函数： 
//
// 
// bool search(int target) : 返回target是否存在于跳表中。 
// void add(int num): 插入一个元素到跳表。 
// bool erase(int num): 在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。 
//
// 
//
// 了解更多 : https://en.wikipedia.org/wiki/Skip_list 
//
// 注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。 
//
// 样例: 
//
// Skiplist skiplist = new Skiplist();
//
//skiplist.add(1);
//skiplist.add(2);
//skiplist.add(3);
//skiplist.search(0);   // 返回 false
//skiplist.add(4);
//skiplist.search(1);   // 返回 true
//skiplist.erase(0);    // 返回 false，0 不在跳表中
//skiplist.erase(1);    // 返回 true
//skiplist.search(1);   // 返回 false，1 已被擦除
// 
//
// 约束条件: 
//
// 
// 0 <= num, target <= 20000 
// 最多调用 50000 次 search, add, 以及 erase操作。 
// 
// Related Topics 设计


package leetcode.editor.cn;

import java.util.Random;

//Java：设计跳表
public class P1206DesignSkiplist {
    public static void main(String[] args) {
        Skiplist skiplist = new P1206DesignSkiplist().new Skiplist();
        skiplist.add(10);
        skiplist.add(20);
        skiplist.add(40);
        skiplist.add(30);

        boolean search = skiplist.search(40);
        System.out.println(search);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Skiplist {
        /**
         * https://leetcode-cn.com/problems/design-skiplist/solution/java-jing-jian-shi-xian-by-stg/
         */

        Node head = new Node(0, null, null);
        Random random = new Random();
        Node[] stack = new Node[64];


        public Skiplist() {

        }

        /**
         * 从左向右，从上到下
         *
         * @param target
         * @return
         */
        public boolean search(int target) {
            // 指针下沉到下一层
            for (Node p = head; p != null; p = p.down) {
                while (p.right != null && p.right.val < target) {
                    // 索引上的节点值小雨目标值，需要指针右移
                    p = p.right;
                }
                // p是本层索引最后一个节点，或者其右侧节点值大于目标值
                if (p.right != null && p.right.val == target) {
                    return true;
                }
            }
            return false;
        }

        /**
         * 1 找到目标位置的前一个节点
         * 2
         *
         * @param num
         */
        public void add(int num) {
            int lv = -1;
            for (Node p = head; p != null; p = p.down) {
                while (p.right != null && p.right.val < num) {
                    p = p.right;
                }
                stack[++lv] = p;
            }
            boolean isInsertUp = true;
            Node downNode = null;
            while (isInsertUp && lv >= 0) {
                Node insert = stack[lv--];
                insert.right = new Node(num, insert.right, downNode);
                downNode = insert.right;
                // 是否在在上一层插入此节点的索引，此处决定了插入的节点是否设置索引层，也就导致跳表的查找时间复杂度最差是O(n)的原因
                isInsertUp = (random.nextInt() & 1) == 0;
            }
            if (isInsertUp) {
                // 创建索引层的节点
                Node tmp = new Node(num, null, downNode);
                Node tmp1 = new Node(0, tmp, head);
                // 跳表的头节点保证在左上方
                head = tmp1;
            }
        }

        public boolean erase(int num) {
            boolean isExists = false;
            for (Node p = head; p != null; p = p.down) {
                while (p.right != null && p.right.val < num) {
                    p = p.right;
                }
                /**
                 * 在每一层，找到目标节点的前一个节点
                 * 如果删除的是索引未知的节点，for循环还会继续下沉到愿链表进行删除
                 *
                 */
                if (p.right != null && p.right.val <= num) {
                    isExists = true;
                    p.right = p.right.right;
                }
            }
            return isExists;
        }

        class Node {
            int val;
            Node right;
            Node down;


            Node(int x) {
                val = x;
            }

            Node(int x, Node right, Node down) {
                val = x;
                this.right = right;
                this.down = down;
            }
        }
    }

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
//leetcode submit region end(Prohibit modification and deletion)

}