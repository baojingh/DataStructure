package stack;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: hebj
 * @Date: 2020/2/9 09:49
 */
public class StackLinkedList {

    private Node head;

    /**
     * 入栈操作栈顶元素，不适合使用solder？
     * @param ele
     */
    public void push(int ele) {
        if (head == null) {
            head = new Node(ele, ele, null);
        } else {
            Node node = new Node(ele, Math.min(ele, head.min), null);
            node.next = this.head;
            this.head = node;
        }
    }

    /**
     * 获取栈顶元素
     *
     * @return
     */
    public int pop() {
        if (this.head == null) {
            return -1;
        }
        return head.data;
    }

    /**
     * 获取最小元素
     *
     * @return
     */
    public int min() {
        if (this.head == null) {
            return -1;
        }
        return head.min;
    }

    public void printAll() {
        System.out.println("data in stack");
        Node p = head;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }

    public static void main(String[] args) {
        StackLinkedList stackLinkedList = new StackLinkedList();
        stackLinkedList.push(2);
        stackLinkedList.push(1);
        stackLinkedList.push(3);

        stackLinkedList.printAll();

        int val = stackLinkedList.min();
        System.out.println(val);

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    static class Node {
        private int data;
        private int min;
        private Node next;
    }


}
