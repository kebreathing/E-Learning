package medium;

public class Lit309 {

    // 可以进行无限次，但是每进行一次交易后，要停止一天
    public int maxProfit(int[] prices) {
        // 存在 pre
        int T_ik0_pre = 0, T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
        for(int price: prices){
            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_pre - price);
            T_ik0_pre = T_ik0_old;
        }

        return T_ik0;
    }
}
