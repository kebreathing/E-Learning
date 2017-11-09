package hard;

import medium.Lit31;

import java.util.ArrayList;
import java.util.List;

public class Lit37 {

    // 数独游戏
    // 填充
    // 1. 该行是否已经存在
    // 2. 该列是否已经存在
    // 3. 该分区是否已经存在
    public void solveSudoku(char[][] board) {
        dfs(board);
    }

    private boolean dfs(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(!row_contains(i, c, board)
                                && !col_contains(j, c, board)
                                && !partition_contains(i,j,c,board)){
                            board[i][j] = c;
                            if(dfs(board)){
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    // 如果所有的选项都不行，那就要退出!!
                    // 这种情况要考虑！！
                    return false;
                }
            }
        }
        return true;
    }


    // 行是否包含
    private boolean row_contains(int row, char fill, char[][] board){
        for(char ch: board[row])
            if(ch == fill)
                return true;
        return false;
    }

    // 列是否包含
    private boolean col_contains(int col, char fill, char[][] board){
        for(int i = 0; i < board.length; i++)
            if(board[i][col] == fill)
                return true;
        return false;
    }

    // 分区是否包含
    private boolean partition_contains(int row, int col, char fill, char[][] board){
        int px = (row / 3) * 3;
        int py = (col / 3) * 3;
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if(board[px+i][py+j] == fill)
                    return true;
        return false;
    }

    private static void println(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0;j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},
        };
        Lit37 lit = new Lit37();
        println(board);
        lit.solveSudoku(board);
        println(board);
    }
}


select_destinations(){
    _schudle() {
        _get_all_hosts(){

        }
    }
}
