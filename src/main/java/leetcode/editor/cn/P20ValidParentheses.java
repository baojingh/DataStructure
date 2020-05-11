//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Java：有效的括号
public class P20ValidParentheses {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node1.left = node2;
        node1.right = node3;

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        Solution solution = new P20ValidParentheses().new Solution();
        boolean valid = solution.isValid(")]");
        System.out.println(valid);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            int len = s.length();
            if ((len & 1) == 1) {
                return false;
            }
            Map<Character, Character> map = new HashMap<>();
            map.put('[', ']');
            map.put('(', ')');
            map.put('{', '}');

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (c == '{' | c == '[' || c == '(') {
                    stack.push(map.get(c));
                } else if (stack.isEmpty() || (c != stack.pop())) {
                    // 如果是")}"，需要走到这一步进行pop，但是栈是空的，会出错,需要先判断是否为空
                    return false;
                }
            }
            if (stack.isEmpty()) {
                // 栈中的元素全部出栈，说明比较完毕，没有走到false这一步
                return true;
            }
            // 栈还有元素，
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}