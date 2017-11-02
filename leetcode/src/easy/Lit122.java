package easy;

public class Lit122 {

    //  可以交易无限次
    // T[i][k][0] = Math.max(T[i][k][0], T[i][k][1] + price)
    // T[i][k][1] = Math.max(T[i][k][1], T[i][k-1][0] - price)
    // 为什么 k-1 和 k 没有区别？
    public int maxProfit(int[] prices) {
        int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
        for(int price : prices){
            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_old - price);
        }

        return T_ik0;
    }
}
