package medium;

public class Lit714 {

    // 可以进行多次交易，但是每次交易要给手续费
    public int maxProfit(int[] prices, int fee) {
        long T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
        for(int price : prices){
            long T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price - fee);
            T_ik1 = Math.max(T_ik1, T_ik0_old - price);
        }
        return (int)T_ik0;
    }

    public static void main(String[] args){

    }
}
