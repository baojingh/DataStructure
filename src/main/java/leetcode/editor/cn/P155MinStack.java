//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计


package leetcode.editor.cn;

import java.util.Stack;

//Java：最小栈
public class P155MinStack {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);

        MinStack solution = new P155MinStack().new MinStack();
//        solution.push(2);
//        solution.push(3);
//        solution.push(4);
//        solution.push(5);
//        solution.push(6);

        int top = solution.top();
        System.out.println(top);

        solution.pop();

        int top2 = solution.top();
        System.out.println(top2);
        System.out.println(solution.getMin());

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
    class MinStack {

        /**
         * 使用两个栈，一个存放正常的数据，另一个存放最小值
         */
        private Stack<Integer> originStack;
        private Stack<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            // 存储原始数据
            originStack = new Stack<Integer>();
            // 存储顺序数据，栈顶到栈底依次增大，栈顶元素最小
            minStack = new Stack<Integer>();
        }

        public void push(int x) {
            originStack.push(x);
            if (minStack.size() == 0) {
                // 第一次入栈
                minStack.push(x);
            } else {
                // 最小栈中有数据，判断最小栈的栈顶元素是入栈元素的大小关系
                // x比较大，则不操作最小栈；x比较小，将x也胶乳最小栈
                Integer peek = minStack.peek();
                if (peek >= x) {
                    minStack.push(x);
                }
            }
        }

        public void pop() {
            // 对栈正常出栈
            if (originStack.size() < 1) {
                return;
            }
            if (minStack.size() < 1) {
                return;
            }
            Integer pop = originStack.pop();
            Integer minValue = minStack.peek();
            if (minValue.equals(pop)) {
                // 如果出栈的元素==最小栈元素，就把最小栈出栈
                minStack.pop();
            }
        }

        public int top() {
            if (originStack.size() < 1) {
                try {
                    throw new IllegalAccessException();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            return originStack.peek();
        }

        /**
         * 出栈或者
         *
         * @return
         */
        public int getMin() {
            if (originStack.size() < 1) {
                try {
                    throw new IllegalAccessException();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            Integer pop = minStack.peek();
            return pop;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}