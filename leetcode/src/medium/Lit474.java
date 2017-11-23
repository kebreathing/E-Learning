package medium;

import java.util.*;

public class Lit474 {

    // DP 求解
    public int findMaxForm2(String[] strs, int m, int n) {
        // 当前位置减或不减
        int[][] dp = new int[m+1][n+1];
        for(String str : strs){
            // 由所有m和n都可以减的情况下 进行选择
            int[] count = count(str);
            for(int i = m; i >= count[0]; i--)
                for(int j = n; j >= count[1]; j--)
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i-count[0]][j-count[1]]);
        }
        return dp[m][n];
    }

    private int[] count(String str){
        int[] res = new int[2];
        for (int i=0;i<str.length();i++)
            res[str.charAt(i) - '0']++;
        return res;
    }

    // strs 数组：元素是由0和1组成的字符串
    // m 正整数：表示0的最大使用个数
    // n 正整数：表示1的最大使用个数
    // 求用最多m个0和最多n个1找出能够最多的排列组合顺序，并且组成的字符串存在于 strs中
    // 贪心算法？ 数量最多的话，要求每次都用最少的0和1组合
    int maxCount = Integer.MIN_VALUE;
    public int findMaxForm(String[] strs, int m, int n) {
        // 排序
        Arrays.sort(strs);
        // 转换
        List<Element> eles = new ArrayList<>();
        for(String str : strs)
            eles.add(generate(str));

        // 搜索
        dfs(0,m,n,0,eles);
        return (maxCount == Integer.MIN_VALUE) ? 0 : maxCount;
    }

    // dfs 超时：剪枝
    private void dfs(int i, int m, int n, int count, List<Element> eles){
        // 如何减少重复计算
        for(int j = i; j < eles.size(); j++){
            if(m >= eles.get(j).zeros && n >= eles.get(j).ones && maxCount < eles.size() - j + count) {
                maxCount = Math.max(maxCount, count + 1);
                dfs(j + 1, m - eles.get(j).zeros, n - eles.get(j).ones, count + 1, eles);
            }
        }

    }
    
    private Element generate(String str){
        int zeros = 0, ones = 0, index = 0;
        while(index < str.length()){
            if(str.charAt(index) == '0') zeros++;
            else                         ones++;
            index++;
        }
        return new Element(zeros,ones);
    }

    public static void main(String[] args){

        Lit474 lit = new Lit474();
//        int ans = lit.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 2,3);
//        int ans = lit.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5,3);
//        int ans = lit.findMaxForm(new String[]{"11","11","0","0","10","1","1","0","11","1","0","111","11111000","0","11","000","1","1","0","00","1","101","001","000","0","00","0011","0","10000"}, 90,66);
        int ans = lit.findMaxForm(new String[]{"0","0","0","0","0","1","1","0","1","1","1","0","1","0","1","1","0","0","1","0","1","1","0","1","1","1","1","1","0","1","1","1","1","1","1","0","1","1","0","0","0","0","1","1","0","1"}, 52,12);
        System.out.println(ans);
    }
}

