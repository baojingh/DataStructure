package hashTable;


import java.util.Map;

/**
 * @Author: hebj
 * @Date: 2020/2/16 13:31
 */
public class HashTableCustomize<K, V> {

    // 散列表默认长度
    private static final int DEFAULT_CAPACITY = 8;

    // 装载因子
    private static final float LOAD_FACTOR = 0.75f;

    // 初始化散列表数组
    private EntryCustomize<K, V>[] table;

    // 实际元素数量
    private int size = 0;

    // 散列表索引数量
    private int use = 0;

    public HashTableCustomize() {
        table = (EntryCustomize<K, V>[])new EntryCustomize[DEFAULT_CAPACITY];
    }

    /**
     * 插入数据
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new EntryCustomize<>(null, null, null);
        }
        EntryCustomize<K, V> tmp = table[index];
        // 新增节点
        if (tmp.next == null) {
            EntryCustomize<K, V> n = new EntryCustomize<>(key, value, null);
            tmp.next = n;
            size = size + 1;
            use = use + 1;
            if (use >= table.length * LOAD_FACTOR) {
                resize();
            }
        } else {
            // 使用链表法解决冲突
        }
    }

    private void resize() {
        EntryCustomize<K, V>[] oldTable = this.table;
        this.table = (EntryCustomize<K, V>[]) new EntryCustomize[this.table.length * 2];
        use = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] == null || oldTable[i].next == null) {
                continue;
            }
            EntryCustomize<K, V> e = oldTable[i];
            while (e.next != null) {
                e = e.next;
                int index = hash(e.key);
                if (table[index] == null) {
                    use = use + 1;
                    // 创建哨兵节点
                    table[index] = new EntryCustomize<>(null, null, null);
                }
                table[index].next = new EntryCustomize<>(e.key, e.value, table[index].next);
            }

        }
        
        
    }

    /**
     * 散列函数
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
        HashTableCustomize<String, String> demo = new HashTableCustomize<>();
        int hash = demo.hash("key");
        System.out.println(hash);
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
