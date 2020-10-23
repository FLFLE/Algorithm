package algorithm.linkedList;

/**
 * @author zengfanyu
 * @date 2020/3/18 10:31
 * 改方法可以直接通过遍历得到链表的size，然后转换为从正向删除。
 * 这里使用快慢指针同时遍历
 */
public class DeleteNodeFromEnd extends MyLinkedList {
    public static Node deleteFromEnd(Node head, int k) {
        Node fast = head;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            i++;
        }
        Node slow = head;
        while (fast.next.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
