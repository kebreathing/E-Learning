package medium;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/23 9:53
 */
public class Lit147 {
    // 插入排序：对LinkedList做插入排序
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode h = new ListNode(Integer.MIN_VALUE), cur = head;
        while(cur != null){
            ListNode tmp = cur;
            cur = cur.next;
            ListNode nod = h;
            ListNode pre = null;
            // 排序
            while (nod != null && nod.val <= tmp.val){
                pre = nod;
                nod = nod.next;
            }
            // 链的最后 or 合适的位置
            if(nod == null) {
                pre.next = tmp;
                pre.next.next = null;
            } else {
                tmp.next = pre.next;
                pre.next = tmp;
            }
        }


        h = h.next;
        return h;
    }

    public static void main(String[] args){
//        int[] nums = {1, 5, 3, 8, 2, 4};
        int[] nums = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        ListNode head = null;
        ListNode node = null;
        for(int n : nums){
            if(head == null){
                head = new ListNode(n);
                node = head;
            } else {
                node.next = new ListNode(n);
                node = node.next;
            }
        }

        Lit147 lit = new Lit147();
        lit.insertionSortList(head);
    }
}
