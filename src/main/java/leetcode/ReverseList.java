package leetcode;

import java.util.Stack;

/**
 * @author zengfanyu
 * @date 2020/11/1 17:13
 */
public class ReverseList {
    public ListNode solution(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        if (stack.isEmpty()) {
            return null;
        }
        ListNode node = stack.pop();
        ListNode newHead = node;
        while (!stack.isEmpty()) {
            ListNode tempNode = stack.pop();
            node.next = tempNode;
            node = node.next;
        }
        node.next = null;
        return newHead;
    }


    public ListNode solution2(ListNode head) {
        //新链表
        ListNode newHead = null;
        while (head != null) {
            //先保存访问的节点的下一个节点，保存起来
            //留着下一步访问的
            ListNode temp = head.next;
            //每次访问的原链表节点都会成为新链表的头结点，
            //其实就是把新链表挂到访问的原链表节点的
            //后面就行了
            head.next = newHead;
            //更新新链表
            newHead = head;
            //重新赋值，继续访问
            head = temp;
        }
        //返回新链表
        return newHead;
    }
}