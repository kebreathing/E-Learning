package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/24 21:53
 */
public class Lit650 {
    // 只允许两种操作
    // 复制：复制当前键盘上所有的A
    // 粘贴：粘贴上一次复制的A
    // 粘贴之后会清空么？
    // 下一次复制，复制多少？
    public int minSteps(int n) {
        int[] dp = new int[n+1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i-1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + (i/j);
                    break;
                }

            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        Lit650 lit = new Lit650();
//        System.out.println(lit.minSteps(1));
//        System.out.println(lit.minSteps(2));
        System.out.println(lit.minSteps(10));
        System.out.println(lit.minSteps(10123));
    }
}
