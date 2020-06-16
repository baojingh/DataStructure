//不使用任何内建的哈希表库设计一个哈希映射 
//
// 具体地说，你的设计应该包含以下的功能 
//
// 
// put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。 
// get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。 
// remove(key)：如果映射中存在这个键，删除这个数值对。 
// 
//
// 
//示例： 
//
// MyHashMap hashMap = new MyHashMap();
//hashMap.put(1, 1);          
//hashMap.put(2, 2);         
//hashMap.get(1);            // 返回 1
//hashMap.get(3);            // 返回 -1 (未找到)
//hashMap.put(2, 1);         // 更新已有的值
//hashMap.get(2);            // 返回 1 
//hashMap.remove(2);         // 删除键为2的数据
//hashMap.get(2);            // 返回 -1 (未找到) 
// 
//
// 
//注意： 
//
// 
// 所有的值都在 [0, 1000000]的范围内。 
// 操作的总数目在[1, 10000]范围内。 
// 不要使用内建的哈希库。 
// 
// Related Topics 设计 哈希表


package leetcode.editor.cn;

//Java：设计哈希映射
public class P706DesignHashmap {
    public static void main(String[] args) {
        MyHashMap myHashMap = new P706DesignHashmap().new MyHashMap();
        System.out.println(myHashMap.get(1));

        myHashMap.put(1, 2);
        myHashMap.put(1, 3);
        myHashMap.put(2, 3);
        System.out.println(myHashMap.get(1));

        myHashMap.remove(2);
        System.out.println(myHashMap.get(1));


        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashMap {

        private int N = 100;
        private Node[] data;


        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            data = new Node[N];
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            int hashKey = hash(key);
            Node solder = data[hashKey];
            Node n = new Node(key, value);
            if (solder == null) {
                data[hashKey] = new Node(-1, -1);
                data[hashKey].next = n;
            } else {
                // 新加入的元素，放在链表头部，因为新加入元素更有可能被访问
                Node head = solder.next;
                Node cur = head;
                while (cur != null) {
                    if (cur.key == key) {
                        // 更新key对应的value，然后返回
                        cur.value = value;
                        return;
                    }
                    cur = cur.next;
                }
                // 循环结束，没有在这个链表发现相同key的节点
                // 添加到头节点
                n.next = head;
                solder.next = n;
            }
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            int hashKey = hash(key);
            Node solder = data[hashKey];
            if (solder == null) {
                return -1;
            }
            // 在链表中迭代节点
            Node cur = solder.next;
            while (cur != null) {
                if (cur.key == key) {
                    return cur.value;
                }
                cur = cur.next;
            }
            return -1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            int hashKey = hash(key);
            Node solder = data[hashKey];
            if (solder == null) {
                return;
            }
            Node prev = solder;
            while (prev.next != null) {
                if (prev.next.key == key) {
                    // 暂时存储被删除节点
                    Node delNode = prev.next;
                    prev.next = prev.next.next;
                    // 被删除节点的next置为null
                    delNode.next = null;
                    return;
                }
                prev = prev.next;
            }
        }

        private int hash(int key) {
            return key % N;
        }


        class Node {
            private int key;
            private int value;
            private Node next;

            public Node() {

            }

            public Node(int key, int value) {
                this();
                this.key = key;
                this.value = value;
            }
        }


    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}