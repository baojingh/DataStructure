//不使用任何内建的哈希表库设计一个哈希集合 
//
// 具体地说，你的设计应该包含以下的功能 
//
// 
// add(value)：向哈希集合中插入一个值。 
// contains(value) ：返回哈希集合中是否存在这个值。 
// remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。 
// 
//
// 
//示例: 
//
// MyHashSet hashSet = new MyHashSet();
//hashSet.add(1);         
//hashSet.add(2);         
//hashSet.contains(1);    // 返回 true
//hashSet.contains(3);    // 返回 false (未找到)
//hashSet.add(2);          
//hashSet.contains(2);    // 返回 true
//hashSet.remove(2);          
//hashSet.contains(2);    // 返回  false (已经被删除)
// 
//
// 
//注意： 
//
// 
// 所有的值都在 [0, 1000000]的范围内。 
// 操作的总数目在[1, 10000]范围内。 
// 不要使用内建的哈希集合库。 
// 
// Related Topics 设计 哈希表


package leetcode.editor.cn;

//Java：设计哈希集合
public class P705DesignHashset {
    public static void main(String[] args) {
        MyHashSet myHashSet = new P705DesignHashset().new MyHashSet(3);

        myHashSet.remove(2);

        boolean contains = myHashSet.contains(2);
        System.out.println(contains);

        myHashSet.add(1);
        myHashSet.add(2);
        myHashSet.add(3);
        myHashSet.add(4);

        myHashSet.remove(2);

        contains = myHashSet.contains(2);
        System.out.println(contains);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashSet {

        /**
         * 考虑动态扩张与收缩
         */
        int capacity;
        Node[] data;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            this.capacity = 16;
            data = new Node[capacity];
        }

        public void add(int key) {
            int hash = hash(key);
            // 数组中存储的是每个链表的solder节点
            Node solder = data[hash];
            Node newNode = new Node(key, key);
            if (solder == null) {
                // 数组的这个索引处是空
                data[hash] = new Node(-1, -1);
                data[hash].next = newNode;
                return;
            }
            Node cur = solder.next;
            while (cur != null) {
                if (cur.key == key) {
                    // 存在key
                    return;
                }
                cur = cur.next;
            }
            // 不存在此元素
            // 新添加的元素放在链表头部
            newNode.next = data[hash].next;
            data[hash].next = newNode;
        }

        public void remove(int key) {
            int hash = hash(key);
            // 数组中存储的是每个链表的solder节点
            Node solder = data[hash];
            if (solder == null) {
                // 此位置无元素，直接退出
                return;
            }
            Node prev = solder;
            while (prev.next != null) {
                if (prev.next.key == key) {
                    prev.next = prev.next.next;
                    return;
                }
                prev = prev.next;
            }
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            int hash = hash(key);
            Node solder = data[hash];
            if (solder == null) {
                return false;
            }
            Node node = solder.next;
            while (node != null) {
                if (node.key == key) {
                    return true;
                }
                node = node.next;
            }
            return false;
        }

        private int hash(int key) {
            return key % capacity;
        }
    }

    class Node {
        int key;
        int value;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}