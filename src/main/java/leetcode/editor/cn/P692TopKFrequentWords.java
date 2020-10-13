//给一非空的单词列表，返回前 k 个出现次数最多的单词。 
//
// 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。 
//
// 示例 1： 
//
// 
//输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
// 
//
// 
//
// 示例 2： 
//
// 
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k
// = 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
// 
//
// 
//
// 注意： 
//
// 
// 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。 
// 输入的单词均由小写字母组成。 
// 
//
// 
//
// 扩展练习： 
//
// 
// 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。 
// 
// Related Topics 堆 字典树 哈希表


package leetcode.editor.cn;

import java.util.*;

//Java：前K个高频单词
public class P692TopKFrequentWords {
    public static void main(String[] args) {
        Solution solution = new P692TopKFrequentWords().new Solution();
        String[] str = new String[]{"like", "i"};
        List<String> wordList = solution.topKFrequent(str, 1);
        System.out.println(wordList.toString());
        System.out.println("ab".compareTo("ac"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 设计算法
         * 1 创建小顶堆，存放k个单词，并且小定堆支持根据字母顺序排序单词
         * 2 迭代数组元素，基于map统计每个单词出现的次数
         * 3 迭代数组元素，将单词放入小顶堆中，限定小顶堆长度是k
         * 4 将元素键入小顶堆先判断是否长度=k，如果相等就移除堆顶元素，如果没有就继续添加，知道将所有元素迭代完
         * 5 输出堆中的元素到list，插入到0位置
         *
         * 测试用例
         *
         * @param words
         * @param k
         * @return
         */
        public List<String> topKFrequent(String[] words, int k) {



            return null;


        }
























        /**
         * 解释题意
         * 1 字符串数组中，一个单词可能出现多次
         * 2 计算频率最高的前k个单词
         * 3 如果两个单词出现频率相等，就按照字符进行排序
         * 4 数组可能为空null，数组长度可能是0
         * <p>
         * <p>
         * 设计算法
         * 1 使用map计算每个单词出现的次数
         * 2 使用小顶堆存储字符串，按照其在map出现的次数【如果次数相等，就使用字符串的比较大小功能】。
         * 3 小顶堆的长度限定在k【先增加然后删除堆顶元素，即可保证堆内是前k个大的字符串】
         * 4 迭代小顶堆，将元素插入链表中【每次插入0位置，既可保证了逆序输出】
         * 测试用例
         * 1 null
         * 2 []
         * 3 ["", ""]
         * 4 ["", " "]
         * 6 ["aa", "aa", "b"]
         * 5 ["aa","aa","bb","bb", "bc", "bc"]
         *
         * @param words
         * @param k
         * @return
         */
        public List<String> topKFrequent1(String[] words, int k) {
            LinkedList<String> wordList = new LinkedList<>();
            if (words == null || words.length == 0) {
                return wordList;
            }

            HashMap<String, Integer> map = new HashMap<>();
            // 小顶堆
            PriorityQueue<String> queue = new PriorityQueue<String>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int tmp = map.get(o1) - map.get(o2);
                    if (tmp != 0) {
                        // 次数比较
                        // 升序，从小到大
                        return tmp;
                    } else {
                        // 两个单词出现的次数相等，就比较单词中的字符顺序
                        // o2 - o1
                        // 与次数一样，哪个小哪个在前面
                        return o2.compareTo(o1);
                    }
                }
            });
            for (String w : words) {
                // 每个单词出现的次数
                Integer integer = map.getOrDefault(w, 0);
                map.put(w, integer + 1);
            }
            // 所有单词加入小顶堆
            // 优化点：向小顶堆添加k个元素即可
            for (String word : map.keySet()) {
                // 先加元素在删除元素，可以保证小顶堆的最小元素在最前面
                queue.add(word);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            while (queue.size() > 0) {
                String poll = queue.poll();
                // 小顶堆的元素，倒序插入链表
                wordList.add(0, poll);
            }
            return wordList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}