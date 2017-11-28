package medium;

public class Lit48 {

    // 旋转矩阵
    public void rotate(int[][] matrix) {
        if(matrix == null)
            return;

        if(matrix.length != matrix[0].length)
            return;

        int m = matrix.length;
        // 顺时针旋转： 先上下swap，再对角线swap
        reverse_up_down(matrix);
        // 对角线swap
        for(int i = 0; i <matrix.length; i++){
            for(int j = i + 1; j < matrix.length; j++){
                swap(i, j, matrix);
            }
        }

    }

    private void reverse_up_down(int[][] matrix){
        int i = 0, j = matrix.length - 1;
        while(i < j){
            int[] t = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = t;
            i++;
            j--;
        }
    }


    private void swap(int i, int j, int[][] matrix){
        int t = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = t;
    }

    // 1 2 3       7 4 1
    // 4 5 6       8 5 2
    // 7 8 9       9 6 3

    // (0,0) (0,2) (2,2) (2,0) (0,0)
    // (0,1) (1,2) (2,1) (1,0) (0,1)
}
