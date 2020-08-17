//所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究
//非常有帮助。 
//
// 编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。 
//
// 
//
// 示例： 
//
// 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC", "CCCCCAAAAA"] 
// Related Topics 位运算 哈希表


package leetcode.editor.cn;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//Java：重复的DNA序列
public class P187RepeatedDnaSequences {
    public static void main(String[] args) {
        Solution solution = new P187RepeatedDnaSequences().new Solution();
        List<String> list = solution.findRepeatedDnaSequences("AAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCCAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(list);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 设计算法
         * 1 创建窗口长度是10的窗口，slow-fast
         * 2 判断HashSet中是否存在这个字符串，如果不存在，则添加；如果存在则放入结果集
         *
         * 测试用例
         * 1 AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT
         * 2 AAAAACCCCC
         * 3 AAAAACCCC
         * 4 A
         * 5 null
         *
         * @param s
         * @return
         */
        public List<String> findRepeatedDnaSequences(String s) {
            LinkedList<String> resultList = new LinkedList<>();
            if (s == null || s.length() < 10) {
                return resultList;
            }
            int len = s.length();
            int slow = 0;
            int fast = 9;
            HashSet<String> resultSet = new HashSet<>();
            // 使用链表存储所有的子串，如果数据量大会出现超时情况（判断链表是否存在这个元素，要遍历全部节点）
            // 次数应该使用集合，map或者set
            HashSet<String> repeatSet = new HashSet<>();
            for (; fast < len; fast++, slow++) {
                // substring: [)
                String tmp = s.substring(slow, fast + 1);
                if (!repeatSet.contains(tmp)) {
                    repeatSet.add(tmp);
                } else {
                    resultSet.add(tmp);
                }
            }
            resultList.addAll(resultSet);
            return resultList;
        }


















        /**
         * 解释题意
         * 1 一长串字符串，包含多个重复的子字符串
         * 2 计算这些重复的字符串
         * <p>
         * 设计算法
         * 1 窗口长度是10
         * 2 从原字符串0索引开始滑动窗口，落入窗口的子字符串是否在迭代集合中
         * 3 存在，说明这个子字符串出现了至少一次了，放入结果集合中
         * 4 不存在，说明这个子字符串只出现了一次，就将其放入迭代集合中
         * 4 迭代完整个原字符串【注意窗口位置】
         * 5 返回结果字符串，注意去重
         *
         * <p>
         * 测试用例
         * 1 null
         * 2 ""
         * 3 CCBBCCBB,CCBB
         * 3 AAACCBBWW, CCBB
         * 4 AAACCBBBWWAACCCBBQ, CCBB
         * <p>
         * 复杂度分析
         * 窗口长度L，原字符串长度N，N-L+1个子字符串，每个子字符串长度是L，
         * 时间复杂度：O((N-L+1)L),题目已假定L=10，即时间复杂度是O(N)
         * <p>
         * 空间复杂度：集合保存这些子字符串，需要的空间是(N-L+1)L
         * O((N-L+1)L)，题目已假定L=10，即空间复杂度是O(N)
         *
         * @param s
         * @return
         */
        public List<String> findRepeatedDnaSequences_1(String s) {
            List<String> list = new LinkedList<String>();
            // 窗口长度
            int windownLength = 10;
            if (s == null || windownLength > s.length()) {
                return list;
            }

            // 已经访问过的子集
            HashSet<String> seenSet = new HashSet<>();
            // 重复的子集
            HashSet<String> targetSet = new HashSet<>();

            // 字符串长度是len，窗口长度是windownLen，窗口的起始位置到达字符串的 len - windownLength + 1 位置就要停止
            for (int i = 0; i < s.length() - windownLength + 1; i++) {
                // 截取窗口内的子集
                String substring = s.substring(i, i + windownLength);
                if (seenSet.contains(substring)) {
                    //集合中已经包含这个子集，说明是目标元素，添加到目标集合
                    targetSet.add(substring);
                } else {
                    // 集合中不包含当前的子集
                    seenSet.add(substring);
                }
            }
            list.addAll(targetSet);
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}