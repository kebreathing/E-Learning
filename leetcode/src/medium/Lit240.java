package medium;

public class Lit240 {

    // 矩阵： 左到右 有序
    //       上到下 有序
    // 寻找target
    public boolean searchMatrix(int[][] matrix, int target) {
        // Binary Search
        int row = matrix.length, col = matrix[0].length;
        for(int i = 0; i < row; i++){
            if(matrix[i][0] <= target && target <= matrix[i][col-1]){
                // 二分搜索
                int begin = 0, end = col-1;
                while(begin <= end){
                    int mid = begin + (end-begin) / 2;
                    if(matrix[i][mid] == target)
                        return true;
                    else if(matrix[i][mid] > target)
                        end = mid - 1;
                    else
                        begin = mid + 1;
                }
            }
        }

        return false;
    }
}
