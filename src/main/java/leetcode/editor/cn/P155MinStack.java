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

//Java：最小栈
public class P155MinStack {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);

        MinStack solution = new P155MinStack().new MinStack();

        System.out.println();
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

        private int[] array;
        private int capacity = 5;
        private int size;
        private int minValue;


        /**
         * initialize your data structure here.
         */
        public MinStack() {
            array = new int[capacity];
            size = 0;
        }

        private int getSize() {
            return size;
        }

        private boolean isFull() {
            return size >= capacity;
        }

        private boolean isEmpty() {
            return size == 0;
        }

        private void resize() {
            int[] newArray = new int[capacity * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }

        public void push(int x) {
            if (isFull()) {
                resize();
            }
            array[size] = x;
            size = size + 1;
        }

        public void pop() {
            if (isEmpty()) {
                return;
            }
            size = size - 1;
        }

        public int top() {
            if (isEmpty()) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            int val = array[size];
            size = size - 1;
            return val;
        }

        public int getMin() {
            return minValue;
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