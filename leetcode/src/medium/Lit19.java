package medium;

public class Lit19 {
    // 快慢指针，fast 先走 n 步，然后slow才开始进行
    // 删除从后往前数的第n项
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // idea: 存在三个指针： pre cur next
        // pre: 被删除节点的前一个节点
        // cur: 应该要删除的节点
        // next: cur之后的节点
        // 通过再分别记录 cur 和 next 的下标之差
        // 如果小于 n 则 next 继续前进,
        // 如果等于 n 且 n.next != null， 三个指针同时向前
        if(head == null) return null;

        int curIdx = 0, nxtIdx = 0;
        ListNode pre = null, cur = head, nxt = head;
        while(nxt != null){
            // 两点之间的下标值小于 n
            while(nxt != null && nxtIdx - curIdx < n){
                nxt = nxt.next;
                nxtIdx++;
            }

            while(nxt != null){
                pre = cur;
                cur = cur.next;
                nxt = nxt.next;
            }
        }
        // 删除第一项： pre == null cur = head
        // 删除非第一项： pre == cur.pre | cur == delete | nxt == null
        if(pre == null){
            head = cur.next;
        } else {
            pre.next = cur.next;
        }
        cur = null;
        return head;
    }

    public static void main(String[] args){

    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) { val = x; }
}