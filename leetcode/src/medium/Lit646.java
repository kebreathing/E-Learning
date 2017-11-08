package medium;

import java.util.*;

public class Lit646 {

    // 图运算：求最长链！
    // 链的规则： (a,b) (c,d) b < c
    public int findLongestChain(int[][] pairs) {
        // 排序：选择 pair[0] 和 pair[1] 最小的
        if(pairs == null || pairs[0].length == 0) return 0;

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] pair : pairs){
            if(!map.containsKey(pair[0]))
                list.add(pair[0]);                   // 统计 first 元素
            map.put(pair[0], !map.containsKey(pair[0])? pair[1] : Math.min(pair[1], map.get(pair[0])));
        }

        // 排序： 低到高
        Collections.sort(list);

        // 动态规划
        int len = list.size();
        int[][] dp = new int[len+1][len+1];
        dp[0][1] = dp[1][0] = 1;
        for(int i = 1; i <= len; i++){
            int[] p1 = new int[]{list.get(i-1), map.get(list.get(i-1)) };
            for(int j = i; j <= len; j++){
                int[] p2 = new int[]{list.get(j-1), map.get(list.get(j-1))};
                if(i == j){
                    dp[i][j] = dp[i-1][j];
                    continue;
                }

                if(p1[1] < p2[0]){
                    dp[i][j] = dp[i][i] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }


        return dp[len][len];
    }

    // 现有排序做不到双因子排序
    public static void main(String[] args){
        int[][] pair = {
                {1,2},{2,3},{3,4}
//                {-10, -8},{8,9},{-5,0},{6,10},{-6,-4},{1,7},{9,10},{-4,7}
        };
        Lit646 lit = new Lit646();
        System.out.println(lit.findLongestChain(pair));
    }
}
