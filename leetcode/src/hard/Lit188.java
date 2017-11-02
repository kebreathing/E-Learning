package hard;

import java.util.Arrays;

public class Lit188 {

    // 最多进行 k 次交易
    public int maxProfit(int k, int[] prices) {
        // 如果 k >= prices.length / 2 可以扩展成 无限个数
        if(k >= prices.length / 2){
            int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
            for(int price : prices){
                int T_ik0_old = T_ik0;
                T_ik0 = Math.max(T_ik0, T_ik1 + price);
                T_ik1 = Math.max(T_ik1, T_ik0_old - price);
            }

            return T_ik0;
        }

        // k < prices.length / 2
        int[] T_ik0 = new int[k+1];
        int[] T_ik1 = new int[k+1];
        Arrays.fill(T_ik1,Integer.MIN_VALUE);

        for(int price : prices){
            // 对 ith 天，进行交易
            // 最多是 k 次交易，所以要对 1-k 次交易都进行一个判断
            for(int j = k; j > 0; j--){
                T_ik0[j] = Math.max(T_ik0[j], T_ik1[j] + price);
                T_ik1[j] = Math.max(T_ik1[j], T_ik0[j-1] - price);
            }
        }

        return T_ik0[k];
    }
}
