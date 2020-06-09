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

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//Java：重复的DNA序列
public class P187RepeatedDnaSequences {
    public static void main(String[] args) {
        Solution solution = new P187RepeatedDnaSequences().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解释题意
         * 1 一长串字符串，包含多个重复的子字符串
         * 2 计算这些重复的字符串
         * <p>
         * 设计算法
         * 1 窗口长度是10
         * 2
         * <p>
         * 测试用例
         * 1 null
         * 2 ""
         * 3 CCBBCCBB,CCBB
         * 3 AAACCBBWW, CCBB
         * 4 AAACCBBBWWAACCCBBQ, CCBB
         *
         * 复杂度分析
         * 时间复杂度
         *
         * 空间复杂度
         *
         * @param s
         * @return
         */
        public List<String> findRepeatedDnaSequences(String s) {
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