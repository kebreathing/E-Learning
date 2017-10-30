package medium;

import java.util.Random;

public class Lit382 {

    ListNode head;
    Random random;

    public Lit382(ListNode h) {
        head = h;
        random = new Random();
    }

    // 蓄水池抽样算法
    // 给出一饿数据流，这个数据流的长度很大或者未知
    // 并且对该数据流中数据只能访问一次，请写出随机
    // 选择算法，使得数据流中所有数据被选中的概率相
    // 同。
    // 对于未结束的数据 n-1，按概率 1/n-1 进行选择
    // 对于全体数据 n， 每个元素被选择的概率应为 1/n
    // 所以对前 n-1 个元素而已，要进行概率相乘，
    // 即 1/(n-1) * ((n-1)/n) = 1/n
    public int getRandom() {

        ListNode c = head;
        int r = c.val;
        for(int i=1;c.next != null;i++){

            c = c.next;
            // 选择 i 的概率为  1/i
            // 不选择 i 的概率为 1/(i-1)
            // 选择就意味着替换！ 不选择就意味着保留！
            if(random.nextInt(i + 1) == i)
                r = c.val;
        }

        return r;
    }
}
