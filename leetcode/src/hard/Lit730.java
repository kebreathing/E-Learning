package hard;

import java.util.TreeSet;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/19 19:14
 */
public class Lit730 {
    // 判断序列中有多少个不同的回文序列
    int DIV = 1000000007;
    // bccb
    public int countPalindromicSubsequences(String S) {
        TreeSet[] characters = new TreeSet[26];

        int len = S.length();
        for (int i = 0; i < 26; i++)
            characters[i] = new TreeSet<Integer>();
        for (int i = 0; i < len; i++) {
            characters[S.charAt(i) - 'a'].add(i); // 记录的是各个字母出现的所有下标
        }

        Integer[][] dp = new Integer[len + 1][len + 1];
        return memo(S, characters, dp, 0, len);
    }


    private int memo(String S, TreeSet<Integer>[] characters, Integer[][] dp, int start, int end) {
        if (start >= end) return 0;
        if (dp[start][end] != null) return dp[start][end];
        long ans = 0;
        for(int i = 0; i < 26; i++){
            // 找到比 start 大或相等的第一个元素
            Integer new_start = characters[i].ceiling(start);
            // 找到比 end 小的第一个元素
            Integer new_end = characters[i].lower(end);
            // 不能越界
            if(new_start == null || new_start >= end) continue;
            ans++;
            if (new_start != new_end) ans++;
            // 为什么 new_start 要+1
            ans += memo(S, characters, dp, new_start+1, new_end);
        }
        dp[start][end] = (int)(ans%DIV);
        return dp[start][end];
    }


}
