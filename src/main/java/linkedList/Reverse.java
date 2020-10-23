package linkedList;

import java.util.Stack;

/**
 * @author zengfanyu
 * @date 2020/3/17 12:24
 */
public class Reverse extends MyLinkedList {
    /**
     * 通过循环反转链表
     *
     * @param head
     * @return
     */
    public static Node reverse(Node head) {
        if (head.next == null || head == null) {
            return head;
        }
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 利用栈先进后出的特点完成反转
     */
    public static Node reverse_by_stack(Node head) {
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head.next = head;
        }
        if (stack.isEmpty()) {
            return null;
        }
        head = stack.pop();
        Node temp = head;
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            //这里把每个弹出来的都作为tail处理
            node.next = null;
            temp.next = node;
            temp = node;
        }
        return head;
    }
}

