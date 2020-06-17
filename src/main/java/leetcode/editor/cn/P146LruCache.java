//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得关键字 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得关键字 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计


package leetcode.editor.cn;

import java.util.HashMap;

//Java：LRU缓存机制
public class P146LruCache {
    public static void main(String[] args) {
        LRUCache solution = new P146LruCache().new LRUCache(2);
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 解释题意
     * 1 查询以及写入的时间复杂度是O(1)
     * <p>
     * <p>
     * <p>
     * 设计算法
     * <p>
     * <p>
     * <p>
     * 测试用例
     */
    class LRUCache {

        // key -> Node(key, val)
        private HashMap<Integer, Node> map;
        // Node(k1, v1) <-> Node(k2, v2)...
        private DoubleList cache;
        // 最大容量
        private int cap;

        public LRUCache(int capacity) {
            this.cap = capacity;
            map = new HashMap<>();
            cache = new DoubleList();
        }

        public int get(int key) {
            if (!map.containsKey(key))
                return -1;
            int val = map.get(key).val;
            // 利用 put 方法把该数据提前
            put(key, val);
            return val;
        }

        public void put(int key, int val) {
            // 先把新节点 x 做出来
            Node x = new Node(key, val);

            if (map.containsKey(key)) {
                // 删除旧的节点，新的插到头部
                cache.remove(map.get(key));
                cache.addFirst(x);
                // 更新 map 中对应的数据
                map.put(key, x);
            } else {
                if (cap == cache.size()) {
                    // 删除链表最后一个数据
                    Node last = cache.removeLast();
                    map.remove(last.key);
                }
                // 直接添加到头部
                cache.addFirst(x);
                map.put(key, x);
            }
        }
    }

    /**
     * 双向链表，方便删除节点
     */
    class DoubleLinkedList {
        Node head;
        Node tail;
        int size;

        public DoubleLinkedList() {
        }

        public DoubleLinkedList(Node head, Node tail, int size) {
            this.head = head;
            this.tail = tail;
            this.size = 0;
        }
    }

    class Node {
        public int key, val;
        public Node next, prev;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    class DoubleList {
        private Node head, tail; // 头尾虚节点
        private int size; // 链表元素数

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // 在链表头部添加节点 x
        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        // 删除链表中的 x 节点（x 一定存在）
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        // 删除链表中最后一个节点，并返回该节点
        public Node removeLast() {
            if (tail.prev == head)
                return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }

        // 返回链表长度
        public int size() {
            return size;
        }
    }

    /**
     * 节点，保存键值对
     * 保存前指针，后指针
     *
     */
//    class Node {
//        private int key;
//        private int value;
//        private Node next;
//        private Node prev;
//
//        public Node(int key, int value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        public Node() {
//        }
//
//        private void deleteNode() {
//
//        }
//
//        private void insertNode(Node newNode) {
//
//        }
//
//    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}