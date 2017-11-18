package medium;

public class Lit59 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int seq = 0;
        int ul = 0, ur = n - 1, dl = 0, dr = n - 1;
        while(seq < n*n){
            int index = ul;
            while(index <= ur) matrix[ul][index++] = ++seq;
            ul++;
            index = ul;
            while(index <= dr) matrix[index++][ur] = ++seq;
            ur--;
            index = ur;
            while(index >= dl) matrix[dr][index--] = ++seq;
            dr--;
            index = dr;
            while(index >= ul) matrix[index--][dl] = ++ seq;
            dl++;
        }

        return matrix;
    }

    public static void main(String[] args){
        Lit59 lit = new Lit59();
        lit.generateMatrix(4);
    }
}
