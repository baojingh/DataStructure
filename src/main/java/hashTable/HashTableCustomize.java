package hashTable;


import java.util.Map;

/**
 * @Author: hebj
 * @Date: 2020/2/16 13:31
 */
public class HashTableCustomize<K, V> {

    // 散列表默认长度
    private static final int DEFAULT_CAPACITY = 5;
    // 装载因子
    private static final float LOAD_FACTOR = 0.8f;

    // 初始化散列表数组
    private EntryCustomize<K, V>[] table;

    // 实际元素数量
    private int size = 0;

    // 散列表索引数量
    private int use = 0;

    public HashTableCustomize() {
        table = (EntryCustomize<K, V>[]) new EntryCustomize[DEFAULT_CAPACITY];
    }

    /**
     * 插入数据
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        int index = hash(key);
        // 数组中存储的是(null,null,next),next是指向链表的。
        // 数组初始化完成后，每个index位置的元素都是null
        if (table[index] == null) {
            // 对每个index的元素初始化成(null,null,next)
            table[index] = new EntryCustomize<>(null, null, null);
        }
        EntryCustomize<K, V> tmp = table[index];
        // 按照索引位置获取元素，如果索引位置处的元素，没有后续节点，即next==null，说明可以将新元素插入next位置
        // 插入成功后，查看是否超出阀值，超出就resize
        // 新增节点
        if (tmp.next == null) {
            EntryCustomize<K, V> n = new EntryCustomize<>(key, value, null);
            tmp.next = n;
            size = size + 1;
            use = use + 1;
//            if (use >= table.length * LOAD_FACTOR) {
//                resize();
//            }
        } else if (tmp.next != null) {
            // 使用链表法解决冲突
            // 此处将do-while改写成while
            while (tmp.next != null) {
                tmp = tmp.next;
                // 如果key相同，则覆盖
                if (tmp.key == key) {
                    tmp.value = value;
                    return;
                }
            }
            // 获取原链表第一个节点
            EntryCustomize<K, V> temp = table[index].next;
            // 创建新的节点，插入表头
            table[index].next = new EntryCustomize<>(key, value, temp);
            size = size + 1;
        }
    }

    private void resize() {
        EntryCustomize<K, V>[] oldTable = this.table;
        this.table = (EntryCustomize<K, V>[]) new EntryCustomize[this.table.length * 2];
        use = 0;
        for (int i = 0; i < oldTable.length; i++) {
            EntryCustomize<K, V> e = oldTable[i];
            // 原数组中没有数据的，或者数据是(null,null,null)，就略过，不需要放入新数组
            if (e == null || e.next == null) {
                continue;
            }
            while (e.next != null) {
                e = e.next;
                int index = hash(e.key);
                if (table[index] == null) {
                    // 新数组index位置未被初始化
                    use = use + 1;
                    // 创建哨兵节点
                    table[index] = new EntryCustomize<>(null, null, null);
                }
                // 新数组中数组元素头节点元素
                EntryCustomize<K, V> next = table[index].next;
                // 新元素插入头部
                table[index].next = new EntryCustomize<>(e.key, e.value, next);
            }
        }
    }

    public void remove(K key) {
        int index = hash(key);
        EntryCustomize<K, V> e = table[index];
        // e==null说明数组初始化完成，全部是null
        // e.next == null 说明数组初始化成(null, null,next) 但是没有新的元素
        if (e == null || e.next == null) {
            return;
        }
        EntryCustomize pre;
        EntryCustomize<K, V> headNode = table[index];
        while (e.next != null) {
            pre = e;
            e = e.next;
            if (e.key == key) {
                pre.next = e.next;
                size = size - 1;
                // 删除链表节点后，此链表只剩下一个头节点(null,nuklk,null)
                // use代表什么意思？
                if (headNode.next == null) {
                    use = use - 1;
                }
                return;
            }
        }
    }

    public V get(K key) {
        int index = hash(key);
        EntryCustomize<K, V> e = table[index];
        // e==null说明数组初始化完成，全部是null
        // e.next == null 说明数组初始化成(null, null,next) 但是没有新的元素
        if (e == null || e.next == null) {
            return null;
        }
        // 去链表中获取节点，真正的元素没有存储在数组中，均存在了以数据元素为头节点的链表中，因此
        while (e.next != null) {
            e = e.next;
            if (key == e.key) {
                return e.value;
            }
        }
        // 链表中不存在这个key
        return null;
    }

    /**
     * 散列函数
     *
     * @param k
     * @return
     */
    private int hash(Object k) {
        int h;
        if (k == null) {
            return 0;
        }
        h = k.hashCode();
        int tmp = (h >>> 16);
        return (h ^ tmp) % table.length;
    }

    public static void main(String[] args) {
        HashTableCustomize<Integer, String> demo = new HashTableCustomize<>();
        demo.put(1, "a");
        demo.put(2, "b");
        demo.put(3, "c");
        demo.put(4, "d");
        demo.put(5, "e");
        demo.put(6, "f");
        demo.put(7, "g");

        String s = demo.get(3);
        System.out.println(s);
    }

    static class EntryCustomize<K, V> {
        private K key;
        private V value;
        private EntryCustomize<K, V> next;

        public EntryCustomize(K key, V value, EntryCustomize<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public EntryCustomize() {
        }
    }


}
