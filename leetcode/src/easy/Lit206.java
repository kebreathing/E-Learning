package easy;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/12/7 13:20
 */
public class Lit206 {
    // 链表逆序
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;

        ListNode pre = null, cur = head, nxt = head;
        while(cur != null){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
