package easy;

public class Lit237 {

    public void deleteNode(ListNode node) {
        if(node == null)
            return;

        if(node.next == null){
            node = null;
        }

        ListNode pre = null;
        while(node.next != null){
            node.val = node.next.val;
            pre = node;
            node = node.next;
        }
        pre.next = null;
    }
}
