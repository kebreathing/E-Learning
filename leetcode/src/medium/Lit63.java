package medium;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/20 9:56
 */
public class Lit63 {

    // 找到有多少种不同的路线从左上角，到达右下角
    public int uniquePathsWithObstacles(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        if(matrix[0][0] == 1) return 0;

        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row+1][col+1];
        dp[0][1] = 1;
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(matrix[i-1][j-1] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[row][col];
    }

    public static void main(String[] args){
        int[][] matrix = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

        Lit63 lit = new Lit63();
        System.out.println(lit.uniquePathsWithObstacles(matrix));
    }
}
