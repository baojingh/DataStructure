//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。 
//
// 示例 1: 
//
// 
//输入:
//"tree"
//
//输出:
//"eert"
//
//解释:
//'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
// 
//
// 示例 2: 
//
// 
//输入:
//"cccaaa"
//
//输出:
//"cccaaa"
//
//解释:
//'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//注意"cacaca"是不正确的，因为相同的字母必须放在一起。
// 
//
// 示例 3: 
//
// 
//输入:
//"Aabb"
//
//输出:
//"bbAa"
//
//解释:
//此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//注意'A'和'a'被认为是两种不同的字符。
// 
// Related Topics 堆 哈希表


package leetcode.editor.cn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Java：根据字符出现频率排序
public class P451SortCharactersByFrequency {
    public static void main(String[] args) {
        Solution solution = new P451SortCharactersByFrequency().new Solution();
        String frequencySort = solution.frequencySort("tree");
        System.out.println(frequencySort);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String frequencySort(String s) {
            if (s == null) {
                return "";
            }
            HashMap<Character, Integer> map = new HashMap<>();
            PriorityQueue<Character> heap = new PriorityQueue<>(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    // 大顶堆
                    return map.get(o2) - map.get(o1);
                }
            });
            int len = s.length();
            for (int i = 0; i < len; i++) {
                Character c = s.charAt(i);
                Integer integer = map.getOrDefault(c, 0);
                // 不可用这个，如果c已经在map存在，就不再执行put操作
                // map.putIfAbsent(c, integer + 1);
                map.put(c, integer + 1);
            }

            for (Character key : map.keySet()) {
                heap.offer(key);
            }

            StringBuilder builder = new StringBuilder();
            while (heap.size() > 0) {
                Character character = heap.poll();
                Integer count = map.get(character);
                for (int i = 0; i < count; i++) {
                    builder.append(character);
                }
            }
            return builder.toString();
        }





























        /**
         * 解释题意
         * 1 字符串中每个字符出现的次数
         * 2 按照出现次数排序
         * 3 重新输出按照次数的字符
         * <p>
         * <p>
         * 设计算法
         * 1 使用hashMap存储每个字符出现的次数
         * 2 将hashmap中的元素存入大顶堆【按照出现次数排序】
         * 3 迭代大顶堆的元素，按照其在map中的出现次数，使用StringBuilder存储相应次数字符
         * <p>
         * 测试用例
         * 1 null
         * 2 ""
         * 3 " "
         * 4 "adbbcdd"
         * 5 "aa"
         * 6 "a"
         * <p>
         * 复杂度分析
         * 时间复杂度：O(n)
         * 空间复杂度：O(n)
         *
         * @param s
         * @return
         */
        public String frequencySort_1(String s) {
            // 每个字符出现的次数
            HashMap<Character, Integer> map = new HashMap<>();
            // 拼接后的字符串
            StringBuilder builder = new StringBuilder();
            // 大顶堆
            PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    // 降序
                    int tmp = map.get(o2) - map.get(o1);
                    return tmp;
                }
            });
            for (int i = 0; i < s.length(); i++) {
                // 字符出现的次数
                char c = s.charAt(i);
                int count = map.getOrDefault(c, 0);
                map.put(c, count + 1);
            }
            for (Map.Entry<Character, Integer> m : map.entrySet()) {
                // 大顶堆存储出现频率由高到低的字符
                queue.add(m.getKey());
            }
            while (queue.size() > 0) {
                // 大顶堆弹出字符，获取出现次数
                Character poll = queue.poll();
                while (map.get(poll) > 0) {
                    builder.append(poll);
                    // 输出一次，相应次数减少一次
                    map.put(poll, map.get(poll) - 1);
                }
            }
            return builder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}



































