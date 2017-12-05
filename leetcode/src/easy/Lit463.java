package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/12/5 11:55
 */
public class Lit463 {

    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {
                {0,1}, {1,0}, {0,-1}, {-1,0}
        };

        // 先找到第一个陆地块
        int perimeter = 0;
        int[] node = first(grid, m, n);
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        visited[node[0]][node[1]] = true;
        q.add(node);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] pos = q.poll();
                int sideCount = 0;
                for(int[] d : dir){
                    int x = d[0] + pos[0];
                    int y = d[1] + pos[1];
                    if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0)
                        continue;

                    sideCount++;
                    if(visited[x][y] == false) {
                        visited[x][y] = true;
                        q.add(new int[]{x, y});
                    }
                }
                perimeter += 4 - sideCount;
            }
        }
        return perimeter;
    }

    private int[] first(int[][] grid, int m, int n){
        int i,j;
        for(i = 0; i < m; i++)
            for(j = 0; j < n; j++)
                if(grid[i][j] == 1)
                    return new int[]{i,j};
        return null;
    }
}
