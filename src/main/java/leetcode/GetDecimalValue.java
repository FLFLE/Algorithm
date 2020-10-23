package leetcode;
/**
 *  给出一个二进制数排成的链表，将它转化为十进制
 * @author zengfanyu
 * @date 2020/10/23 16:21
 */
public class GetDecimalValue {
    public int solution(ListNode head) {
        ListNode temp = head;
        int count = 0;
        int result = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        for(int i = count - 1; i >= 0; i--) {
            result += Math.pow(2,i)*head.val;
            head = head.next;
        }
        return result;
    }
}
