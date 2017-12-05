package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/12/5 11:09
 */
public class Lit733 {

    // 洪水淹没，实际上就是改变其周围的值
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // 四个不同的方向
        int[][] dir = {
                {0,1}, {1,0}, {0,-1}, {-1,0}
        };
        if(image == null || image.length == 0 || image[0].length == 0) return image;
        if(image[sr][sc] == newColor) return image;

        // 使用BFS
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        int original = image[sr][sc];
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                image[cur[0]][cur[1]] = newColor;
                for(int[] d : dir){
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if(x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != original)
                        continue;
                    q.add(new int[]{x, y});
                }
            }
        }
        return image;
    }
}
