package medium;

public class Lit74 {
    // 矩阵： 从左到右
    //       下一行第一个比上一行最后一个大
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int row = matrix.length, col = matrix[0].length;
        int i = 0, j = col - 1;
        while(i >= 0 && i < row && j >=0 && j < col){
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }
}
