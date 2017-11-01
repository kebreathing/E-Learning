package medium;


public class Lit378 {

    // 找到矩阵中的第k小元素
    // 矩阵有序，从左到右递增，从上往下递增
    // 参数 k 始终有效
    public int kthSmallest(int[][] matrix, int k) {
        // search space 搜索空间的改变
        // index or range
        int lo = matrix[0][0], hi = matrix[matrix.length-1][matrix[0].length-1] + 1; // [lo, hi)
        while(lo < hi){
            // mid 必然是矩阵的中间元素
            int mid = lo + (hi - lo) / 2;
            // 统计 count 个数，j 表示列数
            int count = 0, j = matrix[0].length - 1; // 列数
            // 行遍历
            for(int i = 0; i < matrix.length; i++){

                // 统计比 mid 小的元素的个数
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j+1);
            }

            // 如果元素格式小于 k， 则后半部分
            // 元素个数大于 k，则前半部分
            if(count < k) lo = mid + 1;
            else          hi = mid;
        }

        return lo;
    }

}
