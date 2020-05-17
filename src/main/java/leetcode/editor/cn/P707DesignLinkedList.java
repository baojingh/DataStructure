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

    public class ListNode {
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
         */
        public int get(int index) {
            if (index < 0 || index >= size || size == 0) {
                return -1;
            }
            ListNode prev = solder;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            return prev.next.val;
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
         */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                addAtHead(val);
                return;
            }
            ListNode node = new ListNode(val);
            ListNode pre = solder;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            ListNode n = pre.next;
            node.next = n;
            pre.next = node;
            size = size + 1;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         * <p>
         * 0 先考虑正常情况，在考虑异常情况/边界情况
         * 1 index 负数-头节点
         * 2 index 0 - 头节点
         * 3 index 正数 - 正常插入
         * 4 index = size - 插入链表尾
         * 5 index > size - 不操作
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            ListNode pre = solder;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            ListNode n = pre.next;
            pre.next = n.next;
            n.next = null;
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