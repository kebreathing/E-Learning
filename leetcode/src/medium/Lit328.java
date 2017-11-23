package medium;

import java.util.List;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/23 9:10
 */
public class Lit328 {

    // 将偶数位的结点排在奇数位之后
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;

        ListNode o = head, e = head.next;
        ListNode slow = o, fast = e;
        while(slow != null && fast != null &&slow.next != null && fast.next != null){
            slow.next = slow.next.next;
            slow = slow.next;

            fast.next = fast.next.next;
            fast = fast.next;
        }

        slow.next = e;

        ListNode t = o;
        while(t!=null){
            System.out.print(t.val + " ");
            t = t.next;
        }
        return o;
    }

    public static void main(String[] args){
        ListNode head = null, node = null;
        int[] nums = {1,2,3,4,5,6,7,8};
        for(int i : nums){
            if(head == null){
                head = new ListNode(i);
                node = head;
            } else {
                node.next = new ListNode(i);
                node = node.next;
            }
        }

        Lit328 lit = new Lit328();
        lit.oddEvenList(head);
    }
}
