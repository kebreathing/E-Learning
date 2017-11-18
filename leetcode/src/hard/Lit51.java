package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lit51 {

    private int[][] dir = {
            {-1,-1},{-1,1},{1,-1},{1,1}
    };

    // N-Queen N皇后问题：棋盘大小为n*n
    // 皇后不能在同一行同一列或同一个斜杠
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n == 0) return res;

        char[][] board = buildBoard(n);
        put(0, board, res);

        return res;
    }

    private void put(int row, char[][] board, List<List<String>> res){
        if(row == board.length){
            List<String> qs = new ArrayList<>();
            for(int i = 0; i < board.length; i++){
                qs.add(new String(board[i]));
            }
            res.add(qs);
        } else if(row < board.length){
            for(int i = 0; i < board.length; i++){
                if(can_put_in_row(row, board)
                        && can_put_in_col(i, board)
                        && can_put_in_X(row, i, board)){
                    board[row][i] = 'Q';
                    put(row+1, board, res);
                    board[row][i] = '.';
                }
            }
        }
    }

    private boolean can_put_in_X(int row,int col, char[][] board){
        for(int[] d : dir){
            int dx = d[0], dy = d[1];
            int x = row + dx, y = col + dy;
            while(x >= 0 && x < board.length && y >= 0 && y < board.length){
                if(board[x][y] == 'Q')
                    return false;
                x += dx; y += dy;
            }
        }
        return true;
    }

    private boolean can_put_in_col(int col, char[][] board){
        for(int i = 0; i < board.length; i++)
            if(board[i][col] == 'Q')
                return false;
        return true;
    }

    private boolean can_put_in_row(int row, char[][] board){
        for(char c : board[row])
            if(c == 'Q')
                return false;
        return true;
    }

    // 建立棋盘
    private char[][] buildBoard(int n){
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            Arrays.fill(board[i],'.');
        return board;
    }

    public static void main(String[] args){
        Lit51 lit = new Lit51();
        System.out.println(lit.solveNQueens(4));
    }

}
