package leetcode;
/**
 * 判断链表是否为回文链表
 * 思路1：将链表的值移存到数组中，用双指针遍历数组
 * 思路2：将链表压入栈，比较正向和反向序列的值是否一样
 */

import java.util.ArrayList;
import java.util.Stack;

/**
 * 判断链表是否为回文链表
 * @author zengfanyu
 * @date 2020/10/23 15:39
 */
public class IsPalindrome {
    public boolean solution1(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            arr.add(current.val);
            current = current.next;
        }
        int front = 0;
        int tail = arr.size() - 1;
        while (front < tail) {
            if (!arr.get(front).equals(arr.get(tail))) {
                return false;
            }
            front++;
            tail--;
        }
        return true;
    }

    public boolean solution2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != head.val) {
                return false;
            }
            head = head.next;
        }return true;
    }
}
