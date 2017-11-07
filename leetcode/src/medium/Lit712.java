package medium;

public class Lit712 {

    // s1：字符串1
    // s2：字符串2
    // 删除字母，变成相同字符串，要求是删除的字母的ACSII之和最小
    // 实际上：找到两者字典序最大的子序列（而非子字符串）
    // 字符串 s1 和 s2 的长度大小没有规定
    // 动态规划的问题：由长度变成了和大小
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();

        // 初始化第一行和第一列设定为字符串中个字母的ascii值
        int sum1 = 0, sum2 = 0;
        int[][] matrix = new int[m+1][n+1];
        for(int i = 0; i < m; i++) sum1 += s1.charAt(i);
        for(int i = 0; i < n; i++) sum2 += s2.charAt(i);

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){

                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    // 字符相同
                    matrix[i][j] = matrix[i-1][j-1] + s1.charAt(i-1);
                } else {
                    // 字符不同
                    // 等于 其上 和 其左 最大项
                    matrix[i][j] = Math.max(matrix[i][j-1], matrix[i-1][j]);
                }
            }
        }

        int max = matrix[m][n];
        return sum1 + sum2 - 2 * max;
    }

    public static void main(String[] args){
        Lit712 lit = new Lit712();
        System.out.println(lit.minimumDeleteSum("sea","eat"));
        System.out.println(lit.minimumDeleteSum("delete","leet"));
    }
}
