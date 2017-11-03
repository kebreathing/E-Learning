package courses;

import java.util.Scanner;

public class LongestSubSequance {

    // abccd aecd
    //      a b c c d
    //    0 0 0 0 0 0
    // a  0 1 1 1 1 1
    // e  0 1 1 1 1 1
    // c  0 1 1 2 2 2
    // d  0 1 1 2 2 3
    public static int longest(String a, String b){
        if((a == null && b == null) || b == null || b.length() == 0) return 0;

        // 动态规划
        int[][] matrix = new int[b.length() + 1][a.length() + 1];
        for(int i = 0; i < b.length(); i++){
            for(int j = 0; j < a.length(); j++){
                if(b.charAt(i) == a.charAt(j)){
                    matrix[i+1][j+1] = matrix[i][j] + 1;
                } else {
                    matrix[i+1][j+1] = Math.max(matrix[i+1][j],matrix[i][j+1]);
                }
            }
        }
        return matrix[b.length()][a.length()];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] numstr = sc.nextLine().split(" ");
            System.out.println(longest(numstr[0],numstr[1]));
        }
        sc.close();
    }
}
