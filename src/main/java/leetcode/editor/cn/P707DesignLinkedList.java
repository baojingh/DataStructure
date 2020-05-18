//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
//
// 在链表类中实现这些功能： 
//
// 
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
// 
//
// 
//
// 示例： 
//
// MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
// 
//
// 
//
// 提示： 
//
// 
// 所有val值都在 [1, 1000] 之内。 
// 操作次数将在 [1, 1000] 之内。 
// 请不要使用内置的 LinkedList 库。 
// 
// Related Topics 设计 链表


package leetcode.editor.cn;


//Java：设计链表
public class P707DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList solution = new P707DesignLinkedList().new MyLinkedList();
        solution.addAtIndex(0, 0);
        solution.addAtIndex(1, 1);
        solution.addAtIndex(2, 2);
//        solution.addAtIndex(-1, -1);
//        solution.addAtIndex(2, 2);
//        int i = solution.get(-2);
//        int j = solution.get(3);
        solution.deleteAtIndex(3);
        System.out.println();

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class MyLinkedList {
        private ListNode solder;
        private int size;


        /**
         * https://leetcode-cn.com/problems/design-linked-list/solution/java-shi-xian-jian-duan-yi-dong-by-nan-jing-shi-di/
         */
        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            solder = new ListNode(-1);
            size = 0;
        }

        private int size() {
            return size;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         * <p>
         * 解释题意
         * 1 索引要在合理正确的范围内
         * 2 根据索引查询链表节点值
         * <p>
         * <p>
         * 设计算法
         * 1 增加/删除/修改均使用solder，未来便有基于统一的模式进行迭代节点
         * 2 从solder开始迭代，到达目标节点的前一个节点
         * 3 手动迭代到目标节点
         * 4 获取目标节点的值
         * <p>
         * <p>
         * 测试用例
         * 1 空链表
         * 2 一个节点。index：-1，0，1
         * 3 两个节点。idnex：-1，0，1，2
         * <p>
         * 复杂度分析
         * 时间复杂度：O(n)
         * 空间复杂度：O(1)
         */
        public int get(int index) {
            if (index >= size | index < 0) {
                // 索引无效
                return -1;
            }
            ListNode cur = solder;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur.next.val;

        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion,
         * the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        /**
         * Add a node of value val before the index-th node in the linked list.
         * If index equals to the length of linked list, the node will be appended to the end of linked list.
         * If index is greater than the length, the node will not be inserted.
         * <p>
         * 1 index 负数-头节点
         * 2 index 0 - 头节点
         * 3 index 正数 - 正常插入
         * 4 index = size - 插入链表尾
         * 5 index > size - 不操作
         * <p>
         * 解释题意：
         * 链表中插入一个节点，在index位置插入这个元素；
         * 如果idnex大于size，就忽略；index>=0,index<= size,就插入相应位置；index<0,插入头部
         * -1 1 2 3 4 5
         * 0 1 2 3 4 5
         * 设计算法
         * 插入/删除操作都要设置solder
         * 1 从solder节点开始遍历
         * 1 迭代节点，到插入位置前，节点是cur
         * 2 新节点node的next指向cur.next
         * 3 cur.next指向新节点
         * 4 链表个数增加
         * <p>
         * <p>
         * 测试用例
         * 1 空链表
         * 2 一个节点，index：0，1，2
         *
         *
         * <p>
         * 复杂度分析
         * 时间复杂度:O(n)
         * 空间复杂度: O(1)
         */
        public void addAtIndex(int index, int val) {
            ListNode cur = solder;
            if (index > size) {
                return;
            }
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            ListNode node = new ListNode(val);
            node.next = cur.next;
            // 前一个节点指向新增节点
            cur.next = node;
            size = size + 1;

        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         * <p>
         * 解释题意
         * 1 根据链表中的节点索引，删除节点
         * 2 链表长度减1
         * 3 不符合条件的索引，直接结束程序
         * <p>
         * 设计算法
         * 链表增加/删除节点，均使用solder节点
         * 1 遍历节点，到达目标节点之前的一个节点prev
         * 2 得到目标节点target以及其后的节点targetNext
         * 3 将prev的next指向targetNext
         * <p>
         * 测试用例
         * 1 空链表
         * 2 一个节点，删除-1
         * 2 一个节点，删除0
         * 3 一个节点，删除1
         * 4 两个节点。删除0
         * 5 两个节点。删除1
         * 6 三个节点，删除1【正常逻辑】
         * <p>
         * <p>
         * <p>
         * 复杂度：
         * 空间复杂度：O(1)
         * 时间复杂度:O(n)
         * <p>
         * <p>
         * 0 先考虑正常情况，在考虑异常情况/边界情况
         * 1 index 负数-头节点
         * 2 index 0 - 头节点
         * 3 index 正数 - 正常插入
         * 4 index = size - 插入链表尾
         * 5 index > size - 不操作
         */
        public void deleteAtIndex(int index) {
            if (index >= size || index < 0) {
                return;
            }
            // 从solder开始遍历
            ListNode cur = solder;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            //-1 2 3 4 5， index = 2
            //   0 1 2 3
            // cur在此处是目标节点的前一个节点

            // 要删除的目标节点
            ListNode delNode = cur.next;

            // 前置节点指向目标节点后的节点
            cur.next = delNode.next;
            // 便于垃圾回收
            delNode.next = null;
            // 操作元素个数
            size = size - 1;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}