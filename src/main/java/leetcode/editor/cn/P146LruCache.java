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
        LRUCache lruCache = new P146LruCache().new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(2, 2);
        lruCache.printAll();

        int i = lruCache.get(2);
        lruCache.printAll();

        lruCache.put(1, 1);
        lruCache.put(4, 1);
        lruCache.printAll();


        lruCache.get(2);
        lruCache.printAll();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 解释题意
     * 1 查询以及写入的时间复杂度是O(1)
     * 2 查询/写入功能可以使用哈希表；频繁使用的元素以及不频繁访问的元素，需要考虑使用链表【本场景需要频繁的调整元素顺序】
     * 3 使用单链表还是双链表？调整节点到链表头或者移除节点时，单链表的时间复杂度是O(n)，不是O(1)，双链表可以满足这一点
     * 测试用例
     */
    class LRUCache {

        HashMap<Integer, Node> map;
        DoubleLinkedList list;
        int capacity;

        public LRUCache() {
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            list = new DoubleLinkedList();
        }

        /**
         * 设计算法
         * 1 map中是否存在这个key，如果不存在，返回-1
         * 2 如果存在key，获得对应的value【Node类型】
         * 3 将此value移动到链表头部。【删除value，并且将其移动到链表头部
         *
         * @param key
         * @return
         */
        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                // map中不存在这个key
                return -1;
            }
            // map中存在这个key
            int tmp = node.value;
            put(key, tmp);
            return tmp;
        }

        /**
         * 设计算法
         * 1 map中是否存在这个key
         * 2 如果不存在，做替换
         * 3 链表长度小于容量，map中存入key-value；链表中将此节点加入链表头部
         * 4 链表长度大于容量，map中存入key-value，移除链表尾节点，链表中将此节点加入链表头部
         * 5 如果存在
         * 6 链表长度小于容量，map中替换key-value，链表中将此节点加入链表头部
         * 7 链表长度大于容量，map中替换key-value，链表中将此节点加入链表头部
         *
         * @param key
         * @param value
         */
        public void put(int key, int value) {
            Node newNode = new Node(key, value);
            Node node = map.get(key);
            if (node != null) {
                // map中存在这个key，value有可能不同，有可能相同
                list.deleteNode(node);
                list.insertHead(newNode);
                map.put(key, newNode);
                return;
            }
            // map中不存在这个key
            if (list.size == capacity) {
                // 链表长度当前已经达到容量值
                // 删除链表尾节点
                // 删除map中的节点
                Node tail = list.deleteLast();
                map.remove(tail.key);
            }
            map.put(key, newNode);
            // 链表长度当前未达到容量值
            list.insertHead(newNode);
        }

        public void printAll() {
            Node cur = this.list.head.next;
            while (cur != null) {
                // 不要输出tail以及head
                if (cur == this.list.tail) {
                    break;
                }
                System.out.println(cur.key + " " + cur.value);
                cur = cur.next;
            }
            System.out.println("**********");

        }


    }

    /**
     * 双向链表，方便删除节点
     */
    class DoubleLinkedList {
        Node head;
        Node tail;
        int size;

        /**
         * 自动创建头节点/尾节点，做好头节点与尾节点的关系
         * 方便增加/删除
         */
        public DoubleLinkedList() {
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            this.tail.prev = this.head;
            this.head.next = this.tail;
            this.size = 0;
        }

        public void deleteNode(Node node) {
            if (node == null) {
                return;
            }
            // 分别获取删除节点的前节点，后节点
            Node next = node.next;
            Node prev = node.prev;
            prev.next = next;
            next.prev = prev;
            size = size - 1;
        }

        /**
         * 删除尾节点
         * 当链表长度达到capacity，才会执行删除尾节点
         * 只有链表中才知道尾节点，map中不知道谁是尾节点，因此这里需要返回尾节点，为map使用
         *
         * @return
         */
        public Node deleteLast() {
            if (this.head == this.tail) {
                return new Node(-1, -1);
            }
            // 根据tail获得尾节点
            Node node = this.tail.prev;
            // deleteNode方法内，及时对node=null，这里不会对node产生影响
            deleteNode(node);
            return node;
        }

        /**
         * 每个节点都会有一进一出两个指针
         *
         * @param node
         */
        public void insertHead(Node node) {
            // 1. 插入节点的前驱 后继节点
            // 2. 后节点的前驱
            // 3. 前节点的后继
            if (node == null) {
                return;
            }
            node.prev = this.head;
            node.next = this.head.next;
            this.head.next.prev = node;
            this.head.next = node;
            size++;
        }
    }


    /**
     * 节点，保存键值对
     * 保存前指针，后指针
     */
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        public Node() {
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}