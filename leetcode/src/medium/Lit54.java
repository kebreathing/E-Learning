package medium;

import java.util.ArrayList;
import java.util.List;

public class Lit54 {

    // 顺时针输出矩阵元素
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> seq = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return seq;
        int m = matrix.length, n = matrix[0].length;
        int ul = 0, ur = n - 1, dl = 0, dw = m - 1;

        // ul -> ur; ur -> dw; dw -> dl; dl -> ul;
        int cnt = m * n;
        while(seq.size() < cnt){

            int i = ul;
            while(seq.size() < cnt && i <= ur) seq.add(matrix[ul][i++]); // 1 2 3

            i = ++ul;
            while(seq.size() < cnt && i <= dw) seq.add(matrix[i++][ur]);

            i = --ur;
            while(seq.size() < cnt && i >= dl) seq.add(matrix[dw][i--]);

            i = --dw;
            while(seq.size() < cnt && i >= ul) seq.add(matrix[i--][dl]);
            ++dl;
        }

        return seq;
    }

    public static void main(String[] args){

        int[][] matrix = {
//                {1,2,3},{4,5,6},{7,8,9}
                {2,3}
        };

        Lit54 lit = new Lit54();
        System.out.println(lit.spiralOrder(matrix));

    }
}
