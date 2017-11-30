package medium;

import java.util.Stack;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/30 19:39
 */
public class Lit445 {

    // 两数相加：以链表形式输入，以链表形式输出
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 初始化
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // 统计各bit元素大小
        for (ListNode node = l1; node != null; s1.push(node.val), node = node.next) ;
        for (ListNode node = l2; node != null; s2.push(node.val), node = node.next) ;

        // 用加法后 求余 再进行除法操作真的是很微妙！
        int sum = 0;
        ListNode list = new ListNode(0);
        while(!s1.isEmpty() || s2.isEmpty()){
            if(!s1.isEmpty()) sum += s1.pop();
            if(!s2.isEmpty()) sum += s2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum/10); // 判断链表头结点是否为0
            head.next = list;
            list = head;
            sum /= 10;
        }
        return list.val == 0? list.next : list;
    }
}
