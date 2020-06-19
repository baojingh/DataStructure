//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树


package leetcode.editor.cn;

import java.util.HashMap;

//Java：实现 Trie (前缀树)
public class P208ImplementTriePrefixTree {
    public static void main(String[] args) {
        Trie trie = new P208ImplementTriePrefixTree().new Trie();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/shi-xian-trie-qian-zhui-shu-by-leetcode/
     */
    class Trie {

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }


        /**
         * Inserts a word into the trie.
         * 设计算法
         * 1 迭代字符串，获得每个字符
         * 2 获得跟节点，这个字符是否存在
         * 3 字符存在，迭代下一个节点
         * 4 字符不存在，创建新的节点，就连接
         */
        public void insert(String word) {
            // 获得头节点
            TrieNode curNode = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                boolean isExists = curNode.containsKey(c);
                if (!isExists) {
                    // 这个节点不存在
                    TrieNode trieNode = new TrieNode();
                    curNode.put(c, trieNode);
                }
                // 类似链表操作，迭代到下一个节点
                curNode = curNode.get(c);
            }
            curNode.isEnd = true;
        }

        /**
         * 存在链接。我们移动到该链接后面路径中的下一个节点，并继续搜索下一个键字符。
         * 不存在链接。若已无键字符，且当前结点标记为 isEnd，则返回 true。否则有两种可能，均返回 false :
         * 还有键字符剩余，但无法跟随 Trie 树的键路径，找不到键。
         * 没有键字符剩余，但当前结点没有标记为 isEnd。也就是说，待查找键只是Trie树中另一个键的前缀。
         */
        public boolean search(String word) {
            TrieNode curNode = root;
            boolean nullFlag = true;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                boolean isExists = curNode.containsKey(c);
                if (isExists) {
                    curNode = curNode.get(c);
                } else {
                    nullFlag = false;
                    break;
                }
            }
            boolean res = nullFlag && curNode.isEnd;
            return res;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode curNode = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                boolean isExists = curNode.containsKey(c);
                if (isExists) {
                    curNode = curNode.get(c);
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    class TrieNode {
        HashMap<Character, TrieNode> map;
        boolean isEnd;

        public TrieNode() {
            this.map = new HashMap<Character, TrieNode>();
            this.isEnd = false;
        }

        public void put(Character c, TrieNode node) {
            map.put(c, node);
        }

        public TrieNode get(Character c) {
            return map.get(c);
        }

        public boolean containsKey(Character key) {
            return map.containsKey(key);
        }

    }


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}