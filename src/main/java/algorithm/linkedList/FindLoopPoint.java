package algorithm.linkedList;

/**
 * @author zengfanyu
 * @date 2020/3/18 13:39
 * 判断一个链表是否有环，并找到环的入口
 * 使用快慢指针，起初同时指向表头，slow每走一步fast走两步
 * 最后一定会在环类相遇并且此时slow还未走完一圈（或恰好走完一圈）
 * 找到入口则是根据几段的长度利用数学关系推导
 * 结论：在链表头和相遇点分别设置一个指针，同时出发，每次走一步
 * 第一次相遇的点就是环入口
 */
public class FindLoopPoint extends MyLinkedList {
    public static Node findLoopPoint(Node head) {
        if (head == null) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        //到这一步时，链表有环，且此时fast和slow都指向相遇点
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
