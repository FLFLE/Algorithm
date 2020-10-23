package algorithm.linkedList;

/**
 * @author zengfanyu
 * @date 2020/3/17 23:01
 * 使用快慢指针同时遍历链表找中间节点
 * （还可拓展到找到任意分点的节点）
 */
public class SearchMiddleNode extends MyLinkedList {
    public static Node search_middle_node(Node head) {
        if (head == null) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
