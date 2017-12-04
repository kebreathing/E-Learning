package medium;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/12/2 10:57
 */
public class Lit61 {

    // 旋转k个位
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;

        int len = 0;
        ListNode h = head, t = head;
        while(t.next != null){
            t = t.next;
            len++;
        }

        // 取模
        k = k % len;
        ListNode newh = head, pre = null;
        while(k > 0){
            pre = newh;
            newh = newh.next;
        }

        t.next = h;
        pre.next = null;
        return newh;

    }
}
