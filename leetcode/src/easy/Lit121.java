package easy;

public class Lit121 {
    // 注意其中隐藏的参数：stock in hand
    // T[i][k][0] = Math.max(T[i][k][0],T[i][k][1] + prices[i])   卖出属于这一次交易
    // T[i][k][1] = Math.max(T[i][k][1],T[i][k-1][0] - prices[i]) 买入属于下一次交易
    // 现在 k 只能为 1， 所以 k-1 为0， 而 T_i00 = 0;
    public int maxProfit(int[] prices) {
        // k = 1
        int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
        for(int price : prices){
//            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, -price);
        }
        return T_ik0;
    }

    public static void main(String[] args){
        Lit121 lit = new Lit121();
        System.out.println(lit.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(lit.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

}
