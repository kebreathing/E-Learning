package easy;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/30 11:30
 */
public class Lit160 {

    // 找到两链表之间的交集开始的点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        int lena = 0, lenb = 0;
        while(pa!=null){
            pa = pa.next;
            lena++;
        }
        while(pb!=null){
            pb = pb.next;
            lenb++;
        }
        pa = headA;
        pb = headB;
        if(lena<=lenb){
            int len = lenb - lena;
            while(len>0){
                pb = pb.next;
                len--;
            }
        } else {
            int len = lena - lenb;
            while(len>0){
                pa = pa.next;
                len--;
            }
        }
        while(pa!=pb){
            pa = pa.next;
            pb = pb.next;
        }
        return pa;
    }
}
