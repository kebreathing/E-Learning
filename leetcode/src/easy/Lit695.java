package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/12/5 12:21
 */
public class Lit695 {

    // 找到矩阵中最大面积的岛屿
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int maxarea = 0;
        boolean[][] visited = new boolean[m][n];
        int[][] dir = {
                {0,1}, {1,0}, {0,-1}, {-1,0}
        };

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] || grid[i][j] == 0) continue;
                visited[i][j] = true;
                Queue<int[]> q = new LinkedList<>();

                int area = 1;
                q.add(new int[]{i, j});
                while(!q.isEmpty()){
                    int size = q.size();
                    for(int k = 0; k < size; k++){
                        int[] node = q.poll();
                        for(int[] d : dir){
                            int x = d[0] + node[0];
                            int y = d[1] + node[1];
                            if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0)
                                continue;

                            if(visited[x][y] == false) {
                                area++;
                                visited[x][y] = true;
                                q.add(new int[]{x, y});
                            }
                        }
                    }
                }

                maxarea = Math.max(maxarea, area);
            }
        }

        return maxarea;
    }
}
