package medium;

import java.util.Arrays;

public class Lit518 {
    // 硬币找钱：
    // amount：找钱数
    // coins：现在拥有的硬币币值（可以使用任意数量)
    // dfs 暴力破解法超时
    public int change(int amount, int[] coins) {
        if(amount == 0 || coins == null || coins.length == 0)
            return 0;
        Arrays.sort(coins);

        // dp
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }

    private int dfs(int index, int target, int[] coins){
        if(target == 0)
            return 1;

        int cnt = 0;
        for(int i = index; i < coins.length && target >= coins[i]; i++){
            cnt += dfs(i, target - coins[i], coins);
        }
        return cnt;
    }

    public static void main(String[] args){
        Lit518 lit = new Lit518();
        System.out.println(lit.change(10,new int[]{10}));
        System.out.println(lit.change(5,new int[]{1,2,5}));
    }

}
