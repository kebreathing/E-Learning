package easy;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/12/7 13:25
 */
public class Lit234 {
    // 判断链表是否为回文链表
    // 首尾相同
    // 后半部分逆序
    // 前后对比
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // 如果链表长度为偶数：slow.next是后半部分的起点
        // 如果链表长度为奇数：slow就是前后部分的中间
        ListNode former = head;
        ListNode latter = slow.next;
        // 后者逆序
        ListNode pre = null, cur = latter, nxt = latter;
        while(cur != null){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // pre 就是后者的起点
        latter = pre;
        while(former != null && latter != null){
            if(former.val != latter.val)
                return false;
            former = former.next;
            latter = latter.next;
        }
        return true;
    }
}
