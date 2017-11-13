package medium;

import java.util.ArrayList;
import java.util.List;

public class Lit498 {

    // 按照diagonal的顺序输出
    // 只能适用于方形矩阵
    public int[] findDiagonalOrder(int[][] matrix) {
        // row % 2 == 1 升序
        // row % 2 == 0 降序
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return null;

        int index = 0, m = matrix.length, n = matrix[0].length;
        int[] nums = new int[m*n];

        for(int k = 0; k < 2; k++){
            for(int p = 0; p < n; p++){
                List<Integer> list = new ArrayList<>();
                if(k == 0) {
                    int i = 0, j = p;
                    while(i<m && j >=0){
                        list.add(matrix[i][j]); i++;j--;
                    }
                } else {
                    int i = m-1, j = p+1;
                    while(i>=0 && j<n){
                        list.add(matrix[i][j]); i--;j++;
                    }
                }

                if(p %  2 == 0){
                    // 逆序
                    for(int q = list.size() - 1; q >= 0; q--)
                        nums[index++] = list.get(q);
                } else {
                    // 正序
                    for(int q = 0; q < list.size(); q++)
                        nums[index++] = list.get(q);
                }
            }
        }

        return nums;
    }

    public int[] findDiagonalOrder2(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int[]{};

        int m = matrix.length, n = matrix[0].length;
        int[] result = new int[m*n];
        int row = 0, col = 0, d = 0;
        int[][] dirs = {{-1,1}, {1,-1}};

        for(int i = 0; i < m * n; i++){
            result[i] = matrix[row][col];
            row += dirs[d][0];
            col += dirs[d][1];

            if(row >= m) { row = m - 1; col += 2; d = 1 - d; }
            if(col >= n) { col = n - 1; row += 2; d = 1 - d; }
            if(row < 0)  { row = 0; d = 1 - d; }
            if(col < 0)  { col = 0; d = 1 - d; }
        }

        return result;
    }
    public static void main(String[] args){
        int[][] matrix = {
                {1,3}
        };
        Lit498 lit = new Lit498();
        lit.findDiagonalOrder(matrix);
    }
}
