//给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。 
//
// 示例： 
//
// 输入: ["Hello", "Alaska", "Dad", "Peace"]
//输出: ["Alaska", "Dad"]
//
// 注意： 
//
// 你可以重复使用键盘上同一字符。 
// 你可以假设输入的字符串将只包含字母。 
// Related Topics 哈希表


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

//Java：键盘行
public class P500KeyboardRow {
    public static void main(String[] args) {
        Solution solution = new P500KeyboardRow().new Solution();
        String[] arr = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        String[] words = solution.findWords(arr);
        System.out.println(Arrays.toString(words));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解释题意
         * 1 字符串数组中，字符串是否在键盘的同一行
         * <p>
         * 设计算法
         * 1 获取键盘中三行字符的位置，自己构建map
         * 2 解析字符串的字符，保留其位置，迭代下一个字符，并与prev比较，
         * 3 如果不相等就说明不相登，false
         * 4 如果相等就继续比较
         * <p>
         * 测试用例
         * 1 ["",""]
         * 2 [" ", " "]
         * 3 ["qwe", "asd", "qaz"]
         * 4 ["qa", "ws"]
         *
         * @param words
         * @return
         */
        public String[] findWords(String[] words) {
            if (words == null || words.length == 0) {
                return new String[]{};
            }
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('z', 3);
            map.put('x', 3);
            map.put('c', 3);
            map.put('v', 3);
            map.put('b', 3);
            map.put('n', 3);
            map.put('m', 3);
            map.put('a', 2);
            map.put('s', 2);
            map.put('d', 2);
            map.put('f', 2);
            map.put('g', 2);
            map.put('h', 2);
            map.put('j', 2);
            map.put('k', 2);
            map.put('l', 2);
            map.put('q', 1);
            map.put('w', 1);
            map.put('e', 1);
            map.put('r', 1);
            map.put('t', 1);
            map.put('y', 1);
            map.put('u', 1);
            map.put('i', 1);
            map.put('o', 1);
            map.put('p', 1);
            // 存储结果字符串
            LinkedList<String> stringlist = new LinkedList<>();
            for (String word : words) {
                // 保存前一个字符对应的位置
                char tmp = word.toLowerCase().charAt(0);
                // 初始化prev第一个字符的位置
                Integer prev = map.get(tmp);
                boolean isLine = true;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.toLowerCase().charAt(i);
                    Integer integer = map.get(c);
                    if (integer != prev) {
                        // 位置不同，将标志位设置成false，便于for循环后面的if判断
                        isLine = false;
                        break;
                    }
                    // 保留上一个字符的位置
                    prev = integer;
                }
                if (isLine) {
                    // 如果是for循环正常结束，说明符合条件；如果执行了break，说明不符合条件
                    stringlist.add(word);
                }
            }
            // 链表转换成数组
            String[] ints = new String[stringlist.size()];
            stringlist.toArray(ints);
            return ints;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}