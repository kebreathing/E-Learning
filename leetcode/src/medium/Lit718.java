package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Lit718 {
    // 求两数组见出现的最长子序列
    // 记录每一元素出现的下标集合
    // 获取相同元素的下标idx, 获取两数组 idx + 1的元素判断是否一致
    public int findLength(int[] A, int[] B) {
        if(A == null || A.length == 0 || B == null || B.length == 0)
            return 0;

//        Map<Integer,List<Integer>> mapA = getMapping(A);
        Map<Integer,List<Integer>> mapB = getMapping(B);
        int maxlen = 0;
        for(int i = 0; i < A.length; i++){
            // 从 A 的第一个元素出发 == 获得B中 A[i] 元素的集合
            if(mapB.containsKey(A[i]) == false) continue;

            // 如果是相同长度的话，会重复进行
            for(int index: mapB.get(A[i])){
                int ai = i, bj = index, count = 0;
                if(maxlen >= B.length - bj) break;

                while(ai < A.length && bj < B.length
                        && A[ai] == B[bj]){
                    ai++; bj++; count++;
                    maxlen = Math.max(maxlen, count);
                }
            }
        }

        return maxlen;
    }

    private Map<Integer,List<Integer>> getMapping(int[] nums){
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) map.put(nums[i],new LinkedList<>());
            map.get(nums[i]).add(i);
        }
        return map;
    }

    public static void main(String[] args){
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        Lit718 lit = new Lit718();
//        System.out.println(lit.findLength(new int[]{1,2,3,2,1},new int[]{3,2,1,4,7}));
//        System.out.println(lit.findLength(new int[]{1,2,3,2,1},new int[]{5,6,7,8,9}));
        System.out.println(lit.findLength(new int[]{0,0,0,0,0},new int[]{0,0,0,0,0}));
    }
}
