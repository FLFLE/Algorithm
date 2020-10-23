package algorithm.linkedList;

/**
 * @author zengfanyu
 * @date 2020/3/18 10:29
 */
public class MergeTwoSortedLinkedList extends MyLinkedList {
    /**
     * 非递归，采用循环的方式合并
     *
     * @param aHead
     * @param bHead
     * @return
     */
    public static Node merge(Node aHead, Node bHead) {
        if (aHead == null) {
            return bHead;
        }
        if (bHead == null) {
            return aHead;
        }
        Node head;
        Node cur;
        if (aHead.value < bHead.value) {
            head = aHead;
            cur = aHead;
            aHead = aHead.next;
        } else {
            head = bHead;
            cur = bHead;
            bHead = bHead.next;
        }
        while (aHead != null && bHead != null) {
            if (aHead.value < bHead.value) {
                cur.next = aHead;
                aHead = aHead.next;
            } else {
                cur.next = bHead;
                bHead = bHead.next;
            }
            cur = cur.next;
        }
        while (aHead != null) {
            cur.next = aHead;
            bHead = bHead.next;
            cur = cur.next;
        }
        while (bHead != null) {
            cur.next = bHead;
            bHead = bHead.next;
            cur = cur.next;
        }
        return head;
    }

    /**
     * 采用递归合并
     *
     * @param aHead
     * @param bHead
     * @return
     */
    public static Node merge_by_recursion(Node aHead, Node bHead) {
        if (aHead == null) {
            return bHead;
        }
        if (bHead == null) {
            return aHead;
        }
        Node head = null;
        if (aHead.value <= bHead.value) {
            head = aHead;
            head.next = merge_by_recursion(aHead.next, bHead);
        } else {
            head = bHead;
            head.next = merge_by_recursion(aHead, bHead.next);
        }
        return head;
    }
}
