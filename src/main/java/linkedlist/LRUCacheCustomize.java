
package linkedlist;

import java.util.HashMap;

/**
 * 自己造轮子，哈希+双向链表
 * 参考：https://leetcode-cn.com/problems/lru-cache/solution/lru-ce-lue-xiang-jie-he-shi-xian-by-labuladong/
 */
public class LRUCacheCustomize {
    private HashMap<Integer, DoubleList.Node> map;
    private DoubleList cache;

    public LRUCacheCustomize(int capacity) {
        map = new HashMap<Integer, DoubleList.Node>();
        cache = new DoubleList(capacity);
    }

    public int get(int k) {
        boolean isContain = map.containsKey(k);
        if (!isContain) {
            return -1;
        }
        DoubleList.Node node = map.get(k);
        int v = node.getVal();
        cache.deleteNode(node);
        cache.insertToHead(node);
        return v;
    }

    public void put(int k, int v) {
        DoubleList.Node node = new DoubleList.Node(k, v);
        boolean isContain = map.containsKey(k);
        if (isContain) {
            // 存在此值
            DoubleList.Node existsNode = map.get(k);
            cache.deleteNode(existsNode);
        } else {
            // 不存在此值
            if (cache.isFull()) {
                // 链表满
                cache.deleteTail();
                map.remove(k);
            }
            // 链表没有满
            map.put(k, node);
        }
        cache.insertToHead(node);
    }

    public void printAll() {
        cache.printAll();
    }

    public static void main(String[] args) {
        LRUCacheCustomize lru = new LRUCacheCustomize(3);
        int v = lru.get(1);
        System.out.println("1 -> " + v);
        lru.put(1,1);
        lru.printAll();
        lru.put(2,2);
        lru.printAll();
        lru.put(3,3);
        lru.printAll();
        v = lru.get(2);
        lru.printAll();
        lru.put(1,3);
        lru.printAll();
    }


}
