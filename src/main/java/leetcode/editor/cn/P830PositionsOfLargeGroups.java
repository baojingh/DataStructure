//在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。 
//
// 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。 
//
// 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。 
//
// 最终结果按照字典顺序输出。 
//
// 示例 1: 
//
// 
//输入: "abbxxxxzzy"
//输出: [[3,6]]
//解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
// 
//
// 示例 2: 
//
// 
//输入: "abc"
//输出: []
//解释: "a","b" 和 "c" 均不是符合要求的较大分组。
// 
//
// 示例 3: 
//
// 
//输入: "abcdddeeeeaabbbcd"
//输出: [[3,5],[6,9],[12,14]] 
//
// 说明: 1 <= S.length <= 1000 
// Related Topics 数组


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：较大分组的位置
public class P830PositionsOfLargeGroups {
    public static void main(String[] args) {
        String S = "abcdddeeeeaabbbcd";
        Solution solution = new P830PositionsOfLargeGroups().new Solution();
        List<List<Integer>> lists = solution.largeGroupPositions(S);
        for (List<Integer> list : lists) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> largeGroupPositions(String S) {
            ArrayList<List<Integer>> arrayList = new ArrayList<>();
            // slow是分组的开始位置；i是分组的结束为止
            int slow = 0;
            int len = S.length();
            for (int i = 0; i < len; i++) {
                // 两种情况会进入if条件
                // 1 i == len - 1 代表如果快指针i已经到达数组尾部即后面不会有元素，就进入if内部
                // 2 出现长度是3
                if (i == len - 1 || S.charAt(i) != S.charAt(i + 1)) {
                    if (i - slow + 1 >= 3) {
                        List<Integer> list = Arrays.asList(slow, i);
                        arrayList.add(list);
                    }
                    slow = i + 1;
                }
            }
            return arrayList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
