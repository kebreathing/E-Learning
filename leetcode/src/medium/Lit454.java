package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lit454 {

    // 和刚刚的题目类似 组合最后的和为0
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                map.put(A[i] + B[j], map.getOrDefault(A[i]+B[j],0) + 1);
            }
        }

        int res = 0;
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                res += map.getOrDefault(-1 * (C[i]+D[j]),0);
            }
        }
        return res;
    }


    public static void main(String[] args){
        int[] A = {1, 2};
        int[] B = {-1, -2};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        Lit454 lit = new Lit454();
        System.out.println(lit.fourSumCount(A,B,C,D));
    }
}
